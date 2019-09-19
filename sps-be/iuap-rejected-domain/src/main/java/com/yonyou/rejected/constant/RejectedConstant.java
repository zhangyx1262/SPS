package com.yonyou.rejected.constant;

import com.yonyou.iuap.ucf.common.enums.I18nEnum;
import java.io.Serializable;


/**
 * 退货单枚举定义,约定为po的fieldName_key为匹配原则
 * @since v5.0.0
 * @date 2019-9-19 11:06:58
 */
public class RejectedConstant   {
            public enum RjstateEnum implements I18nEnum {
                
    RJSTATE_0("0","待退货","iuap.enum.rjstate0"),
    RJSTATE_1("1","已退货","iuap.enum.rjstate1");

        private String code;
        private String defaultText;
        private String i18nTextCode;

        RjstateEnum(String code,String defaultText,String i18nTextCode){
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
