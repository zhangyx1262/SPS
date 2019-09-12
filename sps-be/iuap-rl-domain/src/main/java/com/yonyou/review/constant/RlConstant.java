package com.yonyou.review.constant;

import com.yonyou.iuap.ucf.common.enums.I18nEnum;
import java.io.Serializable;


/**
 * 审核单枚举定义,约定为po的fieldName_key为匹配原则
 * @since v5.0.0
 * @date 2019-9-12 16:25:56
 */
public class RlConstant   {
            public enum RstuteEnum implements I18nEnum {
                
    RSTUTE_0("0","待审核","iuap.enum.rstute0"),
    RSTUTE_1("1","已通过","iuap.enum.rstute1"),
    RSTUTE_2("2","未通过","iuap.enum.rstute2");

        private String code;
        private String defaultText;
        private String i18nTextCode;

        RstuteEnum(String code,String defaultText,String i18nTextCode){
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
