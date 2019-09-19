package com.yonyou.warehousing.constant;

import com.yonyou.iuap.ucf.common.enums.I18nEnum;
import java.io.Serializable;


/**
 * 入库单枚举定义,约定为po的fieldName_key为匹配原则
 * @since v5.0.0
 * @date 2019-9-19 11:00:56
 */
public class WarehousingConstant   {
            public enum WhstateEnum implements I18nEnum {
                
    WHSTATE_0("0","待入库","iuap.enum.whstate0"),
    WHSTATE_1("1","已入库","iuap.enum.whstate1");

        private String code;
        private String defaultText;
        private String i18nTextCode;

        WhstateEnum(String code,String defaultText,String i18nTextCode){
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
