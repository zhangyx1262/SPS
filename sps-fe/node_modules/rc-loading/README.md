# rc-loading
[![NPM](https://img.shields.io/badge/npm-v1.0.0-orange.svg)](https://www.npmjs.com/package/rc-loading)

> rc-loading 是一个基于React封装的loading组件;该组件写法模仿ant-design中[Spin](https://ant.design/components/spin-cn/),是其扩展组件

> 本组件 动效 也依赖于 antd 的 [rc-animate](https://motion.ant.design/api/animate) 

> 目前组件支持三种不同的loading样式 详情请见 [CSS实现多种loading](https://github.com/ElonXun/blog/issues/9)

### 更新
> 版本1.0.0 更新时间: 2018-01-14 
### 安装
```
 npm install rc-loading --save
```

### 用法

name | type | default      | description
------- | ---------------- | ---------- | ---------:
spinning  | Boolean | true | 是否显示spinning
type  |  String  | 'fence'       |loading的样式
displayType | String | 'block'  | 内联元素和块元素

**example**

```
import React, { Component } from 'react';
import Loading from 'rc-loading';

class App extends Component {
  constructor(props){
    super(props)
    this.state={
      spinning:false
    }
  }


  render() {
    return (
     <div>
        <Loading spinning={this.state.spinning} displayType={"inlineBlock"}>
          <span>hello loading</span>
       </Loading>
       <span onClick={()=>{
         this.setState({
           spinning:!this.state.spinning,
         })
       }}>点击</span>
     </div>
    );
  }
}

export default App;

```
**效果**

![image](https://github.com/ElonXun/rc-loading/blob/master/assets/image/example_display_inlineBlock.gif)

