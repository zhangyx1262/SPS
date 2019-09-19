package com.yonyou.order.dto;
import cn.hutool.core.date.DateUtil;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.yonyou.iuap.baseservice.entity.AuditTrail;
import com.yonyou.iuap.baseservice.entity.annotation.*;
import com.yonyou.iuap.baseservice.support.condition.Condition;


import java.math.BigDecimal;
import java.util.Date;
import java.util.Random;

/**
 * 采购订单
 * @since v5.0.0
 * @date 2019-9-19 10:34:47
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class Req_orderDTO  implements AuditTrail{

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


    private String ro_no;        //订单编号

    public void setRo_no(String ro_no){
        this.ro_no = ro_no;
    }
    public String getRo_no(){
        return this.ro_no;
    }



    private String rl_no;        //审核编号

    public void setRl_no(String rl_no){
        this.rl_no = rl_no;
    }
    public String getRl_no(){
        return this.rl_no;
    }



    private String postate;        //采购状态

    public void setPostate(String postate){
        this.postate = postate;
    }
    public String getPostate(){
        return this.postate;
    }

    private String postateEnumValue;   //采购状态

    public void setPostateEnumValue(String postateEnumValue){
        this.postateEnumValue = postateEnumValue;
    }
    public String getPostateEnumValue(){
        return this.postateEnumValue;
    }

}



