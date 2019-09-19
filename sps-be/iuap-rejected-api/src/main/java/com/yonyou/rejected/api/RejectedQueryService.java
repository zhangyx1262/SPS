package com.yonyou.rejected.api;
import com.yonyou.rejected.dto.RejectedDTO;
import com.yonyou.iuap.ucf.common.rest.SearchParams;
import com.yonyou.cloud.middleware.rpc.RemoteCall;

import java.util.List;

/**
 * RPC 调用接口声明
 * @author  
 * @date 2019-9-19 11:06:58
 */
@RemoteCall("iuap-sps-server")
public interface RejectedQueryService {

    /**
     * 查询退货单列表
     */
    List<RejectedDTO> listRejected(SearchParams searchParams);

}
