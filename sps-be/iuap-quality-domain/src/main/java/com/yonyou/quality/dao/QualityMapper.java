package com.yonyou.quality.dao;
import com.yonyou.iuap.persistence.mybatis.anotation.MyBatisRepository;
import com.yonyou.iuap.ucf.dao.BaseDAO;

import com.yonyou.quality.po.Quality;

@MyBatisRepository("com.yonyou.quality.dao.QualityMapper")
public interface QualityMapper extends BaseDAO<Quality,String> {

}
