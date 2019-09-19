package com.yonyou.order.api;
import com.yonyou.order.dto.Req_orderDTO;
import com.yonyou.iuap.ucf.common.rest.SearchParams;
import com.yonyou.cloud.middleware.rpc.RemoteCall;

import java.util.List;

/**
 * RPC 调用接口声明
 * @author  
 * @date 2019-9-19 10:34:47
 */
@RemoteCall("iuap-sps-server")
public interface Req_orderQueryService {

    /**
     * 查询采购订单列表
     */
    List<Req_orderDTO> listReq_order(SearchParams searchParams);

}
