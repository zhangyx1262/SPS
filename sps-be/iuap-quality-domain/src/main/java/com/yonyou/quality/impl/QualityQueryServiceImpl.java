package com.yonyou.quality.impl;

import com.yonyou.quality.api.QualityQueryService;
import com.yonyou.quality.dto.QualityDTO;
import com.yonyou.quality.po.Quality;
import com.yonyou.quality.service.QualityService;
import com.yonyou.iuap.ucf.common.rest.SearchParams;
import com.yonyou.iuap.ucf.dao.support.SqlParam;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * RPC provider端
 * @author  
 * @date 2019-9-19 10:54:08
 */
@Service("com.yonyou.quality.impl.QualityQueryServiceImpl")
public class QualityQueryServiceImpl implements QualityQueryService {

    private QualityService qualityService;

    @Autowired
    public void setQualityService(QualityService qualityService) {
        this.qualityService = qualityService;
    }


    @Override
    public List<QualityDTO> listQuality(SearchParams searchParams) {
        List<Quality>  list = qualityService.queryList(searchParams);
        List<QualityDTO> result = new ArrayList<>();
        if (list!=null){
            for (Quality model:list){
                QualityDTO dto = new QualityDTO();
                BeanUtils.copyProperties(model,dto);
                result.add(dto);
            }
        }
        return result;
    }


}
