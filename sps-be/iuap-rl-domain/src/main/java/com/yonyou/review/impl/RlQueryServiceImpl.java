package com.yonyou.review.impl;

import com.yonyou.review.api.RlQueryService;
import com.yonyou.review.dto.RlDTO;
import com.yonyou.review.po.Rl;
import com.yonyou.review.service.RlService;
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
 * @date 2019-9-12 16:25:56
 */
@Service("com.yonyou.review.impl.RlQueryServiceImpl")
public class RlQueryServiceImpl implements RlQueryService {

    private RlService rlService;

    @Autowired
    public void setRlService(RlService rlService) {
        this.rlService = rlService;
    }


    @Override
    public List<RlDTO> listRl(SearchParams searchParams) {
        List<Rl>  list = rlService.queryList(searchParams);
        List<RlDTO> result = new ArrayList<>();
        if (list!=null){
            for (Rl model:list){
                RlDTO dto = new RlDTO();
                BeanUtils.copyProperties(model,dto);
                result.add(dto);
            }
        }
        return result;
    }


}
