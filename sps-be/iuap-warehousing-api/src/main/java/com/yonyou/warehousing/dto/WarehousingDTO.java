package com.yonyou.warehousing.dto;
import cn.hutool.core.date.DateUtil;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.yonyou.iuap.baseservice.entity.AuditTrail;
import com.yonyou.iuap.baseservice.entity.annotation.*;
import com.yonyou.iuap.baseservice.support.condition.Condition;


import java.math.BigDecimal;
import java.util.Date;
import java.util.Random;

/**
 * 入库单
 * @since v5.0.0
 * @date 2019-9-19 11:00:57
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class WarehousingDTO  implements AuditTrail{

    private String id;
    private String tenantId;
    private Date ts;
    private Integer dr;
    private String createTime;
    private String createUser;
    private String lastModified;
    private String lastModifyUser;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public Date getTs() {
        return ts;
    }

    public void setTs(Date ts) {
        this.ts = ts;
    }

    public Integer getDr() {
        return dr;
    }

    public void setDr(Integer dr) {
        this.dr = dr;
    }
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


    private String wh_no;        //入库编号

    public void setWh_no(String wh_no){
        this.wh_no = wh_no;
    }
    public String getWh_no(){
        return this.wh_no;
    }



    private String qc_no;        //质检编号

    public void setQc_no(String qc_no){
        this.qc_no = qc_no;
    }
    public String getQc_no(){
        return this.qc_no;
    }



    private String whstate;        //入库状态

    public void setWhstate(String whstate){
        this.whstate = whstate;
    }
    public String getWhstate(){
        return this.whstate;
    }

    private String whstateEnumValue;   //入库状态

    public void setWhstateEnumValue(String whstateEnumValue){
        this.whstateEnumValue = whstateEnumValue;
    }
    public String getWhstateEnumValue(){
        return this.whstateEnumValue;
    }

}



