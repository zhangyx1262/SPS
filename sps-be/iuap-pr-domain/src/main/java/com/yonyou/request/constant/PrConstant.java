package com.yonyou.request.constant;

import com.yonyou.iuap.ucf.common.enums.I18nEnum;
import java.io.Serializable;


/**
 * 申请单枚举定义,约定为po的fieldName_key为匹配原则
 * @since v5.0.0
 * @date 2019-10-21 21:36:41
 */
public class PrConstant   {
                        public enum PstuteEnum implements I18nEnum {
                
    PSTUTE_0("0","待申请","iuap.enum.pstute0"),
    PSTUTE_1("1","已申请","iuap.enum.pstute1"),
    PSTUTE_2("2","已申请/审核已通过","iuap.enum.pstute2"),
    PSTUTE_3("3","已申请/审核未通过","iuap.enum.pstute3"),
    PSTUTE_4("4","已申请/已采购","iuap.enum.pstute4"),
    PSTUTE_5("5","已申请/质检合格","iuap.enum.pstute5"),
    PSTUTE_6("6","已申请/质检不合格","iuap.enum.pstute6"),
    PSTUTE_7("7","已申请/已退货","iuap.enum.pstute7"),
    PSTUTE_8("8","已申请/已入库","iuap.enum.pstute8");

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
