package com.yonyou.warehousing.dao;
import com.yonyou.iuap.persistence.mybatis.anotation.MyBatisRepository;
import com.yonyou.iuap.ucf.dao.BaseDAO;

import com.yonyou.warehousing.po.Warehousing;

@MyBatisRepository("com.yonyou.warehousing.dao.WarehousingMapper")
public interface WarehousingMapper extends BaseDAO<Warehousing,String> {

}
