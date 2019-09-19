package com.yonyou.rejected.dao;
import com.yonyou.iuap.persistence.mybatis.anotation.MyBatisRepository;
import com.yonyou.iuap.ucf.dao.BaseDAO;

import com.yonyou.rejected.po.Rejected;

@MyBatisRepository("com.yonyou.rejected.dao.RejectedMapper")
public interface RejectedMapper extends BaseDAO<Rejected,String> {

}
