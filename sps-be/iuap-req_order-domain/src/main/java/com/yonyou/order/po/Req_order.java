package com.yonyou.order.po;
import cn.hutool.core.date.DateUtil;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.yonyou.order.constant.Req_orderConstant;
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
 * 采购订单
 * @since v5.0.0
 * @date 2019-9-19 10:34:46
 */

@JsonIgnoreProperties(ignoreUnknown = true)
@Table(name = "req_order")

public class Req_order extends BasePO implements AuditTrail{

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
    @Column(name="ro_no")
    private String ro_no;        //订单编号

    public void setRo_no(String ro_no){
        this.ro_no = ro_no;
    }
    public String getRo_no(){
        return this.ro_no;
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
    @Column(name="postate")
    @I18nEnumCode(clazz = Req_orderConstant.PostateEnum.class,target ="postateEnumValue" )
    private String postate;        //采购状态

    public void setPostate(String postate){
        this.postate = postate;
    }
    public String getPostate(){
        return this.postate;
    }

    @Transient
    private String postateEnumValue;   //采购状态

    public void setPostateEnumValue(String postateEnumValue){
        this.postateEnumValue = postateEnumValue;
    }
    public String getPostateEnumValue(){
        return this.postateEnumValue;
    }

}



