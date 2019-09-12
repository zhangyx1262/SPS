package com.yonyou.request.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.yonyou.iuap.baseservice.intg.support.ServiceFeature;
import static com.yonyou.iuap.baseservice.intg.support.ServiceFeature.*;

import com.yonyou.iuap.baseservice.service.GenericAssoService;
import com.yonyou.request.dao.PrMapper;
import com.yonyou.request.po.Pr;

/**
 * 基础CRUD及主子表联合操作服务
 */
@Service("com.yonyou.request.service.PrService")
public class PrService extends GenericAssoService<Pr,String>{

    private PrMapper prMapper;

    @Autowired
    public void setPrMapper(PrMapper prMapper) {
        this.prMapper = prMapper;
        super.setGenericMapper(prMapper);
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