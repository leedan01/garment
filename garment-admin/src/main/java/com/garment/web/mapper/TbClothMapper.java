package com.garment.web.mapper;

import com.garment.web.domain.TbCloth;

import java.util.List;

/**
 * h5衣服展示Mapper接口
 *
 * @author ruoyi
 * @date 2023-12-18
 */
public interface TbClothMapper
{
    /**
     * 查询h5衣服展示
     *
     * @param id h5衣服展示主键
     * @return h5衣服展示
     */
    public TbCloth selectTbClothById(Long id);

    /**
     * 查询h5衣服展示列表
     *
     * @param tbCloth h5衣服展示
     * @return h5衣服展示集合
     */
    public List<TbCloth> selectTbClothList(TbCloth tbCloth);

    /**
     * 新增h5衣服展示
     *
     * @param tbCloth h5衣服展示
     * @return 结果
     */
    public int insertTbCloth(TbCloth tbCloth);

    /**
     * 修改h5衣服展示
     *
     * @param tbCloth h5衣服展示
     * @return 结果
     */
    public int updateTbCloth(TbCloth tbCloth);

    /**
     * 删除h5衣服展示
     *
     * @param id h5衣服展示主键
     * @return 结果
     */
    public int deleteTbClothById(Long id);

    /**
     * 批量删除h5衣服展示
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTbClothByIds(Long[] ids);
}
