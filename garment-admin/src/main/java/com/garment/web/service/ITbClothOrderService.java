package com.garment.web.service;

import java.util.List;
import com.garment.web.domain.TbClothOrder;

/**
 * 【请填写功能名称】Service接口
 *
 * @author ruoyi
 * @date 2023-12-19
 */
public interface ITbClothOrderService
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
     * 批量删除【请填写功能名称】
     *
     * @param ids 需要删除的【请填写功能名称】主键集合
     * @return 结果
     */
    public int deleteTbClothOrderByIds(Long[] ids);

    /**
     * 删除【请填写功能名称】信息
     *
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteTbClothOrderById(Long id);
}
