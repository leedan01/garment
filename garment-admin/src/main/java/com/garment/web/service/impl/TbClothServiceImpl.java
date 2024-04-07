package com.garment.web.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import ch.qos.logback.core.joran.util.beans.BeanUtil;
import com.garment.common.utils.DateUtils;
import com.garment.web.domain.*;
import com.garment.web.dto.QueryClothDTO;
import com.garment.web.enums.H5ClothImgTypeShowEnums;
import com.garment.web.enums.H5ShowCulturalEnums;
import com.garment.web.enums.H5ShowEnums;
import com.garment.web.mapper.*;
import com.garment.web.service.ITbClothService;
import com.garment.web.vo.ClothSizeVO;
import com.garment.web.vo.ClouthShowVO;
import com.garment.web.vo.CultrualContextVO;
import com.garment.web.vo.CultrualVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * h5衣服展示Service业务层处理
 *
 * @author ruoyi
 * @date 2023-12-18
 */
@Service
public class TbClothServiceImpl implements ITbClothService
{
    @Autowired
    private TbClothMapper tbClothMapper;

    @Autowired
    private TbClothRecommendMapper tbClothRecommendMapper;

    @Autowired
    private TbClothImgMapper tbClothImgMapper;

    @Autowired
    private TbCulturalContextMapper tbCulturalContextMapper;

    @Autowired
    private TbCulturalMapper tbCulturalMapper;



    /**
     * 查询h5衣服展示
     *
     * @param id h5衣服展示主键
     * @return h5衣服展示
     */
    @Override
    public TbCloth selectTbClothById(Long id)
    {
        return tbClothMapper.selectTbClothById(id);
    }

    /**
     * 查询h5衣服展示列表
     *
     * @param tbCloth h5衣服展示
     * @return h5衣服展示
     */
    @Override
    public List<TbCloth> selectTbClothList(TbCloth tbCloth)
    {
        return tbClothMapper.selectTbClothList(tbCloth);
    }

    /**
     * 新增h5衣服展示
     *
     * @param tbCloth h5衣服展示
     * @return 结果
     */
    @Override
    public int insertTbCloth(TbCloth tbCloth)
    {
        tbCloth.setCreateTime(DateUtils.getNowDate());
        return tbClothMapper.insertTbCloth(tbCloth);
    }

    /**
     * 修改h5衣服展示
     *
     * @param tbCloth h5衣服展示
     * @return 结果
     */
    @Override
    public int updateTbCloth(TbCloth tbCloth)
    {
        tbCloth.setUpdateTime(DateUtils.getNowDate());
        return tbClothMapper.updateTbCloth(tbCloth);
    }

    /**
     * 批量删除h5衣服展示
     *
     * @param ids 需要删除的h5衣服展示主键
     * @return 结果
     */
    @Override
    public int deleteTbClothByIds(Long[] ids)
    {
        return tbClothMapper.deleteTbClothByIds(ids);
    }

    /**
     * 删除h5衣服展示信息
     *
     * @param id h5衣服展示主键
     * @return 结果
     */
    @Override
    public int deleteTbClothById(Long id)
    {
        return tbClothMapper.deleteTbClothById(id);
    }


    /**
     * 获取h5衣服展示类
     *
     *@Author leedan
     *@Description
     *@Date 2023/12/19
     *@param queryClothDTO
     *@return com.garment.web.vo.ClouthShowVO
     *@throws
     */
    @Override
    public ClouthShowVO getClouthShowVO(QueryClothDTO queryClothDTO) {
        TbCloth tbCloth =  tbClothMapper.selectTbClothById(queryClothDTO.getId());
        ClouthShowVO clouthShowVO =  new ClouthShowVO();
        BeanUtils.copyProperties(tbCloth,clouthShowVO);
        TbClothImg tbClothImg = new TbClothImg();
        tbClothImg.setClothId(queryClothDTO.getId());
        tbClothImg.setFlag(Long.valueOf(H5ShowEnums.CLOTH.getCode()));
        List<String> tempList1 = new ArrayList<>();
        List<String> tempList2 = new ArrayList<>();
        List<String> tempList3 = new ArrayList<>();
        List<String> tempList4 = new ArrayList<>();
        List<TbClothImg> list =   tbClothImgMapper.selectTbClothImgList(tbClothImg);
        list.forEach(v ->{
            Integer type = v.getType().intValue();
            String imgUrl = v.getImgUrl();
            if(type.equals(H5ClothImgTypeShowEnums.featured.getCode())){
                tempList1.add(imgUrl);
            }else if(type.equals(H5ClothImgTypeShowEnums.fabric.getCode())){
                tempList2.add(imgUrl);
            }else if(type.equals(H5ClothImgTypeShowEnums.real.getCode())){
                tempList3.add(imgUrl);
            }else if(type.equals(H5ClothImgTypeShowEnums.particulars.getCode())){
                tempList4.add(imgUrl);
            }
        });
        clouthShowVO.setFeaturedList(tempList1);
        clouthShowVO.setFabricList(tempList2);
        clouthShowVO.setRealList(tempList3);
        clouthShowVO.setParticularsList(tempList4);
        TbClothRecommend tbClothRecommend = new TbClothRecommend();
        tbClothRecommend.setClothId(queryClothDTO.getId());
        List<TbClothRecommend> tbClothRecommendList = tbClothRecommendMapper.selectTbClothRecommendList(tbClothRecommend);
        List<ClothSizeVO> tempList6 = new ArrayList<>();
        tbClothRecommendList.forEach(v ->{
            ClothSizeVO clothSizeVO = new ClothSizeVO();
            BeanUtils.copyProperties(v,clothSizeVO);
            tempList6.add(clothSizeVO);
        });
        clouthShowVO.setSizeList(tempList6);
        return clouthShowVO;
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
    @Override
    public CultrualVO getCultrualVO(QueryClothDTO queryClothDTO) {
        Long id = queryClothDTO.getId();
        TbCultural tbCultural = tbCulturalMapper.selectTbCulturalById(id);
        CultrualVO cultrualVO = new CultrualVO();
        BeanUtils.copyProperties(tbCultural,cultrualVO);
        TbCulturalContext tbCulturalContext = new TbCulturalContext();
        tbCulturalContext.setCulturalId(id);
        tbCulturalContext.setType(Long.valueOf(H5ShowCulturalEnums.CONTEXT.getCode()));
        List<CultrualContextVO> temp = new ArrayList<>();
        List<TbCulturalContext>  list = tbCulturalContextMapper.selectTbCulturalContextList(tbCulturalContext);
        //添加文本
        list.forEach(v ->{
            CultrualContextVO vo = new CultrualContextVO();
            BeanUtils.copyProperties(v,vo);
            temp.add(vo);
        });
        cultrualVO.setContextList(temp);
        //添加介绍
        List<CultrualContextVO> temp2 = new ArrayList<>();
        TbCulturalContext tbCulturalContext1 = new TbCulturalContext();
        tbCulturalContext1.setCulturalId(id);
        tbCulturalContext1.setType(Long.valueOf(H5ShowCulturalEnums.INTRODUCE.getCode()));
        List<TbCulturalContext>  list2 = tbCulturalContextMapper.selectTbCulturalContextList(tbCulturalContext1);
        //添加文本
        list2.forEach(v ->{
            CultrualContextVO vo = new CultrualContextVO();
            BeanUtils.copyProperties(v,vo);
            temp2.add(vo);
        });
        cultrualVO.setIntroduceList(temp2);
        TbClothImg tbClothImg = new TbClothImg();
        tbClothImg.setClothId(id);
        tbClothImg.setFlag(Long.valueOf(H5ShowEnums.CULTURAL.getCode()));
        List<TbClothImg> imgList =  tbClothImgMapper.selectTbClothImgList(tbClothImg);
        List<String> temp1 = new ArrayList<>();
        imgList.forEach( v ->{
            String img = v.getImgUrl();
            temp1.add(img);
        });


        cultrualVO.setImgList(temp1);
        return cultrualVO;
    }


}
