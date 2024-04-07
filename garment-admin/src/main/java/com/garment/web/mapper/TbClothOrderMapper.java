package com.garment.web.mapper;

import com.garment.web.domain.TbClothOrder;

import java.util.List;


/**
 * 【请填写功能名称】Mapper接口
 *
 * @author ruoyi
 * @date 2023-12-19
 */
public interface TbClothOrderMapper
{
    /**
     * 查询【请填写功能名称】
     *
     * @param id 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    public TbClothOrder selectTbClothOrderById(Long id);

    /**
     * 查询【请填写功能名称】列表
     *
     * @param tbClothOrder 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<TbClothOrder> selectTbClothOrderList(TbClothOrder tbClothOrder);

    /**
     * 新增【请填写功能名称】
     *
     * @param tbClothOrder 【请填写功能名称】
     * @return 结果
     */
    public int insertTbClothOrder(TbClothOrder tbClothOrder);

    /**
     * 修改【请填写功能名称】
     *
     * @param tbClothOrder 【请填写功能名称】
     * @return 结果
     */
    public int updateTbClothOrder(TbClothOrder tbClothOrder);

    /**
     * 删除【请填写功能名称】
     *
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteTbClothOrderById(Long id);

    /**
     * 批量删除【请填写功能名称】
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTbClothOrderByIds(Long[] ids);
}
