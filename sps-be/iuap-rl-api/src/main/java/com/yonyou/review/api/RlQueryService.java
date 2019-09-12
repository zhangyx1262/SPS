package com.yonyou.review.api;
import com.yonyou.review.dto.RlDTO;
import com.yonyou.iuap.ucf.common.rest.SearchParams;
import com.yonyou.cloud.middleware.rpc.RemoteCall;

import java.util.List;

/**
 * RPC 调用接口声明
 * @author  
 * @date 2019-9-12 16:25:56
 */
@RemoteCall("iuap-sps-server")
public interface RlQueryService {

    /**
     * 查询审核单列表
     */
    List<RlDTO> listRl(SearchParams searchParams);

}
