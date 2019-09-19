package com.yonyou.warehousing.api;
import com.yonyou.warehousing.dto.WarehousingDTO;
import com.yonyou.iuap.ucf.common.rest.SearchParams;
import com.yonyou.cloud.middleware.rpc.RemoteCall;

import java.util.List;

/**
 * RPC 调用接口声明
 * @author  
 * @date 2019-9-19 11:00:57
 */
@RemoteCall("iuap-sps-server")
public interface WarehousingQueryService {

    /**
     * 查询入库单列表
     */
    List<WarehousingDTO> listWarehousing(SearchParams searchParams);

}
