package com.yonyou.request.constant;

import com.yonyou.iuap.ucf.common.enums.I18nEnum;
import java.io.Serializable;


/**
 * 申请单枚举定义,约定为po的fieldName_key为匹配原则
 * @since v5.0.0
 * @date 2019-9-12 16:23:41
 */
public class PrConstant   {
                        public enum PstuteEnum implements I18nEnum {
                
    PSTUTE_0("0","待申请","iuap.enum.pstute0"),
    PSTUTE_1("1","已申请","iuap.enum.pstute1");

        private String code;
        private String defaultText;
        private String i18nTextCode;

        PstuteEnum(String code,String defaultText,String i18nTextCode){
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
