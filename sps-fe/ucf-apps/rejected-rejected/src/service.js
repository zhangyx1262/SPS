import request from "utils/request";


//定义接口地址
const URL = {
    "reject": `${GROBAL_HTTP_CTX}` + '/rejected/rejected/reject', // 退货成功
    "GET_rejected": `${GROBAL_HTTP_CTX}` + '/rejected/rejected/list', // 获取主表
    "SAVE_rejected": `${GROBAL_HTTP_CTX}` + '/rejected/rejected/insertSelective', // 保存主表
    "UPDATE_rejected": `${GROBAL_HTTP_CTX}` + '/rejected/rejected/updateSelective', // 更新主表
    "DEL_rejected": `${GROBAL_HTTP_CTX}` + '/rejected/rejected/deleteBatch', // 删除主表
    "GET_QUERYPRINTTEMPLATEALLOCATE": `/eiap-plus/appResAllocate/queryPrintTemplateAllocate`,  // 查询打印模板
    "PRINTSERVER": '/print_service/print/preview',                                              // 打印
}

/**
 * 退货成功
 * @param {*} params
 */
export const reject = (params) => {
    
   // alert("测试URL");
    return request(URL.reject, {
        method: "post",
        data: params
    });
}

/**
 * 获取主列表
 * @param {*} params
 */
export const getrejected = (param) => {
    return request(URL.GET_rejected, {
        method: "get",
        param
    });
}
/**
 * 保存主表数据
 * @param {*} params
 */
export const saverejected = (params) => {
    return request(URL.SAVE_rejected, {
        method: "post",
        data: params
    });
}
/**
 * 更新主表数据
 * @param {*} params
 */
export const updaterejected = (params) => {
    return request(URL.UPDATE_rejected, {
        method: "post",
        data: params
    });
}
/**
 * 删除主表数据
 * @param {*} params
 */
export const delrejected = (params) => {
    return request(URL.DEL_rejected, {
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
