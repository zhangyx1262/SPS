package com.yonyou.request.dto;
import cn.hutool.core.date.DateUtil;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.yonyou.iuap.baseservice.entity.AuditTrail;
import com.yonyou.iuap.baseservice.entity.annotation.*;
import com.yonyou.iuap.baseservice.support.condition.Condition;


import java.math.BigDecimal;
import java.util.Date;
import java.util.Random;

/**
 * 申请单
 * @since v5.0.0
 * @date 2019-10-21 21:36:41
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class PrDTO  implements AuditTrail{

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


    private String pr_no;        //申请单编号

    public void setPr_no(String pr_no){
        this.pr_no = pr_no;
    }
    public String getPr_no(){
        return this.pr_no;
    }



    private String pname;        //采购品名

    public void setPname(String pname){
        this.pname = pname;
    }
    public String getPname(){
        return this.pname;
    }



    private String pnum;        //采购数量

    public void setPnum(String pnum){
        this.pnum = pnum;
    }
    public String getPnum(){
        return this.pnum;
    }



    private String price;        //采购单价

    public void setPrice(String price){
        this.price = price;
    }
    public String getPrice(){
        return this.price;
    }



    private String ptime;        //申请时间

    public void setPtime(String ptime){
        this.ptime = ptime;
    }
    public String getPtime(){
        return this.ptime;
    }



    private String pstute;        //申请状态

    public void setPstute(String pstute){
        this.pstute = pstute;
    }
    public String getPstute(){
        return this.pstute;
    }

    private String pstuteEnumValue;   //申请状态

    public void setPstuteEnumValue(String pstuteEnumValue){
        this.pstuteEnumValue = pstuteEnumValue;
    }
    public String getPstuteEnumValue(){
        return this.pstuteEnumValue;
    }

}



