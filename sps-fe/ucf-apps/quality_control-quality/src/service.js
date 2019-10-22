import request from "utils/request";


//定义接口地址
const URL = {
    "qualityOK": `${GROBAL_HTTP_CTX}` + '/quality_control/quality/qualityOK', // 质检合格
    "qualityFalse": `${GROBAL_HTTP_CTX}` + '/quality_control/quality/qualityFalse', // 质检不合格
    "GET_quality": `${GROBAL_HTTP_CTX}` + '/quality_control/quality/list', // 获取主表
    "SAVE_quality": `${GROBAL_HTTP_CTX}` + '/quality_control/quality/insertSelective', // 保存主表
    "UPDATE_quality": `${GROBAL_HTTP_CTX}` + '/quality_control/quality/updateSelective', // 更新主表
    "DEL_quality": `${GROBAL_HTTP_CTX}` + '/quality_control/quality/deleteBatch', // 删除主表
    "GET_QUERYPRINTTEMPLATEALLOCATE": `/eiap-plus/appResAllocate/queryPrintTemplateAllocate`,  // 查询打印模板
    "PRINTSERVER": '/print_service/print/preview',                                              // 打印
}

/**
 * 质检合格
 * @param {*} params
 */
export const qualityOK = (params) => {
    
    //alert("测试URL");
    return request(URL.qualityOK, {
        method: "post",
        data: params
    });
}

/**
 * 质检不合格
 * @param {*} params
 */
export const qualityFalse = (params) => {
    
    alert("测试URL");
    return request(URL.qualityFalse, {
        method: "post",
        data: params
    });
}

/**
 * 获取主列表
 * @param {*} params
 */
export const getquality = (param) => {
    return request(URL.GET_quality, {
        method: "get",
        param
    });
}
/**
 * 保存主表数据
 * @param {*} params
 */
export const savequality = (params) => {
    return request(URL.SAVE_quality, {
        method: "post",
        data: params
    });
}
/**
 * 更新主表数据
 * @param {*} params
 */
export const updatequality = (params) => {
    return request(URL.UPDATE_quality, {
        method: "post",
        data: params
    });
}
/**
 * 删除主表数据
 * @param {*} params
 */
export const delquality = (params) => {
    return request(URL.DEL_quality, {
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
