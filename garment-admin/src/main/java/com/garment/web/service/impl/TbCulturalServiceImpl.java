package com.garment.web.service.impl;

import java.util.List;
import com.garment.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.garment.web.mapper.TbCulturalMapper;
import com.garment.web.domain.TbCultural;
import com.garment.web.service.ITbCulturalService;

/**
 * h5文创演示类Service业务层处理
 *
 * @author ruoyi
 * @date 2023-12-20
 */
@Service
public class TbCulturalServiceImpl implements ITbCulturalService
{
    @Autowired
    private TbCulturalMapper tbCulturalMapper;

    /**
     * 查询h5文创演示类
     *
     * @param id h5文创演示类主键
     * @return h5文创演示类
     */
    @Override
    public TbCultural selectTbCulturalById(Long id)
    {
        return tbCulturalMapper.selectTbCulturalById(id);
    }

    /**
     * 查询h5文创演示类列表
     *
     * @param tbCultural h5文创演示类
     * @return h5文创演示类
     */
    @Override
    public List<TbCultural> selectTbCulturalList(TbCultural tbCultural)
    {
        return tbCulturalMapper.selectTbCulturalList(tbCultural);
    }

    /**
     * 新增h5文创演示类
     *
     * @param tbCultural h5文创演示类
     * @return 结果
     */
    @Override
    public int insertTbCultural(TbCultural tbCultural)
    {
        tbCultural.setCreateTime(DateUtils.getNowDate());
        return tbCulturalMapper.insertTbCultural(tbCultural);
    }

    /**
     * 修改h5文创演示类
     *
     * @param tbCultural h5文创演示类
     * @return 结果
     */
    @Override
    public int updateTbCultural(TbCultural tbCultural)
    {
        tbCultural.setUpdateTime(DateUtils.getNowDate());
        return tbCulturalMapper.updateTbCultural(tbCultural);
    }

    /**
     * 批量删除h5文创演示类
     *
     * @param ids 需要删除的h5文创演示类主键
     * @return 结果
     */
    @Override
    public int deleteTbCulturalByIds(Long[] ids)
    {
        return tbCulturalMapper.deleteTbCulturalByIds(ids);
    }

    /**
     * 删除h5文创演示类信息
     *
     * @param id h5文创演示类主键
     * @return 结果
     */
    @Override
    public int deleteTbCulturalById(Long id)
    {
        return tbCulturalMapper.deleteTbCulturalById(id);
    }
}
