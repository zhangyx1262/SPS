package com.yonyou.quality.api;
import com.yonyou.quality.dto.QualityDTO;
import com.yonyou.iuap.ucf.common.rest.SearchParams;
import com.yonyou.cloud.middleware.rpc.RemoteCall;

import java.util.List;

/**
 * RPC 调用接口声明
 * @author  
 * @date 2019-9-19 10:54:08
 */
@RemoteCall("iuap-sps-server")
public interface QualityQueryService {

    /**
     * 查询质检单列表
     */
    List<QualityDTO> listQuality(SearchParams searchParams);

}
