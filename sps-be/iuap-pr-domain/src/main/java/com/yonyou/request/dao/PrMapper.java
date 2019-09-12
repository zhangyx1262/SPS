package com.yonyou.request.dao;
import com.yonyou.iuap.persistence.mybatis.anotation.MyBatisRepository;
import com.yonyou.iuap.ucf.dao.BaseDAO;

import com.yonyou.request.po.Pr;

@MyBatisRepository("com.yonyou.request.dao.PrMapper")
public interface PrMapper extends BaseDAO<Pr,String> {

}
