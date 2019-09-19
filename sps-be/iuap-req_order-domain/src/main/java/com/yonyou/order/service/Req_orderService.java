package com.yonyou.order.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.yonyou.iuap.baseservice.intg.support.ServiceFeature;
import static com.yonyou.iuap.baseservice.intg.support.ServiceFeature.*;

import com.yonyou.iuap.baseservice.service.GenericAssoService;
import com.yonyou.order.dao.Req_orderMapper;
import com.yonyou.order.po.Req_order;

/**
 * 基础CRUD及主子表联合操作服务
 */
@Service("com.yonyou.order.service.Req_orderService")
public class Req_orderService extends GenericAssoService<Req_order,String>{

    private Req_orderMapper req_orderMapper;

    @Autowired
    public void setReq_orderMapper(Req_orderMapper req_orderMapper) {
        this.req_orderMapper = req_orderMapper;
        super.setGenericMapper(req_orderMapper);
    }



    /**
     * 可插拔设计
     * @return 向父类 提供可插拔的特性声明
     */
    @Override
    protected ServiceFeature[] getFeats() {
        return new ServiceFeature[]{ AUDIT,I18N_ENUM };
    }
}