/**
 *
 * @title 基础示例
 * @description 基础示例
 *
 */
import React, {Component} from 'react';
import SearchPanel from '../../src';
import {FormControl,Row, Col,Label,FormGroup,Radio} from 'tinper-bee';


class Demo1 extends Component {
    constructor(props){
        super(props);
        this.state={
            state:'all',
            expanded: true
        }
    }
    stateChange(value){
        this.setState({
            state:value
        })
    }
    typeChange(value){
        this.setState({
            type:value
        })
    }
    degreeChange(value){
        this.setState({
            degree:value
        })
    }
    search(){

    }
    clear(){

    }
    onChange = () => {
        this.setState({expanded: !this.state.expanded})
    }
    render() {

        return (
            <SearchPanel
                title='基础示例'
                onSearch={this.search}
                onReset={this.clear}
                expanded={this.state.expanded}
                onChange={this.onChange}
                onPanelChangeStart={status => {
                    console.log(status, "start")
                }}
                onPanelChangeIng={status => {
                    console.log(status, "ing")
                }}
                onPanelChangeEnd={status => {
                    console.log(status, "end")
                }}
                resident={
                    <div className='demo'>
                        <div className="margin-top-10">
                        <span className="demo-item">
                            <label className="demo-label">名称:</label>
                            <FormControl placeholder="请输入名称"/>
                        </span>
                            <span className="demo-item">
                            <label className="demo-label">编码:</label>
                            <FormControl placeholder="请输入编码"/>
                        </span>
                        </div>
                    </div>
                }
            >
                <div className="demo">
                    <div>
                        <label className="demo-label">状态:</label>
                        <Radio.RadioGroup
                            name="state"
                            selectedValue={this.state.state}
                            onChange={this.stateChange.bind(this)}>
                            <Radio.RadioButton value="all">全部</Radio.RadioButton>
                            <Radio.RadioButton value="initial">初始化</Radio.RadioButton>
                            <Radio.RadioButton value="todo">待处理</Radio.RadioButton>
                            <Radio.RadioButton value="doing">处理中</Radio.RadioButton>
                            <Radio.RadioButton  value="done">已完成</Radio.RadioButton>
                            <Radio.RadioButton  value="closed">已完成</Radio.RadioButton>
                        </Radio.RadioGroup>
                    </div>

                    <div className="margin-top-10">
                        <span className="demo-item">
                            <label className="demo-label">名称:</label>
                            <FormControl placeholder="请输入名称"/>
                        </span>
                        <span className="demo-item">
                            <label className="demo-label">编码:</label>
                            <FormControl placeholder="请输入编码"/>
                        </span>
                    </div>
                </div>
            </SearchPanel>
        )
    }
}
export default Demo1;