package com.garment.web.service.impl;

import java.util.List;
import com.garment.common.utils.DateUtils;
import com.garment.web.domain.TbClothRecommend;
import com.garment.web.mapper.TbClothRecommendMapper;
import com.garment.web.service.ITbClothRecommendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * h5衣服尺寸推荐Service业务层处理
 *
 * @author ruoyi
 * @date 2023-12-18
 */
@Service
public class TbClothRecommendServiceImpl implements ITbClothRecommendService
{
    @Autowired
    private TbClothRecommendMapper tbClothRecommendMapper;

    /**
     * 查询h5衣服尺寸推荐
     *
     * @param id h5衣服尺寸推荐主键
     * @return h5衣服尺寸推荐
     */
    @Override
    public TbClothRecommend selectTbClothRecommendById(Long id)
    {
        return tbClothRecommendMapper.selectTbClothRecommendById(id);
    }

    /**
     * 查询h5衣服尺寸推荐列表
     *
     * @param tbClothRecommend h5衣服尺寸推荐
     * @return h5衣服尺寸推荐
     */
    @Override
    public List<TbClothRecommend> selectTbClothRecommendList(TbClothRecommend tbClothRecommend)
    {
        return tbClothRecommendMapper.selectTbClothRecommendList(tbClothRecommend);
    }

    /**
     * 新增h5衣服尺寸推荐
     *
     * @param tbClothRecommend h5衣服尺寸推荐
     * @return 结果
     */
    @Override
    public int insertTbClothRecommend(TbClothRecommend tbClothRecommend)
    {
        tbClothRecommend.setCreateTime(DateUtils.getNowDate());
        return tbClothRecommendMapper.insertTbClothRecommend(tbClothRecommend);
    }

    /**
     * 修改h5衣服尺寸推荐
     *
     * @param tbClothRecommend h5衣服尺寸推荐
     * @return 结果
     */
    @Override
    public int updateTbClothRecommend(TbClothRecommend tbClothRecommend)
    {
        tbClothRecommend.setUpdateTime(DateUtils.getNowDate());
        return tbClothRecommendMapper.updateTbClothRecommend(tbClothRecommend);
    }

    /**
     * 批量删除h5衣服尺寸推荐
     *
     * @param ids 需要删除的h5衣服尺寸推荐主键
     * @return 结果
     */
    @Override
    public int deleteTbClothRecommendByIds(Long[] ids)
    {
        return tbClothRecommendMapper.deleteTbClothRecommendByIds(ids);
    }

    /**
     * 删除h5衣服尺寸推荐信息
     *
     * @param id h5衣服尺寸推荐主键
     * @return 结果
     */
    @Override
    public int deleteTbClothRecommendById(Long id)
    {
        return tbClothRecommendMapper.deleteTbClothRecommendById(id);
    }
}
