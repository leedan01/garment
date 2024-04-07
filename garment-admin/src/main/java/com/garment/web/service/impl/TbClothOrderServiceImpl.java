package com.garment.web.service.impl;

import java.util.List;
import com.garment.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.garment.web.mapper.TbClothOrderMapper;
import com.garment.web.domain.TbClothOrder;
import com.garment.web.service.ITbClothOrderService;

/**
 * 【请填写功能名称】Service业务层处理
 *
 * @author ruoyi
 * @date 2023-12-19
 */
@Service
public class TbClothOrderServiceImpl implements ITbClothOrderService
{
    @Autowired
    private TbClothOrderMapper tbClothOrderMapper;

    /**
     * 查询【请填写功能名称】
     *
     * @param id 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    @Override
    public TbClothOrder selectTbClothOrderById(Long id)
    {
        return tbClothOrderMapper.selectTbClothOrderById(id);
    }

    /**
     * 查询【请填写功能名称】列表
     *
     * @param tbClothOrder 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<TbClothOrder> selectTbClothOrderList(TbClothOrder tbClothOrder)
    {
        return tbClothOrderMapper.selectTbClothOrderList(tbClothOrder);
    }

    /**
     * 新增【请填写功能名称】
     *
     * @param tbClothOrder 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertTbClothOrder(TbClothOrder tbClothOrder)
    {
        tbClothOrder.setCreateTime(DateUtils.getNowDate());
        return tbClothOrderMapper.insertTbClothOrder(tbClothOrder);
    }

    /**
     * 修改【请填写功能名称】
     *
     * @param tbClothOrder 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateTbClothOrder(TbClothOrder tbClothOrder)
    {
        tbClothOrder.setUpdateTime(DateUtils.getNowDate());
        return tbClothOrderMapper.updateTbClothOrder(tbClothOrder);
    }

    /**
     * 批量删除【请填写功能名称】
     *
     * @param ids 需要删除的【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteTbClothOrderByIds(Long[] ids)
    {
        return tbClothOrderMapper.deleteTbClothOrderByIds(ids);
    }

    /**
     * 删除【请填写功能名称】信息
     *
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteTbClothOrderById(Long id)
    {
        return tbClothOrderMapper.deleteTbClothOrderById(id);
    }
}
