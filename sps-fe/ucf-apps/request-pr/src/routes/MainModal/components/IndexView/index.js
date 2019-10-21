import React, {Component} from "react";
import {actions} from "mirrorx";
import {Col, Row,  FormControl, Label, Switch, Radio} from "tinper-bee";
import DatePicker from 'bee-datepicker';
import moment from "moment";
import FormList from 'components/FormList';
import FormError from 'components/FormError';
import Select from 'bee-select';
import PopDialog from 'components/Pop';
import FormControlPhone from 'components/FormControlPhone';
import RefCommon from 'components/RefCommon';
import zhCN from "rc-calendar/lib/locale/zh_CN";
import Header from "components/Header";
import queryString from 'query-string';
import Alert from 'components/Alert';
import Button from 'components/Button';
import './index.less'

const FormItem = FormList.Item;

const layoutOpt = null
const {Option} = Select;
const format = "YYYY-MM-DD";
let titleArr = ["新增", "修改", "详情"];

class AddEditpr extends Component {
    constructor(props) {
        super(props);
        this.state = {
            rowData: {},
            btnFlag: 0,
            showPopBackVisible: false
        }
    }
    componentDidMount(){
        const searchObj = queryString.parse(this.props.location.search);
        let { btnFlag: flag, checkTable: checkTable} = searchObj;
        const btnFlag = Number(flag);

        const { prObj, prIndex: currentIndex } = this.props;
        // 防止网络阻塞造成btnFlag显示不正常
        this.setState({btnFlag: btnFlag});
        let rowData = {};
        try {
            // 判断是否重后端请求数据
            if (btnFlag > 0 && checkTable === "pr") {
                this.props.form.resetFields();
                const {list} =prObj;
                rowData = list[currentIndex] || {};
            }
        } catch (error) {
            console.log(error);
        } finally {
            this.setState({rowData});
        }
    }
    /**
     * button关闭Modal 同时清空state
     * @param {Boolean} isSave 判断是否添加或者更新
     */
    onCloseEdit = (isSave) => {
        // 关闭当前 弹框清空当前的state的值，防止下次进入是上一次的数据
        this.setState({rowData: {}, btnFlag: 0});
        this.props.form.resetFields();
    }
    /**
     *  提交信息
     */
    onSubmitEdit = () => {
        const _this = this;
        const {btnFlag}=_this.state;
        this.props.form.validateFields(async (err, values) => {
            if (!err) {
                let {rowData} = _this.state;
                if (rowData && rowData.id) {
                    values.id = rowData.id;
                    values.ts = rowData.ts;
                }
                // 参照处理
                const {dept} = values;
                if (dept) {
                    const {refpk} = JSON.parse(dept);
                    values.dept = refpk;

                }
                // 是否会员，从state中取值
                const {isVip} = rowData;
                values.isVip = isVip;

                if(!isVip){ // 如果不是会员
                    values.grade = 0;
                    values.expirationDate = "";
                }

                try {
                    values.expirationDate = values.expirationDate.format(format);
                } catch (e) {
                }
                values.btnFlag=btnFlag;
                _this.onCloseEdit(true); // 关闭弹框 无论成功失败
                actions.masterDetailMany.savepr(values); //保存主表数据
                //返回
                actions.routing.replace({ pathname: '/' });
            }
        });
    }
     /**
     * 清空
     */
    clearQuery() {
        this.props.form.resetFields();
    }
    /**
     *
     * 返回上一级弹框提示
     * @param {Number} type 1、取消 2、确定
     * @memberof Order
     */
    async confirmGoBack(type) {
        this.setState({ showPopBackVisible: false });
        if (type === 1) { // 确定
            this.clearQuery();
            actions.routing.replace({ pathname: '/' });
        }
    }
     /**
     * 返回
     * @returns {Promise<void>}
     */
    onBack = async () => {
        const { btnFlag } = this.state;
        if (btnFlag === 2) { //判断是否为详情态
            const searchObj = queryString.parse(this.props.location.search);
            let { from } = searchObj;
            switch (from) {
                case undefined:
                    this.clearQuery();
                    actions.routing.replace({ pathname: '/' });
                    break;
                default:
                    window.history.go(-1);
            }

        } else {
            this.setState({ showPopBackVisible: true });
        }
    }
    render() {
        let _this = this;
        const {form, modalVisible} = _this.props;


        const {getFieldProps, getFieldError,} = form;
        const {rowData, btnFlag, showPopBackVisible } = _this.state;

        let isDisabled = btnFlag > 1 ? true : false;

        return (
            <div className="mainContainer">
                <Alert
                    show={showPopBackVisible}
                    context="数据未保存，确定离开 ?"
                    confirmFn={() => {
                        _this.confirmGoBack(1)
                    }}
                    cancelFn={() => {
                        _this.confirmGoBack(2)
                    }} />
                <Header back title={titleArr[btnFlag]}>
                    <div className='head-btn'>
                        <Button shape="border" className="ml8" onClick={_this.onBack}>取消</Button>
                        {(btnFlag !== 2) &&
                        <Button colors="primary" className="ml8" onClick={_this.onSubmitEdit}>保存</Button>
                        }
                    </div>
                </Header>
                <FormList className="formlist">
                                <FormItem>
        <Label className="mast">
            申请单编号
        </Label>
        <FormControl disabled={typeof btnFlag != 'undefined' && btnFlag == 2
}
            {
            ...getFieldProps('pr_no', {
                validateTrigger: 'onBlur',
                initialValue: (typeof rowData === 'undefined' || typeof rowData.pr_no === 'undefined') ? "" : rowData.pr_no
,
                rules: [{
                    type:'string',required: true,pattern:/\S+/ig, message: '请输入申请单编号',
                }],
                onChange(value) {
if(typeof rowData !== 'undefined'){
    let tempRow = Object.assign({},rowData,{ pr_no: value });
    _this.setState({
        rowData:tempRow
    })
}
                }
            }
            )}
        />
        <FormError errorMsg={getFieldError('pr_no')}/>
                                </FormItem>
                                <FormItem>
        <Label className="mast">
            采购品名
        </Label>
        <FormControl disabled={typeof btnFlag != 'undefined' && btnFlag == 2
}
            {
            ...getFieldProps('pname', {
                validateTrigger: 'onBlur',
                initialValue: (typeof rowData === 'undefined' || typeof rowData.pname === 'undefined') ? "" : rowData.pname
,
                rules: [{
                    type:'string',required: true,pattern:/\S+/ig, message: '请输入采购品名',
                }],
                onChange(value) {
if(typeof rowData !== 'undefined'){
    let tempRow = Object.assign({},rowData,{ pname: value });
    _this.setState({
        rowData:tempRow
    })
}
                }
            }
            )}
        />
        <FormError errorMsg={getFieldError('pname')}/>
                                </FormItem>
                                <FormItem>
        <Label >
            采购数量
        </Label>
        <FormControl disabled={typeof btnFlag != 'undefined' && btnFlag == 2
}
            {
            ...getFieldProps('pnum', {
                validateTrigger: 'onBlur',
                initialValue: (typeof rowData === 'undefined' || typeof rowData.pnum === 'undefined') ? "" : rowData.pnum
,
                rules: [{
                    type:'string',required: false,pattern:/\S+/ig, message: '请输入采购数量',
                }],
                onChange(value) {
if(typeof rowData !== 'undefined'){
    let tempRow = Object.assign({},rowData,{ pnum: value });
    _this.setState({
        rowData:tempRow
    })
}
                }
            }
            )}
        />
        <FormError errorMsg={getFieldError('pnum')}/>
                                </FormItem>
                                <FormItem>
        <Label >
            采购单价
        </Label>
        <FormControl disabled={typeof btnFlag != 'undefined' && btnFlag == 2
}
            {
            ...getFieldProps('price', {
                validateTrigger: 'onBlur',
                initialValue: (typeof rowData === 'undefined' || typeof rowData.price === 'undefined') ? "" : rowData.price
,
                rules: [{
                    type:'string',required: false,pattern:/\S+/ig, message: '请输入采购单价',
                }],
                onChange(value) {
if(typeof rowData !== 'undefined'){
    let tempRow = Object.assign({},rowData,{ price: value });
    _this.setState({
        rowData:tempRow
    })
}
                }
            }
            )}
        />
        <FormError errorMsg={getFieldError('price')}/>
                                </FormItem>
                                <FormItem>
        <Label className="datepicker">
            申请时间
        </Label>
    <DatePicker className='form-item' disabled={typeof btnFlag != 'undefined' && btnFlag == 2
}
        format={'YYYY-MM-DD HH:mm:ss'}
        {
        ...getFieldProps('ptime', {
            initialValue: (typeof rowData === 'undefined' || !rowData.ptime || rowData.ptime == 'Invalid date') ? moment() : moment(rowData.ptime),
            validateTrigger: 'onBlur',
            rules: [{
                required: false, message: '请选择申请时间',
            }],
            onChange(value) {
if(typeof rowData !== 'undefined'){
    let tempRow = Object.assign({},rowData,{ ptime: value });
    _this.setState({
        rowData:tempRow
    })
}
            }
        }
        )}
    />
        <FormError errorMsg={getFieldError('ptime')}/>
                                </FormItem>
                                <FormItem>
        <Label className="mast">
            申请状态
        </Label>
        <Select disabled={typeof btnFlag != 'undefined' && btnFlag == 2
}
            {
            ...getFieldProps('pstute', {
                initialValue: (typeof rowData === 'undefined' || typeof rowData.pstute === 'undefined') ? "" : String(rowData.pstute)
,
                rules: [{
                    required: true, message: '请选择申请状态',
                }],
                onChange(value) {
if(typeof rowData !== 'undefined'){
    let tempRow = Object.assign({},rowData,{ pstute: value });
    _this.setState({
        rowData:tempRow
    })
}
                }
            }
            )}>
            <Option value="">请选择</Option>
                <Option value={ '0' }>待申请</Option>
                <Option value={ '1' }>已申请</Option>
                <Option value={ '2' }>已申请/审核已通过</Option>
                <Option value={ '3' }>已申请/审核未通过</Option>
                <Option value={ '4' }>已申请/已采购</Option>
                <Option value={ '5' }>已申请/质检合格</Option>
                <Option value={ '6' }>已申请/质检不合格</Option>
                <Option value={ '7' }>已申请/已退货</Option>
                <Option value={ '8' }>已申请/已入库</Option>
        </Select>
        <FormError errorMsg={getFieldError('pstute')}/>
                                </FormItem>
                </FormList>
            </div>
        )
    }
}

export default FormList.createForm()(AddEditpr);
