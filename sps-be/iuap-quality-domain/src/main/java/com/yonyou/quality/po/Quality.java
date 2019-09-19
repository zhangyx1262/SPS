package com.yonyou.quality.po;
import cn.hutool.core.date.DateUtil;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.yonyou.quality.constant.QualityConstant;
import com.yonyou.iuap.baseservice.entity.AuditTrail;
import com.yonyou.iuap.baseservice.entity.annotation.*;
import com.yonyou.iuap.baseservice.support.condition.Condition;
import com.yonyou.iuap.baseservice.support.condition.Match;
import com.yonyou.iuap.ucf.dao.BasePO;

import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Random;
/**
 * 质检单
 * @since v5.0.0
 * @date 2019-9-19 10:54:08
 */

@JsonIgnoreProperties(ignoreUnknown = true)
@Table(name = "quality")

public class Quality extends BasePO implements AuditTrail{

    @Column(name="create_time")
    private String createTime;

    @Column(name="create_user")
    @Condition
    private String createUser;

    @Column(name="last_modified")
    private String lastModified;

    @Column(name="last_modify_user")
    @Condition
    private String lastModifyUser;

    @Override
    public String getCreateTime() {
        return createTime;
    }

    @Override
    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    @Override
    public String getCreateUser() {
        return createUser;
    }

    @Override
    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    @Override
    public String getLastModified() {
        return lastModified;
    }

    @Override
    public void setLastModified(String lastModified) {
        this.lastModified = lastModified;
    }

    @Override
    public String getLastModifyUser() {
        return lastModifyUser;
    }

    @Override
    public void setLastModifyUser(String lastModifyUser) {
        this.lastModifyUser = lastModifyUser;
    }

    @Condition(match=Match.EQ)
    @Column(name="qc_no")
    private String qc_no;        //质检编号

    public void setQc_no(String qc_no){
        this.qc_no = qc_no;
    }
    public String getQc_no(){
        return this.qc_no;
    }


    @Condition(match=Match.EQ)
    @Column(name="po_no")
    private String po_no;        //订单编号

    public void setPo_no(String po_no){
        this.po_no = po_no;
    }
    public String getPo_no(){
        return this.po_no;
    }


    @Condition(match=Match.EQ)
    @Column(name="qc_state")
    @I18nEnumCode(clazz = QualityConstant.Qc_stateEnum.class,target ="qc_stateEnumValue" )
    private String qc_state;        //质检状态

    public void setQc_state(String qc_state){
        this.qc_state = qc_state;
    }
    public String getQc_state(){
        return this.qc_state;
    }

    @Transient
    private String qc_stateEnumValue;   //质检状态

    public void setQc_stateEnumValue(String qc_stateEnumValue){
        this.qc_stateEnumValue = qc_stateEnumValue;
    }
    public String getQc_stateEnumValue(){
        return this.qc_stateEnumValue;
    }

}



