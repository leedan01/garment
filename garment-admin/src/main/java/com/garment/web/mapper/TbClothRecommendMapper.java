package com.garment.web.mapper;

import com.garment.web.domain.TbClothRecommend;

import java.util.List;


/**
 * h5衣服尺寸推荐Mapper接口
 *
 * @author ruoyi
 * @date 2023-12-18
 */
public interface TbClothRecommendMapper
{
    /**
     * 查询h5衣服尺寸推荐
     *
     * @param id h5衣服尺寸推荐主键
     * @return h5衣服尺寸推荐
     */
    public TbClothRecommend selectTbClothRecommendById(Long id);

    /**
     * 查询h5衣服尺寸推荐列表
     *
     * @param tbClothRecommend h5衣服尺寸推荐
     * @return h5衣服尺寸推荐集合
     */
    public List<TbClothRecommend> selectTbClothRecommendList(TbClothRecommend tbClothRecommend);

    /**
     * 新增h5衣服尺寸推荐
     *
     * @param tbClothRecommend h5衣服尺寸推荐
     * @return 结果
     */
    public int insertTbClothRecommend(TbClothRecommend tbClothRecommend);

    /**
     * 修改h5衣服尺寸推荐
     *
     * @param tbClothRecommend h5衣服尺寸推荐
     * @return 结果
     */
    public int updateTbClothRecommend(TbClothRecommend tbClothRecommend);

    /**
     * 删除h5衣服尺寸推荐
     *
     * @param id h5衣服尺寸推荐主键
     * @return 结果
     */
    public int deleteTbClothRecommendById(Long id);

    /**
     * 批量删除h5衣服尺寸推荐
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTbClothRecommendByIds(Long[] ids);
}
