package com.yonyou.order.impl;

import com.yonyou.order.api.Req_orderQueryService;
import com.yonyou.order.dto.Req_orderDTO;
import com.yonyou.order.po.Req_order;
import com.yonyou.order.service.Req_orderService;
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
 * @date 2019-9-19 10:34:46
 */
@Service("com.yonyou.order.impl.Req_orderQueryServiceImpl")
public class Req_orderQueryServiceImpl implements Req_orderQueryService {

    private Req_orderService req_orderService;

    @Autowired
    public void setReq_orderService(Req_orderService req_orderService) {
        this.req_orderService = req_orderService;
    }


    @Override
    public List<Req_orderDTO> listReq_order(SearchParams searchParams) {
        List<Req_order>  list = req_orderService.queryList(searchParams);
        List<Req_orderDTO> result = new ArrayList<>();
        if (list!=null){
            for (Req_order model:list){
                Req_orderDTO dto = new Req_orderDTO();
                BeanUtils.copyProperties(model,dto);
                result.add(dto);
            }
        }
        return result;
    }


}
