package com.yonyou.request.impl;

import com.yonyou.request.api.PrQueryService;
import com.yonyou.request.dto.PrDTO;
import com.yonyou.request.po.Pr;
import com.yonyou.request.service.PrService;
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
 * @date 2019-10-21 21:36:41
 */
@Service("com.yonyou.request.impl.PrQueryServiceImpl")
public class PrQueryServiceImpl implements PrQueryService {

    private PrService prService;

    @Autowired
    public void setPrService(PrService prService) {
        this.prService = prService;
    }


    @Override
    public List<PrDTO> listPr(SearchParams searchParams) {
        List<Pr>  list = prService.queryList(searchParams);
        List<PrDTO> result = new ArrayList<>();
        if (list!=null){
            for (Pr model:list){
                PrDTO dto = new PrDTO();
                BeanUtils.copyProperties(model,dto);
                result.add(dto);
            }
        }
        return result;
    }


}
