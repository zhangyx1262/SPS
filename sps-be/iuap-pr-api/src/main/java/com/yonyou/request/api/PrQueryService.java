package com.yonyou.request.api;
import com.yonyou.request.dto.PrDTO;
import com.yonyou.iuap.ucf.common.rest.SearchParams;
import com.yonyou.cloud.middleware.rpc.RemoteCall;

import java.util.List;

/**
 * RPC 调用接口声明
 * @author  
 * @date 2019-10-21 21:36:41
 */
@RemoteCall("iuap-sps-server")
public interface PrQueryService {

    /**
     * 查询申请单列表
     */
    List<PrDTO> listPr(SearchParams searchParams);

}
