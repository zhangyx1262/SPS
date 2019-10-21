## ac-drawer

[![npm version](https://img.shields.io/npm/v/ac-drawer.svg)](https://www.npmjs.com/package/ac-drawer)
[![NPM downloads](http://img.shields.io/npm/dt/ac-drawer.svg?style=flat)](https://npmjs.org/package/ac-drawer)

### 1. 简介

一个基于react的抽屉组件，可以从上下左右这些侧面弹出一个层，显示特定的内容

### 2. 安装

```javascript
npm install ac-drawer -S
```

### 3. 使用
```javascript
import Drawer from 'ac-drawer';
import 'ac-drawer/dist/ac-drawer.css';
```

```javascript
<Drawer title={'basic drawer'} show={true} placement={'right'} onClose={this.fCloseDrawer}>
    <div className="con">
        <p>这是第一行文字</p>
        <p>这是第二行文字</p>
        <p>这是第三行文字，啦啦啦~</p>                                                 
    </div>
</Drawer>
```
更多用法可以参考[demo](./demo/demolist)文件夹中的示例

### 4. 预览


### 5. 参数

Parameter | Type |Default| Description
--------- | ---- | ------|-----------
show | `string` | | true is show drawer, false is not 
placement | `string` | `right` | Position of drawer. There are 4 pre-defined positions: `left`,`right`,`top`,`bottom`
hasHeader | `boolean` | `true` | whether to show header or not, true is show, false is not
title | `string` |  |  drawer's title showed in header
className | `string` | | className on drawer's container, for customing drawer's style
showMask | `boolean` | `2000` | whether to show mask or not, true is show, false is not
maskClosable | `boolean` | `false` |  whether to close drawer or not, true is close, false is not
zIndex | `number` | `100000` | drawer container's zIndex in css
showClose | `boolean`  | `false` | whether to show close button, true is show, false is not
width | `number` `string` |  | drawer's width
height | `number` `string` |  | drawer's height
destroyOnClose | `boolean` |  | whether to destroy content in drawer, true is destory, false is not


