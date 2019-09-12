package com.yonyou.review.po;
import cn.hutool.core.date.DateUtil;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.yonyou.review.constant.RlConstant;
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
 * 审核单
 * @since v5.0.0
 * @date 2019-9-12 16:25:56
 */

@JsonIgnoreProperties(ignoreUnknown = true)
@Table(name = "rl")

public class Rl extends BasePO implements AuditTrail{

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
    @Column(name="rl_no")
    private String rl_no;        //审核编号

    public void setRl_no(String rl_no){
        this.rl_no = rl_no;
    }
    public String getRl_no(){
        return this.rl_no;
    }


    @Condition(match=Match.EQ)
    @Column(name="pr_no")
    private String pr_no;        //申请编号

    public void setPr_no(String pr_no){
        this.pr_no = pr_no;
    }
    public String getPr_no(){
        return this.pr_no;
    }


    @Condition(match=Match.EQ)
    @Column(name="rstute")
    @I18nEnumCode(clazz = RlConstant.RstuteEnum.class,target ="rstuteEnumValue" )
    private String rstute;        //审核状态

    public void setRstute(String rstute){
        this.rstute = rstute;
    }
    public String getRstute(){
        return this.rstute;
    }

    @Transient
    private String rstuteEnumValue;   //审核状态

    public void setRstuteEnumValue(String rstuteEnumValue){
        this.rstuteEnumValue = rstuteEnumValue;
    }
    public String getRstuteEnumValue(){
        return this.rstuteEnumValue;
    }

}



