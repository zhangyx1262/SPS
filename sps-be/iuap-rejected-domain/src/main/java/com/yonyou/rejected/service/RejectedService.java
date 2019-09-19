package com.yonyou.rejected.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.yonyou.iuap.baseservice.intg.support.ServiceFeature;
import static com.yonyou.iuap.baseservice.intg.support.ServiceFeature.*;

import com.yonyou.iuap.baseservice.service.GenericAssoService;
import com.yonyou.rejected.dao.RejectedMapper;
import com.yonyou.rejected.po.Rejected;

/**
 * 基础CRUD及主子表联合操作服务
 */
@Service("com.yonyou.rejected.service.RejectedService")
public class RejectedService extends GenericAssoService<Rejected,String>{

    private RejectedMapper rejectedMapper;

    @Autowired
    public void setRejectedMapper(RejectedMapper rejectedMapper) {
        this.rejectedMapper = rejectedMapper;
        super.setGenericMapper(rejectedMapper);
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