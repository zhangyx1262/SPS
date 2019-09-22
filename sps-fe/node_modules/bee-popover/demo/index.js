import { Con, Row, Col } from 'bee-layout';
import { Panel } from 'bee-panel';
import Button from 'bee-button';
import React, { Component } from 'react';
import ReactDOM from 'react-dom';


const CARET = <i className="uf uf-arrow-down"></i>;

const CARETUP = <i className="uf uf-arrow-up"></i>;


var Demo1 = require("./demolist/Demo1");var Demo2 = require("./demolist/Demo2");var DemoArray = [{"example":<Demo1 />,"title":" 气泡卡片默认样式","code":"/**\n *\n * @title 气泡卡片默认样式\n * @description 支持12个位置\n */\n\nimport {Component} from 'react';\nimport { Popover, Button } from 'tinper-bee';\n\n\n class Demo1 extends Component {\n    constructor(props) {\n        super(props);\n    }\n\n    render() {\n        let content = (\n            <div>\n                <h3>消息</h3>\n                <ul>\n                    <li>您的服务器已宕机，请处理。</li>\n                    <li>您的手机已停机，请续费。</li>\n                    <li>你的工资已到账，请查收。</li>\n                </ul>\n            </div>\n        )\n        return (\n            <div style={{position: 'relative', height: 320, marginTop: 100, marginLeft: 250}}>\n                <Popover\n                    placement=\"leftTop\"\n                    content={content}\n                    trigger=\"hover\"\n                    id=\"leftTop\"\n                >\n                    <Button\n                        colors=\"primary\"\n                        style={{\n                            position: 'absolute',\n                            top: 5,\n                            left: 0\n                        }}>左上</Button>\n                </Popover>\n                <Popover\n                    placement=\"left\"\n                    content={content}\n                    trigger=\"hover\"\n                    id=\"left\"\n                >\n                    <Button\n                        colors=\"primary\"\n                        style={{\n                            position: 'absolute',\n                            top: 55,\n                            left: 0\n                        }}>左\n                    </Button>\n                </Popover>\n                <Popover\n                    placement=\"leftBottom\"\n                    content={content}\n                    trigger=\"hover\"\n                    id=\"leftBottom\"\n                >\n                    <Button\n                        colors=\"primary\"\n                        style={{\n                            position: 'absolute',\n                            top: 110,\n                            left: 0\n                        }}>左下</Button>\n                </Popover>\n                <Popover\n                    placement=\"topLeft\"\n                    content={content}\n                    trigger=\"hover\"\n                    id=\"topLeft\"\n                >\n                    <Button\n                        colors=\"primary\"\n                        style={{\n                            position: 'absolute',\n                            top: 0,\n                            left: 100\n                        }}>上左\n                    </Button>\n                </Popover>\n                <Popover\n                    placement=\"top\"\n                    content={content}\n                    trigger=\"hover\"\n                    id=\"top\"\n                >\n                    <Button\n                        colors=\"primary\"\n                        style={{\n                            position: 'absolute',\n                            top: 0,\n                            left: 200\n                        }}>上\n                    </Button>\n                </Popover>\n                <Popover\n                    placement=\"topRight\"\n                    content={content}\n                    trigger=\"hover\"\n                    id=\"topRight\"\n                >\n                    <Button\n                        colors=\"primary\"\n                        style={{\n                            position: 'absolute',\n                            top: 0,\n                            left: 300\n                        }}>\n                        上右\n                    </Button>\n                </Popover>\n                <Popover\n                    placement=\"rightTop\"\n                    content={content}\n                    trigger=\"hover\"\n                    id=\"rightTop\"\n                >\n                    <Button\n                        colors=\"primary\"\n                        style={{\n                            position: 'absolute',\n                            top: 5,\n                            left: 400\n                        }}>右上\n                    </Button>\n                </Popover>\n                <Popover\n                    placement=\"right\"\n                    content={content}\n                    trigger=\"hover\"\n                    id=\"right\"\n                >\n                    <Button\n                        colors=\"primary\"\n                        style={{\n                            position: 'absolute',\n                            top: 55,\n                            left: 400\n                        }}>右</Button>\n                </Popover>\n                <Popover\n                    placement=\"rightBottom\"\n                    content={content}\n                    trigger=\"hover\"\n                    id=\"rightBottom\"\n                >\n                    <Button\n                        colors=\"primary\"\n                        style={{\n                            position: 'absolute',\n                            top: 110,\n                            left: 400\n                        }}>右下</Button>\n                </Popover>\n                <Popover\n                    placement=\"bottomLeft\"\n                    content={content}\n                    trigger=\"hover\"\n                    id=\"bottomLeft\"\n                >\n                    <Button\n                        colors=\"primary\"\n                        style={{\n                            position: 'absolute',\n                            top: 115,\n                            left: 100\n                        }}>下左</Button>\n                </Popover>\n                <Popover\n                    placement=\"bottom\"\n                    content={content}\n                    trigger=\"hover\"\n                    id=\"bottom\"\n                >\n                    <Button\n                        colors=\"primary\"\n                        style={{\n                            position: 'absolute',\n                            top: 115,\n                            left: 200\n                        }}>下</Button>\n                </Popover>\n                <Popover\n                    placement=\"bottomRight\"\n                    content={content}\n                    trigger=\"hover\"\n                    id=\"bottomRight\"\n                >\n                    <Button\n                        colors=\"primary\"\n                        style={{\n                            position: 'absolute',\n                            top: 115,\n                            left: 300\n                        }}>下右</Button>\n                </Popover>\n            </div>\n        )\n    }\n}\n\n","desc":" 支持12个位置","scss_code":".demoPadding{\n  button{\n    margin: 10px;\n  }\n}\n\nul,li{\n  list-style: none;\n}"},{"example":<Demo2 />,"title":" 受控制的气泡卡片","code":"/**\n *\n * @title 受控制的气泡卡片\n * @description 通过设置show，来控制气泡卡片的显示和隐藏\n */\n\nimport {Component} from 'react';\nimport { Popover, Button } from 'tinper-bee';\n\n\nclass Demo2 extends Component {\n    constructor(props) {\n        super(props);\n        this.state = {\n            show: false\n        }\n    }\n\n    handleClose = () => {\n        this.setState({\n            show: false\n        })\n    }\n\n    show = () => {\n        this.setState({\n            show: true\n        })\n    }\n\n    render() {\n        let content = (\n            <div>\n                <p>请确认您的包裹已签收！</p>\n                <div>\n                    <Button\n                        colors=\"primary\"\n                        onClick={ this.handleClose }\n                        size=\"sm\">\n                        关闭\n                    </Button>\n                </div>\n            </div>\n        )\n        return (\n            <div>\n                <Popover\n                    placement=\"right\"\n                    content={content}\n                    show={this.state.show}\n                    id=\"demo2\"\n                >\n                    <Button\n                        colors=\"primary\"\n                        onClick={ this.show }\n                        >确认按钮</Button>\n                </Popover>\n            </div>\n        )\n    }\n}\n\n\n","desc":" 通过设置show，来控制气泡卡片的显示和隐藏"}]


class Demo extends Component {
    constructor(props){
        super(props);
        this.state = {
            open: false
        }
        this.handleClick = this.handleClick.bind(this);
    }
    handleClick() {
        this.setState({ open: !this.state.open })
    }

    render () {
        const { title, example, code, desc, scss_code  } = this.props;
        let caret = this.state.open ? CARETUP : CARET;
        let text = this.state.open ? "隐藏代码" : "查看代码";

        const header = (
            <div>
                {example}
                <Button style={{"marginTop": "10px"}} shape="block" onClick={ this.handleClick }>
                    { caret }
                    { text }
                </Button>
            </div>
        );
        return (
            <Col md={12} >
                <h3>{ title }</h3>
                <p>{ desc }</p>
                <Panel collapsible headerContent expanded={ this.state.open } colors='bordered' header={ header } footerStyle = {{padding: 0}}>
                    <pre><code className="hljs javascript">{ code }</code></pre>
                    { !!scss_code ? <pre><code className="hljs css">{ scss_code }</code></pre> : null }
                </Panel>
            </Col>
        )
    }
}

class DemoGroup extends Component {
    constructor(props){
        super(props)
    }
    render () {
        return (
            <Row>
                {DemoArray.map((child,index) => {

                    return (
                        <Demo example= {child.example} title= {child.title} code= {child.code} scss_code= {child.scss_code} desc= {child.desc} key= {index}/>
                    )

                })}
            </Row>
        )
    }
}

ReactDOM.render(<DemoGroup/>, document.getElementById('tinperBeeDemo'));
