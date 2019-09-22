import request from "utils/request";


//定义接口地址
const URL = {
    "SUBMIT_pr": `${GROBAL_HTTP_CTX}` + '/request/pr/submit', // 提交主表
    "GET_pr": `${GROBAL_HTTP_CTX}` + '/request/pr/list', // 获取主表
    "SAVE_pr": `${GROBAL_HTTP_CTX}` + '/request/pr/insertSelective', // 保存主表
    "UPDATE_pr": `${GROBAL_HTTP_CTX}` + '/request/pr/updateSelective', // 更新主表
    "DEL_pr": `${GROBAL_HTTP_CTX}` + '/request/pr/deleteBatch', // 删除主表
    "GET_QUERYPRINTTEMPLATEALLOCATE": `/eiap-plus/appResAllocate/queryPrintTemplateAllocate`,  // 查询打印模板
    "PRINTSERVER": '/print_service/print/preview',                                              // 打印
}

/**
 * 提交主列表
 * @param {*} params
 */
export const sunmitpr = (params) => {
    return request(URL.SUBMIT_pr, {
        method: "post",
        data: params
    });
}

/**
 * 获取主列表
 * @param {*} params
 */
export const getpr = (param) => {
    return request(URL.GET_pr, {
        method: "get",
        param
    });
}
/**
 * 保存主表数据
 * @param {*} params
 */
export const savepr = (params) => {
    return request(URL.SAVE_pr, {
        method: "post",
        data: params
    });
}
/**
 * 更新主表数据
 * @param {*} params
 */
export const updatepr = (params) => {
    return request(URL.UPDATE_pr, {
        method: "post",
        data: params
    });
}
/**
 * 删除主表数据
 * @param {*} params
 */
export const delpr = (params) => {
    return request(URL.DEL_pr, {
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
