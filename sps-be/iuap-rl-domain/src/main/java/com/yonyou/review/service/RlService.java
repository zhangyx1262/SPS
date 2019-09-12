package com.yonyou.review.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.yonyou.iuap.baseservice.intg.support.ServiceFeature;
import static com.yonyou.iuap.baseservice.intg.support.ServiceFeature.*;

import com.yonyou.iuap.baseservice.service.GenericAssoService;
import com.yonyou.review.dao.RlMapper;
import com.yonyou.review.po.Rl;

/**
 * 基础CRUD及主子表联合操作服务
 */
@Service("com.yonyou.review.service.RlService")
public class RlService extends GenericAssoService<Rl,String>{

    private RlMapper rlMapper;

    @Autowired
    public void setRlMapper(RlMapper rlMapper) {
        this.rlMapper = rlMapper;
        super.setGenericMapper(rlMapper);
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