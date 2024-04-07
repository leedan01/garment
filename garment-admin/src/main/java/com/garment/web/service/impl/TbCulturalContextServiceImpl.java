package com.garment.web.service.impl;

import java.util.List;
import com.garment.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.garment.web.mapper.TbCulturalContextMapper;
import com.garment.web.domain.TbCulturalContext;
import com.garment.web.service.ITbCulturalContextService;

/**
 * 文创内容文本介绍Service业务层处理
 *
 * @author ruoyi
 * @date 2023-12-20
 */
@Service
public class TbCulturalContextServiceImpl implements ITbCulturalContextService
{
    @Autowired
    private TbCulturalContextMapper tbCulturalContextMapper;

    /**
     * 查询文创内容文本介绍
     *
     * @param id 文创内容文本介绍主键
     * @return 文创内容文本介绍
     */
    @Override
    public TbCulturalContext selectTbCulturalContextById(Long id)
    {
        return tbCulturalContextMapper.selectTbCulturalContextById(id);
    }

    /**
     * 查询文创内容文本介绍列表
     *
     * @param tbCulturalContext 文创内容文本介绍
     * @return 文创内容文本介绍
     */
    @Override
    public List<TbCulturalContext> selectTbCulturalContextList(TbCulturalContext tbCulturalContext)
    {
        return tbCulturalContextMapper.selectTbCulturalContextList(tbCulturalContext);
    }

    /**
     * 新增文创内容文本介绍
     *
     * @param tbCulturalContext 文创内容文本介绍
     * @return 结果
     */
    @Override
    public int insertTbCulturalContext(TbCulturalContext tbCulturalContext)
    {
        tbCulturalContext.setCreateTime(DateUtils.getNowDate());
        return tbCulturalContextMapper.insertTbCulturalContext(tbCulturalContext);
    }

    /**
     * 修改文创内容文本介绍
     *
     * @param tbCulturalContext 文创内容文本介绍
     * @return 结果
     */
    @Override
    public int updateTbCulturalContext(TbCulturalContext tbCulturalContext)
    {
        tbCulturalContext.setUpdateTime(DateUtils.getNowDate());
        return tbCulturalContextMapper.updateTbCulturalContext(tbCulturalContext);
    }

    /**
     * 批量删除文创内容文本介绍
     *
     * @param ids 需要删除的文创内容文本介绍主键
     * @return 结果
     */
    @Override
    public int deleteTbCulturalContextByIds(Long[] ids)
    {
        return tbCulturalContextMapper.deleteTbCulturalContextByIds(ids);
    }

    /**
     * 删除文创内容文本介绍信息
     *
     * @param id 文创内容文本介绍主键
     * @return 结果
     */
    @Override
    public int deleteTbCulturalContextById(Long id)
    {
        return tbCulturalContextMapper.deleteTbCulturalContextById(id);
    }
}
