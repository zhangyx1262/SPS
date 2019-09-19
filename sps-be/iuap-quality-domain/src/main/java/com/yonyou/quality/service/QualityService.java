package com.yonyou.quality.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.yonyou.iuap.baseservice.intg.support.ServiceFeature;
import static com.yonyou.iuap.baseservice.intg.support.ServiceFeature.*;

import com.yonyou.iuap.baseservice.service.GenericAssoService;
import com.yonyou.quality.dao.QualityMapper;
import com.yonyou.quality.po.Quality;

/**
 * 基础CRUD及主子表联合操作服务
 */
@Service("com.yonyou.quality.service.QualityService")
public class QualityService extends GenericAssoService<Quality,String>{

    private QualityMapper qualityMapper;

    @Autowired
    public void setQualityMapper(QualityMapper qualityMapper) {
        this.qualityMapper = qualityMapper;
        super.setGenericMapper(qualityMapper);
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