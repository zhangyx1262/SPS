package com.yonyou.order.dao;
import com.yonyou.iuap.persistence.mybatis.anotation.MyBatisRepository;
import com.yonyou.iuap.ucf.dao.BaseDAO;

import com.yonyou.order.po.Req_order;

@MyBatisRepository("com.yonyou.order.dao.Req_orderMapper")
public interface Req_orderMapper extends BaseDAO<Req_order,String> {

}
