package com.yonyou.order.constant;

import com.yonyou.iuap.ucf.common.enums.I18nEnum;
import java.io.Serializable;


/**
 * 采购订单枚举定义,约定为po的fieldName_key为匹配原则
 * @since v5.0.0
 * @date 2019-9-19 10:34:46
 */
public class Req_orderConstant   {
            public enum PostateEnum implements I18nEnum {
                
    POSTATE_0("0","待采购","iuap.enum.postate0"),
    POSTATE_1("1","已采购","iuap.enum.postate1");

        private String code;
        private String defaultText;
        private String i18nTextCode;

        PostateEnum(String code,String defaultText,String i18nTextCode){
            this.code=code;
            this.defaultText=defaultText;
            this.i18nTextCode=i18nTextCode;
        }
        @Override
        public String getI18nTextCode() {
            return i18nTextCode;
        }

        @Override
        public String getI18nDefaultText() {
            return defaultText;
        }

        @Override
        public Serializable code() {
            return code;
        }

        }
    ;

}
