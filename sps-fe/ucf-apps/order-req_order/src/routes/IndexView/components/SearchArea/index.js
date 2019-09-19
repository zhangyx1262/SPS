
import React, {Component} from 'react'
import {actions} from "mirrorx";
import {Col, Row, FormControl, Label, Radio} from "tinper-bee";
import DatePicker from 'bee-datepicker';
import moment from "moment";
import Select from 'bee-select';
import FormList from 'components/FormList';
import FormError from 'components/FormError';
import SearchPanel from 'components/SearchPanel';
import FormControlPhone from 'components/FormControlPhone';
import RefCommon from 'components/RefCommon';
import {addSearchKey} from 'utils';

import './index.less'

const FormItem = FormList.Item;

const layoutOpt = null

class SearchArea extends Component {

    constructor(props) {
        super(props);
        this.state = {}

    }

    componentDidMount(){
        this.props.onRef(this)
    }

    /** 查询数据
     * @param {*} error 校验是否成功
     * @param {object} values 表单数据
     */
    search = () => {
        this.props.form.validateFields(async (err, values) => {
            const {req_orderObj} = this.props;
            const {pageSize} = req_orderObj;
            values.pageIndex = 0;  // 默认回到第一页
            values.pageSize = pageSize;
            addSearchKey(values);
            actions.masterDetailMany.updateState({searchParam: values}); // 将查询数据放在 model里
            await actions.masterDetailMany.loadList(values);
        });
    }

    /**
     * 清空 action里的搜索条件
     */
    reset = () => {
        this.props.form.resetFields();
        actions.masterDetailMany.updateState({searchParam: {}});
    }

    render() {
        const {form} = this.props;
        const {getFieldProps} = form;
        return (
            <SearchPanel
                className="small"
                form={form}
                reset={this.reset}
                search={this.search}>
                <FormList>
                              <FormItem>
        <Label >
            订单编号
        </Label>
        <FormControl disabled={typeof btnFlag != 'undefined' && btnFlag == 2
}
            {
            ...getFieldProps('ro_no', {
                validateTrigger: 'onBlur',
                initialValue: (typeof rowData === 'undefined' || typeof rowData.ro_no === 'undefined') ? "" : rowData.ro_no
,
                rules: [{
                    type:'string',required: true,pattern:/\S+/ig, message: '请输入订单编号',
                }],
                onChange(value) {
if(typeof rowData !== 'undefined'){
    let tempRow = Object.assign({},rowData,{ ro_no: value });
    _this.setState({
        rowData:tempRow
    })
}
                }
            }
            )}
        />
                              </FormItem>
                              <FormItem>
        <Label >
            审核编号
        </Label>
        <FormControl disabled={typeof btnFlag != 'undefined' && btnFlag == 2
}
            {
            ...getFieldProps('rl_no', {
                validateTrigger: 'onBlur',
                initialValue: (typeof rowData === 'undefined' || typeof rowData.rl_no === 'undefined') ? "" : rowData.rl_no
,
                rules: [{
                    type:'string',required: true,pattern:/\S+/ig, message: '请输入审核编号',
                }],
                onChange(value) {
if(typeof rowData !== 'undefined'){
    let tempRow = Object.assign({},rowData,{ rl_no: value });
    _this.setState({
        rowData:tempRow
    })
}
                }
            }
            )}
        />
                              </FormItem>
                              <FormItem>
        <Label >
            采购状态
        </Label>
        <Select disabled={typeof btnFlag != 'undefined' && btnFlag == 2
}
            {
            ...getFieldProps('postate', {
                initialValue: (typeof rowData === 'undefined' || typeof rowData.postate === 'undefined') ? "" : String(rowData.postate)
,
                rules: [{
                    required: true, message: '请选择采购状态',
                }],
                onChange(value) {
if(typeof rowData !== 'undefined'){
    let tempRow = Object.assign({},rowData,{ postate: value });
    _this.setState({
        rowData:tempRow
    })
}
                }
            }
            )}>
            <Option value="">请选择</Option>
                <Option value={ '0' }>待采购</Option>
                <Option value={ '1' }>已采购</Option>
        </Select>
                              </FormItem>
                </FormList>
            </SearchPanel>
        )
    }
}

export default FormList.createForm()(SearchArea)
