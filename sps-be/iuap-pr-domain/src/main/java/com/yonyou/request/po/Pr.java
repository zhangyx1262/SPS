package com.yonyou.request.po;
import cn.hutool.core.date.DateUtil;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.yonyou.request.constant.PrConstant;
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
 * 申请单
 * @since v5.0.0
 * @date 2019-9-12 16:23:41
 */

@JsonIgnoreProperties(ignoreUnknown = true)
@Table(name = "pr")

public class Pr extends BasePO implements AuditTrail{

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
    @Column(name="pr_no")
    private String pr_no;        //申请单编号

    public void setPr_no(String pr_no){
        this.pr_no = pr_no;
    }
    public String getPr_no(){
        return this.pr_no;
    }


    @Condition(match=Match.LIKE)
    @Column(name="pname")
    private String pname;        //采购品名

    public void setPname(String pname){
        this.pname = pname;
    }
    public String getPname(){
        return this.pname;
    }


    @Condition
    @Column(name="pnum")
    private String pnum;        //采购数量

    public void setPnum(String pnum){
        this.pnum = pnum;
    }
    public String getPnum(){
        return this.pnum;
    }


    @Condition
    @Column(name="price")
    private String price;        //采购单价

    public void setPrice(String price){
        this.price = price;
    }
    public String getPrice(){
        return this.price;
    }


    @Condition
    @Column(name="ptime")
    private String ptime;        //申请时间

    public void setPtime(String ptime){
        this.ptime = ptime;
    }
    public String getPtime(){
        return this.ptime;
    }


    @Condition(match=Match.EQ)
    @Column(name="pstute")
    @I18nEnumCode(clazz = PrConstant.PstuteEnum.class,target ="pstuteEnumValue" )
    private String pstute;        //申请状态

    public void setPstute(String pstute){
        this.pstute = pstute;
    }
    public String getPstute(){
        return this.pstute;
    }

    @Transient
    private String pstuteEnumValue;   //申请状态

    public void setPstuteEnumValue(String pstuteEnumValue){
        this.pstuteEnumValue = pstuteEnumValue;
    }
    public String getPstuteEnumValue(){
        return this.pstuteEnumValue;
    }

}



