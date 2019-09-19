package com.yonyou.warehousing.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.yonyou.iuap.baseservice.intg.support.ServiceFeature;
import static com.yonyou.iuap.baseservice.intg.support.ServiceFeature.*;

import com.yonyou.iuap.baseservice.service.GenericAssoService;
import com.yonyou.warehousing.dao.WarehousingMapper;
import com.yonyou.warehousing.po.Warehousing;

/**
 * 基础CRUD及主子表联合操作服务
 */
@Service("com.yonyou.warehousing.service.WarehousingService")
public class WarehousingService extends GenericAssoService<Warehousing,String>{

    private WarehousingMapper warehousingMapper;

    @Autowired
    public void setWarehousingMapper(WarehousingMapper warehousingMapper) {
        this.warehousingMapper = warehousingMapper;
        super.setGenericMapper(warehousingMapper);
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