package com.yonyou.review.dao;
import com.yonyou.iuap.persistence.mybatis.anotation.MyBatisRepository;
import com.yonyou.iuap.ucf.dao.BaseDAO;

import com.yonyou.review.po.Rl;

@MyBatisRepository("com.yonyou.review.dao.RlMapper")
public interface RlMapper extends BaseDAO<Rl,String> {

}
