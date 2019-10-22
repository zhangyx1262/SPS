import request from "utils/request";


//定义接口地址
const URL = {
    "REVIEW_rl":`${GROBAL_HTTP_CTX}`+'/review/rl/reviewRl',//审核通过主表
    "DREVIEW_rl":`${GROBAL_HTTP_CTX}`+'/review/rl/dreviewRl',//审核不通过主表
    "GET_rl": `${GROBAL_HTTP_CTX}` + '/review/rl/list', // 获取主表
    "SAVE_rl": `${GROBAL_HTTP_CTX}` + '/review/rl/insertSelective', // 保存主表
    "UPDATE_rl": `${GROBAL_HTTP_CTX}` + '/review/rl/updateSelective', // 更新主表
    "DEL_rl": `${GROBAL_HTTP_CTX}` + '/review/rl/deleteBatch', // 删除主表
    "GET_QUERYPRINTTEMPLATEALLOCATE": `/eiap-plus/appResAllocate/queryPrintTemplateAllocate`,  // 查询打印模板
    "PRINTSERVER": '/print_service/print/preview',                                              // 打印
}

/**
 * 审核通过主表数据
 * @param {*} params
 */
export const reviewRl = (params) => {
    
   // alert("测试URL");
    return request(URL.REVIEW_rl, {
        method: "post",
        data: params
    });
}

/**
 * 审核不通过主表数据
 * @param {*} params
 */
export const dreviewRl = (params) => {
    return request(URL.DREVIEW_rl, {
        method: "post",
        data: params
    });
}

/**
 * 获取主列表
 * @param {*} params
 */
export const getrl = (param) => {
    return request(URL.GET_rl, {
        method: "get",
        param
    });
}
/**
 * 保存主表数据
 * @param {*} params
 */
export const saverl = (params) => {
    return request(URL.SAVE_rl, {
        method: "post",
        data: params
    });
}
/**
 * 更新主表数据
 * @param {*} params
 */
export const updaterl = (params) => {
    return request(URL.UPDATE_rl, {
        method: "post",
        data: params
    });
}
/**
 * 删除主表数据
 * @param {*} params
 */
export const delrl = (params) => {
    return request(URL.DEL_rl, {
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
