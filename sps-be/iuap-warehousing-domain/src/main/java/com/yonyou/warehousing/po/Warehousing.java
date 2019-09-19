package com.yonyou.warehousing.po;
import cn.hutool.core.date.DateUtil;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.yonyou.warehousing.constant.WarehousingConstant;
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
 * 入库单
 * @since v5.0.0
 * @date 2019-9-19 11:00:56
 */

@JsonIgnoreProperties(ignoreUnknown = true)
@Table(name = "warehousing")

public class Warehousing extends BasePO implements AuditTrail{

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
    @Column(name="wh_no")
    private String wh_no;        //入库编号

    public void setWh_no(String wh_no){
        this.wh_no = wh_no;
    }
    public String getWh_no(){
        return this.wh_no;
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
    @Column(name="whstate")
    @I18nEnumCode(clazz = WarehousingConstant.WhstateEnum.class,target ="whstateEnumValue" )
    private String whstate;        //入库状态

    public void setWhstate(String whstate){
        this.whstate = whstate;
    }
    public String getWhstate(){
        return this.whstate;
    }

    @Transient
    private String whstateEnumValue;   //入库状态

    public void setWhstateEnumValue(String whstateEnumValue){
        this.whstateEnumValue = whstateEnumValue;
    }
    public String getWhstateEnumValue(){
        return this.whstateEnumValue;
    }

}



