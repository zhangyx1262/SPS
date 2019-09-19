package com.yonyou.quality.constant;

import com.yonyou.iuap.ucf.common.enums.I18nEnum;
import java.io.Serializable;


/**
 * 质检单枚举定义,约定为po的fieldName_key为匹配原则
 * @since v5.0.0
 * @date 2019-9-19 10:54:08
 */
public class QualityConstant   {
            public enum Qc_stateEnum implements I18nEnum {
                
    QC_STATE_0("0","待质检","iuap.enum.qc_state0"),
    QC_STATE_1("1","质检通过","iuap.enum.qc_state1"),
    QC_STATE_2("2","质检未通过","iuap.enum.qc_state2");

        private String code;
        private String defaultText;
        private String i18nTextCode;

        Qc_stateEnum(String code,String defaultText,String i18nTextCode){
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
