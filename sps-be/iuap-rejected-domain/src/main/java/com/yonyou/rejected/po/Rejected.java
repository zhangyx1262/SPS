package com.yonyou.rejected.po;
import cn.hutool.core.date.DateUtil;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.yonyou.rejected.constant.RejectedConstant;
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
 * 退货单
 * @since v5.0.0
 * @date 2019-9-19 11:06:58
 */

@JsonIgnoreProperties(ignoreUnknown = true)
@Table(name = "rejected")

public class Rejected extends BasePO implements AuditTrail{

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
    @Column(name="rj_no")
    private String rj_no;        //退货单编号

    public void setRj_no(String rj_no){
        this.rj_no = rj_no;
    }
    public String getRj_no(){
        return this.rj_no;
    }


    @Condition(match=Match.EQ)
    @Column(name="qc_no")
    private String qc_no;        //质检单编号

    public void setQc_no(String qc_no){
        this.qc_no = qc_no;
    }
    public String getQc_no(){
        return this.qc_no;
    }


    @Condition(match=Match.EQ)
    @Column(name="rjstate")
    @I18nEnumCode(clazz = RejectedConstant.RjstateEnum.class,target ="rjstateEnumValue" )
    private String rjstate;        //退货状态

    public void setRjstate(String rjstate){
        this.rjstate = rjstate;
    }
    public String getRjstate(){
        return this.rjstate;
    }

    @Transient
    private String rjstateEnumValue;   //退货状态

    public void setRjstateEnumValue(String rjstateEnumValue){
        this.rjstateEnumValue = rjstateEnumValue;
    }
    public String getRjstateEnumValue(){
        return this.rjstateEnumValue;
    }

}



