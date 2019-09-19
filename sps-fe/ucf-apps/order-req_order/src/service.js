import request from "utils/request";


//定义接口地址
const URL = {
    "GET_req_order": `${GROBAL_HTTP_CTX}` + '/order/req_order/list', // 获取主表
    "SAVE_req_order": `${GROBAL_HTTP_CTX}` + '/order/req_order/insertSelective', // 保存主表
    "UPDATE_req_order": `${GROBAL_HTTP_CTX}` + '/order/req_order/updateSelective', // 更新主表
    "DEL_req_order": `${GROBAL_HTTP_CTX}` + '/order/req_order/deleteBatch', // 删除主表
    "GET_QUERYPRINTTEMPLATEALLOCATE": `/eiap-plus/appResAllocate/queryPrintTemplateAllocate`,  // 查询打印模板
    "PRINTSERVER": '/print_service/print/preview',                                              // 打印
}

/**
 * 获取主列表
 * @param {*} params
 */
export const getreq_order = (param) => {
    return request(URL.GET_req_order, {
        method: "get",
        param
    });
}
/**
 * 保存主表数据
 * @param {*} params
 */
export const savereq_order = (params) => {
    return request(URL.SAVE_req_order, {
        method: "post",
        data: params
    });
}
/**
 * 更新主表数据
 * @param {*} params
 */
export const updatereq_order = (params) => {
    return request(URL.UPDATE_req_order, {
        method: "post",
        data: params
    });
}
/**
 * 删除主表数据
 * @param {*} params
 */
export const delreq_order = (params) => {
    return request(URL.DEL_req_order, {
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
