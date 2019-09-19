package com.yonyou.quality.dto;
import cn.hutool.core.date.DateUtil;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.yonyou.iuap.baseservice.entity.AuditTrail;
import com.yonyou.iuap.baseservice.entity.annotation.*;
import com.yonyou.iuap.baseservice.support.condition.Condition;


import java.math.BigDecimal;
import java.util.Date;
import java.util.Random;

/**
 * 质检单
 * @since v5.0.0
 * @date 2019-9-19 10:54:08
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class QualityDTO  implements AuditTrail{

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


    private String qc_no;        //质检编号

    public void setQc_no(String qc_no){
        this.qc_no = qc_no;
    }
    public String getQc_no(){
        return this.qc_no;
    }



    private String po_no;        //订单编号

    public void setPo_no(String po_no){
        this.po_no = po_no;
    }
    public String getPo_no(){
        return this.po_no;
    }



    private String qc_state;        //质检状态

    public void setQc_state(String qc_state){
        this.qc_state = qc_state;
    }
    public String getQc_state(){
        return this.qc_state;
    }

    private String qc_stateEnumValue;   //质检状态

    public void setQc_stateEnumValue(String qc_stateEnumValue){
        this.qc_stateEnumValue = qc_stateEnumValue;
    }
    public String getQc_stateEnumValue(){
        return this.qc_stateEnumValue;
    }

}



