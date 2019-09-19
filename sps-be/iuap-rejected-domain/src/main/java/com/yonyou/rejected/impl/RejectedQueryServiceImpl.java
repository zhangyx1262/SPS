package com.yonyou.rejected.impl;

import com.yonyou.rejected.api.RejectedQueryService;
import com.yonyou.rejected.dto.RejectedDTO;
import com.yonyou.rejected.po.Rejected;
import com.yonyou.rejected.service.RejectedService;
import com.yonyou.iuap.ucf.common.rest.SearchParams;
import com.yonyou.iuap.ucf.dao.support.SqlParam;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * RPC provider端
 * @author  
 * @date 2019-9-19 11:06:59
 */
@Service("com.yonyou.rejected.impl.RejectedQueryServiceImpl")
public class RejectedQueryServiceImpl implements RejectedQueryService {

    private RejectedService rejectedService;

    @Autowired
    public void setRejectedService(RejectedService rejectedService) {
        this.rejectedService = rejectedService;
    }


    @Override
    public List<RejectedDTO> listRejected(SearchParams searchParams) {
        List<Rejected>  list = rejectedService.queryList(searchParams);
        List<RejectedDTO> result = new ArrayList<>();
        if (list!=null){
            for (Rejected model:list){
                RejectedDTO dto = new RejectedDTO();
                BeanUtils.copyProperties(model,dto);
                result.add(dto);
            }
        }
        return result;
    }


}
