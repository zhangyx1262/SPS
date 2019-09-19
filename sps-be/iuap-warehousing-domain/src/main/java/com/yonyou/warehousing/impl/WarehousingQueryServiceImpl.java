package com.yonyou.warehousing.impl;

import com.yonyou.warehousing.api.WarehousingQueryService;
import com.yonyou.warehousing.dto.WarehousingDTO;
import com.yonyou.warehousing.po.Warehousing;
import com.yonyou.warehousing.service.WarehousingService;
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
 * @date 2019-9-19 11:00:56
 */
@Service("com.yonyou.warehousing.impl.WarehousingQueryServiceImpl")
public class WarehousingQueryServiceImpl implements WarehousingQueryService {

    private WarehousingService warehousingService;

    @Autowired
    public void setWarehousingService(WarehousingService warehousingService) {
        this.warehousingService = warehousingService;
    }


    @Override
    public List<WarehousingDTO> listWarehousing(SearchParams searchParams) {
        List<Warehousing>  list = warehousingService.queryList(searchParams);
        List<WarehousingDTO> result = new ArrayList<>();
        if (list!=null){
            for (Warehousing model:list){
                WarehousingDTO dto = new WarehousingDTO();
                BeanUtils.copyProperties(model,dto);
                result.add(dto);
            }
        }
        return result;
    }


}
