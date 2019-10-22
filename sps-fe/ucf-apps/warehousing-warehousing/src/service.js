import request from "utils/request";


//定义接口地址
const URL = {
    "Warehousing": `${GROBAL_HTTP_CTX}` + '/warehousing/warehousing/warehousing', // 入库
    "GET_warehousing": `${GROBAL_HTTP_CTX}` + '/warehousing/warehousing/list', // 获取主表
    "SAVE_warehousing": `${GROBAL_HTTP_CTX}` + '/warehousing/warehousing/insertSelective', // 保存主表
    "UPDATE_warehousing": `${GROBAL_HTTP_CTX}` + '/warehousing/warehousing/updateSelective', // 更新主表
    "DEL_warehousing": `${GROBAL_HTTP_CTX}` + '/warehousing/warehousing/deleteBatch', // 删除主表
    "GET_QUERYPRINTTEMPLATEALLOCATE": `/eiap-plus/appResAllocate/queryPrintTemplateAllocate`,  // 查询打印模板
    "PRINTSERVER": '/print_service/print/preview',                                              // 打印
}

/**
 * 入库
 * @param {*} params
 */
export const Warehousing = (params) => {
    
   // alert("测试URL");
    return request(URL.Warehousing, {
        method: "post",
        data: params
    });
}

/**
 * 获取主列表
 * @param {*} params
 */
export const getwarehousing = (param) => {
    return request(URL.GET_warehousing, {
        method: "get",
        param
    });
}
/**
 * 保存主表数据
 * @param {*} params
 */
export const savewarehousing = (params) => {
    return request(URL.SAVE_warehousing, {
        method: "post",
        data: params
    });
}
/**
 * 更新主表数据
 * @param {*} params
 */
export const updatewarehousing = (params) => {
    return request(URL.UPDATE_warehousing, {
        method: "post",
        data: params
    });
}
/**
 * 删除主表数据
 * @param {*} params
 */
export const delwarehousing = (params) => {
    return request(URL.DEL_warehousing, {
        method: "post",
        data: params
    });
}


/**
 *
 * 查询打印模板
 * @param {*} params
 * @returns
 */
export const queryPrintTemplateAllocate = (params) => {
    return request(URL.GET_QUERYPRINTTEMPLATEALLOCATE, {
        method: "get",
        param: params
    });
}

export const printDocument = (params) => {
    let search = [];
    for (let key in params) {
        search.push(`${key}=${params[key]}`)
    }
    let exportUrl = `${URL.PRINTSERVER}?${search.join('&')}`;
    
    window.open(exportUrl);
}
