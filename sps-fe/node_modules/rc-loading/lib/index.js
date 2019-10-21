'use strict';

Object.defineProperty(exports, "__esModule", {
    value: true
});

var _createClass = function () { function defineProperties(target, props) { for (var i = 0; i < props.length; i++) { var descriptor = props[i]; descriptor.enumerable = descriptor.enumerable || false; descriptor.configurable = true; if ("value" in descriptor) descriptor.writable = true; Object.defineProperty(target, descriptor.key, descriptor); } } return function (Constructor, protoProps, staticProps) { if (protoProps) defineProperties(Constructor.prototype, protoProps); if (staticProps) defineProperties(Constructor, staticProps); return Constructor; }; }();

var _react = require('react');

var _react2 = _interopRequireDefault(_react);

var _rcAnimate = require('rc-animate');

var _rcAnimate2 = _interopRequireDefault(_rcAnimate);

var _classnames = require('classnames');

var _classnames2 = _interopRequireDefault(_classnames);

require('./index.css');

require('./animation.css');

function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

function _classCallCheck(instance, Constructor) { if (!(instance instanceof Constructor)) { throw new TypeError("Cannot call a class as a function"); } }

function _possibleConstructorReturn(self, call) { if (!self) { throw new ReferenceError("this hasn't been initialised - super() hasn't been called"); } return call && (typeof call === "object" || typeof call === "function") ? call : self; }

function _inherits(subClass, superClass) { if (typeof superClass !== "function" && superClass !== null) { throw new TypeError("Super expression must either be null or a function, not " + typeof superClass); } subClass.prototype = Object.create(superClass && superClass.prototype, { constructor: { value: subClass, enumerable: false, writable: true, configurable: true } }); if (superClass) Object.setPrototypeOf ? Object.setPrototypeOf(subClass, superClass) : subClass.__proto__ = superClass; }

var ReactLoading = function (_Component) {
    _inherits(ReactLoading, _Component);

    function ReactLoading(props) {
        _classCallCheck(this, ReactLoading);

        return _possibleConstructorReturn(this, (ReactLoading.__proto__ || Object.getPrototypeOf(ReactLoading)).call(this, props));
    }

    _createClass(ReactLoading, [{
        key: 'render',
        value: function render() {
            var spinning = this.props.spinning;

            var loadingDisplayType = (0, _classnames2.default)({
                "rc-spinning-loading-wrap": true,
                "rc-spinning-loading-display": this.props.displayType === "inlineBlock"
            });
            var loadingChange = (0, _classnames2.default)({
                "rc-spinning-loading": true,
                "rc-spinning-fence": this.props.type === "fence",
                "rc-spinning-ellipsis": this.props.type === "ellipsis",
                "rc-spinning-dynamic-ellipsis": this.props.type === "dynamicEllipsis"
            });
            var spinIndicator = _react2.default.createElement(
                'span',
                { className: loadingChange },
                _react2.default.createElement('span', null),
                _react2.default.createElement('span', null),
                _react2.default.createElement('span', null),
                _react2.default.createElement('span', null),
                _react2.default.createElement('span', null)
            );
            return _react2.default.createElement(
                _rcAnimate2.default,
                { component: 'div',
                    className: loadingDisplayType,
                    transitionName: 'fade' },
                spinning && _react2.default.createElement(
                    'div',
                    { key: 'loading' },
                    spinIndicator
                ),
                _react2.default.createElement(
                    'div',
                    { className: spinning ? 'rc-spining-item-container' : '', key: 'container' },
                    this.props.children
                )
            );
        }
    }]);

    return ReactLoading;
}(_react.Component);

ReactLoading.defaultProps = {
    spinning: true,
    type: 'fence',
    displayType: 'block'
};

exports.default = ReactLoading;