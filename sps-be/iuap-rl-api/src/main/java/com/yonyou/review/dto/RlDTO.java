package com.yonyou.review.dto;
import cn.hutool.core.date.DateUtil;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.yonyou.iuap.baseservice.entity.AuditTrail;
import com.yonyou.iuap.baseservice.entity.annotation.*;
import com.yonyou.iuap.baseservice.support.condition.Condition;


import java.math.BigDecimal;
import java.util.Date;
import java.util.Random;

/**
 * 审核单
 * @since v5.0.0
 * @date 2019-9-12 16:25:56
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class RlDTO  implements AuditTrail{

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


    private String rl_no;        //审核编号

    public void setRl_no(String rl_no){
        this.rl_no = rl_no;
    }
    public String getRl_no(){
        return this.rl_no;
    }



    private String pr_no;        //申请编号

    public void setPr_no(String pr_no){
        this.pr_no = pr_no;
    }
    public String getPr_no(){
        return this.pr_no;
    }



    private String rstute;        //审核状态

    public void setRstute(String rstute){
        this.rstute = rstute;
    }
    public String getRstute(){
        return this.rstute;
    }

    private String rstuteEnumValue;   //审核状态

    public void setRstuteEnumValue(String rstuteEnumValue){
        this.rstuteEnumValue = rstuteEnumValue;
    }
    public String getRstuteEnumValue(){
        return this.rstuteEnumValue;
    }

}



