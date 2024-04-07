package com.garment.web.controller.ai;

import com.garment.web.domain.TbClothOrder;
import com.garment.web.dto.AddH5Order;
import com.garment.web.dto.QueryClothDTO;
import com.garment.web.service.ITbClothOrderService;
import com.garment.web.service.ITbClothService;
import com.garment.web.service.OSSService;
import com.garment.web.vo.ClouthShowVO;
import com.garment.web.vo.CultrualVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.garment.common.core.controller.BaseController;
import com.garment.common.core.domain.AjaxResult;
import org.springframework.web.multipart.MultipartFile;


/**
 * h5衣服展示Controller
 *
 * @author ruoyi
 * @date 2023-12-18
 */
@RestController
@RequestMapping("/show/cloth")
@Api(tags = "h5展示相关接口")
public class TbClothController extends BaseController
{
    @Autowired
    private ITbClothService tbClothService;

    @Autowired
    private ITbClothOrderService tbClothOrderService;

    @Autowired
    private OSSService ossService;


    /**
     *  获取衣服展示
     *
     *@Author leedan
     *@Description
     *@Date 2023/12/19
     *@param queryClothDTO
     *@return com.garment.web.vo.ClouthShowVO
     *@throws
     */
    @ApiOperation("获取衣服展示")
    @GetMapping("/getClothById")
    public ClouthShowVO getClothById(QueryClothDTO queryClothDTO) {
        return  tbClothService.getClouthShowVO(queryClothDTO);
    }




    /**
     * 获取文创展示
     *
     *@Author leedan
     *@Description
     *@Date 2023/12/20
     *@param queryClothDTO
     *@return com.garment.web.vo.CultrualVO
     *@throws
     */
    @ApiOperation("获取文创展示")
    @GetMapping("/getCultrualById")
    public CultrualVO getCultrualById(QueryClothDTO queryClothDTO) {
        return  tbClothService.getCultrualVO(queryClothDTO);
    }


    /**
     *
     *
     *@Author leedan
     *@Description
     *@Date 2023/12/19
     *@param addH5Order
     *@return com.garment.web.vo.ClouthShowVO
     *@throws
     */
    @ApiOperation("新增订单")
    @PostMapping ("/addOrder")
    public AjaxResult addOrder(@RequestBody AddH5Order addH5Order) {
        TbClothOrder tbClothOrder = new TbClothOrder();
        BeanUtils.copyProperties(addH5Order,tbClothOrder);
        return   AjaxResult.success(tbClothOrderService.insertTbClothOrder(tbClothOrder)) ;
    }


    @ApiOperation("测试oss上传")
    @PostMapping ("/testOss")
    public AjaxResult testOss(MultipartFile file) {
        String url = ossService.upload(file);
        return   AjaxResult.success(url) ;
    }


}
