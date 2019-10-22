package com.yonyou.quality.controller;
import com.yonyou.order.dto.Req_orderDTO;
import com.yonyou.order.po.Req_order;
import com.yonyou.order.service.Req_orderService;
import com.yonyou.quality.po.Quality;
import com.yonyou.quality.dto.QualityDTO;
import com.yonyou.quality.service.QualityService;
import com.yonyou.quality.dto.SimpleSearchDTO;
import com.yonyou.iuap.baseservice.service.util.SearchUtil;
import com.yonyou.iuap.baseservice.entity.annotation.Associative;
import com.yonyou.iuap.baseservice.vo.GenericAssoVo;
import com.yonyou.iuap.mvc.constants.RequestStatusEnum;
import com.yonyou.iuap.mvc.type.JsonResponse;
import com.yonyou.iuap.ucf.dao.support.UcfPage;
import com.yonyou.rejected.dto.RejectedDTO;
import com.yonyou.rejected.po.Rejected;
import com.yonyou.rejected.service.RejectedService;
import com.yonyou.request.dto.PrDTO;
import com.yonyou.request.po.Pr;
import com.yonyou.request.service.PrService;
import com.yonyou.review.po.Rl;
import com.yonyou.review.service.RlService;
import com.yonyou.warehousing.dto.WarehousingDTO;
import com.yonyou.warehousing.po.Warehousing;
import com.yonyou.warehousing.service.WarehousingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;
/**
* 说明：质检单基础Controller——提供数据增(CREATE)、删(DELETE、改(UPDATE)、查(READ)等rest接口
* @author  
* @date 2019-9-19 10:54:08
*/
@RestController("com.yonyou.quality.controller.QualityController")
@RequestMapping(value = "/quality_control/quality")
public class QualityController extends BaseController{

    private Logger logger = LoggerFactory.getLogger(QualityController.class);
    private final static  int PAGE_FLAG_LOAD_ALL = 1;
    private QualityService service;
    @Autowired
    private RejectedService rjservice;
    @Autowired
    private WarehousingService whservice;
    @Autowired
    private Req_orderService odservice;

    @Autowired
    private RlService rlservice;
    @Autowired
    private PrService prService;

    @Autowired
    public void setQualityService(QualityService service) {
        this.service = service;
    }
    /**
    * 分页查询
    * @return 分页集合
    */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public Object list(@RequestParam( defaultValue = "0")Integer pageIndex,@RequestParam( defaultValue = "10")Integer pageSize
            ,@RequestParam(required = false) String search_qc_no
            ,@RequestParam(required = false) String search_po_no
            ,@RequestParam(required = false) String search_qc_state
    ) {
        SimpleSearchDTO searchDTO = new SimpleSearchDTO();
            searchDTO.setSearch_qc_no(search_qc_no);
            searchDTO.setSearch_po_no(search_po_no);
            searchDTO.setSearch_qc_state(search_qc_state);
        PageRequest pageRequest;
        Sort sort= SearchUtil.getSortFromSortMap(searchDTO.getSorts(),Quality.class);
        try {
            if (pageSize== PAGE_FLAG_LOAD_ALL) {
                pageRequest =
                        PageRequest.of(pageIndex,Integer.MAX_VALUE-1,sort);
            }else{
                pageRequest=PageRequest.of(pageIndex,pageSize,sort);
            }
            Page<Quality> page = this.service.selectAllByPage(pageRequest, searchDTO.toSearchParams(Quality.class) );
            List<QualityDTO> dtoList = new ArrayList<>();
            for (Quality po:page.getContent()){
                QualityDTO dto = new QualityDTO();
                BeanUtils.copyProperties(po,dto);
                dtoList.add(dto);
            }
            Page<QualityDTO> dtoPage = new UcfPage<>(dtoList,page.getPageable(),page.getTotalElements());
            return this.buildSuccess(dtoPage);
        } catch (Exception exp) {
            logger.error("exp", exp);
            return this.buildError("msg", "Error query database", RequestStatusEnum.FAIL_FIELD);
        }
    }

    /**
     * 质检合格
     */
    @RequestMapping(value = "/qualityOK" , method = RequestMethod.POST)
    @ResponseBody
    public Object qualityOK(@RequestBody List<Quality> listData){
        //获取质检单id
        Quality entity=listData.get(0);
        String qcId=entity.getId();
        //获取质检单
        Quality qcentity=service.getAssoVo(qcId).getEntity();
        //修改质检状态
        qcentity.setQc_state("1");
        //保存修改
        qcentity=service.save(qcentity,false,true);
        QualityDTO qcDTO= new QualityDTO();
        BeanUtils.copyProperties(qcentity,qcDTO);

        //新增入库单
        Warehousing whentity=new Warehousing();
        String prno=qcentity.getPo_no().substring(2);
        whentity.setId("入库"+prno);
        whentity.setWh_no("入库"+prno);
        whentity.setQc_no(qcentity.getQc_no());
        whentity.setWhstate("0");

        whentity = this.whservice.save(whentity,true,true);
        WarehousingDTO whdto = new WarehousingDTO();
        BeanUtils.copyProperties(whentity,whdto);

        //修改申请单状态
        Req_order odentity=odservice.getAssoVo(qcentity.getPo_no()).getEntity();
        Rl rlentity=rlservice.getAssoVo(odentity.getRl_no()).getEntity();
        String prid=rlentity.getPr_no().substring(rlentity.getPr_no().indexOf("/")+1);
        //修改申请单状态
        Pr prentity= this.prService.getAssoVo(prid).getEntity();
        prentity.setPstute("5");//已申请/质检合格
        prentity=this.prService.save(prentity,false,true);
        PrDTO prDTO= new PrDTO();
        BeanUtils.copyProperties(prentity,prDTO);

        return this.buildSuccess();
    }

    /**
     * 质检不合格
     */
    @RequestMapping(value = "/qualityFalse" , method = RequestMethod.POST)
    @ResponseBody
    public Object qualityFalse(@RequestBody List<Quality> listData){
        //获取质检单id
        Quality entity=listData.get(0);
        String qcId=entity.getId();
        //获取质检单
        Quality qcentity=service.getAssoVo(qcId).getEntity();
        //修改质检状态
        qcentity.setQc_state("2");
        //保存修改
        qcentity=service.save(qcentity,false,true);
        QualityDTO qcDTO= new QualityDTO();
        BeanUtils.copyProperties(qcentity,qcDTO);

        //新增退货单
        Rejected rjentity=new Rejected();
        String prno=qcentity.getPo_no().substring(2);
        rjentity.setId("退货"+prno);
        rjentity.setRj_no("退货"+prno);
        rjentity.setQc_no(qcentity.getQc_no());
        rjentity.setRjstate("0");

        rjentity = this.rjservice.save(rjentity,true,true);
        RejectedDTO rjdto = new RejectedDTO();
        BeanUtils.copyProperties(rjentity,rjdto);

        //修改申请单状态
        Req_order odentity=odservice.getAssoVo(qcentity.getPo_no()).getEntity();
        Rl rlentity=rlservice.getAssoVo(odentity.getRl_no()).getEntity();
        String prid=rlentity.getPr_no().substring(rlentity.getPr_no().indexOf("/")+1);
        //修改申请单状态
        Pr prentity= this.prService.getAssoVo(prid).getEntity();
        prentity.setPstute("6");//已申请/质检合格
        prentity=this.prService.save(prentity,false,true);
        PrDTO prDTO= new PrDTO();
        BeanUtils.copyProperties(prentity,prDTO);

        return this.buildSuccess();
    }


    /**
     * 主子表合并处理--主表单条查询
     * @return GenericAssoVo ,entity中保存的是单条主表数据,sublist中保存的是字表数据,一次性全部加载
     */
    @RequestMapping(value = "/getAssoVo" , method = RequestMethod.GET)
    @ResponseBody
    public Object  getAssoVo(@RequestParam(value = "id")   Serializable  id){
        if (null==id){ return buildSuccess();}
        GenericAssoVo<Quality> vo = service.getAssoVo( id);
        JsonResponse result = this.buildSuccess("entity",vo.getEntity());//保证入参出参结构一致
        result.getDetailMsg().putAll(vo.getSublist());
        return  result;
    }
    /**
     * 主子表合并处理--主表单条保存
     * @param vo GenericAssoVo ,entity中保存的是单条主表数据,sublist中保存的是子表数据
     * @return 主表的业务实体
     */
    @RequestMapping(value = "/saveAssoVo", method = RequestMethod.POST)
    @ResponseBody
    public Object  saveAssoVo(@RequestBody GenericAssoVo<Quality> vo){
        Associative annotation= vo.getEntity().getClass().getAnnotation(Associative.class);
        if (annotation == null || StringUtils.isEmpty(annotation.fkName())) {
            return buildError("", "No entity got @Associative nor fkName", RequestStatusEnum.FAIL_FIELD);
        }
        Object result =service.saveAssoVo(vo);
        return this.buildSuccess(result) ;
    }

    /**
     * 主子表合并处理--主表单条删除,若取消级联删除请在主实体上注解改为@Associative(fkName = "NA",deleteCascade = false)
     * @param entities 待删除业务实体
     * @return 删除成功的实体
     */
    @RequestMapping(value = "/deleAssoVo", method = RequestMethod.POST)
    @ResponseBody
    public Object  deleAssoVo(@RequestBody Quality... entities){
        if (entities.length==0){
            return this.buildGlobalError("deleting entity must not be empty");
        }
        Associative annotation = entities[0].getClass().getAnnotation(Associative.class);
        if (annotation != null && !StringUtils.isEmpty(annotation.fkName())) {
            int result =0;
            for (Quality entity:entities){
                if (StringUtils.isEmpty(entity.getId())) {
                    return this.buildError("ID", "ID field is empty:"+entity.toString(), RequestStatusEnum.FAIL_FIELD);
                } else {
                    result += this.service.deleAssoVo(entity);
                }
            }
            return this.buildSuccess(result + " rows(entity and its subEntities) has been deleted!");
        } else {
            return this.buildError("", "Nothing got @Associative nor fkName", RequestStatusEnum.FAIL_FIELD);
        }
    }

    /**
    * 单条添加
    * @param entity 业务实体
    * @return 标准JsonResponse结构
    */
    @RequestMapping(value = "/insertSelective", method = {RequestMethod.POST,RequestMethod.PATCH})
    @ResponseBody
    public Object insertSelective(@RequestBody Quality entity) {
            entity = this.service.save(entity,true,true);
            QualityDTO dto = new QualityDTO();
        try {
            BeanUtils.copyProperties(entity,dto);
            return this.buildSuccess(dto);
        }catch(Exception exp) {
            return this.buildError("msg", exp.getMessage(), RequestStatusEnum.FAIL_FIELD);
        }
    }


    /**
    * 单条修改
    * @param entity 业务实体
    * @return 标准JsonResponse结构
    */
    @RequestMapping(value = "/updateSelective", method = {RequestMethod.POST,RequestMethod.PATCH})
    @ResponseBody
    public Object updateSelective(@RequestBody Quality entity) {
                        entity = this.service.save(entity,false,true);
            QualityDTO dto = new QualityDTO();
        try {
            BeanUtils.copyProperties(entity,dto);
            return this.buildSuccess(dto);
        }catch(Exception exp) {
            return this.buildError("msg", exp.getMessage(), RequestStatusEnum.FAIL_FIELD);
        }
    }


    /**
    * 批量删除
    * @param listData 业务实体列表
    * @return 标准JsonResponse结构
    * @throws Exception
    */
    @RequestMapping(value = "/deleteBatch", method = RequestMethod.POST)
    @ResponseBody
    public Object deleteBatch(@RequestBody List<Quality> listData) throws Exception {
        this.service.deleteBatch(listData);
        return super.buildSuccess();
    }
}

