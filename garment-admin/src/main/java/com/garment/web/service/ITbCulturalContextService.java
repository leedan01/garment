package com.garment.web.service;

import java.util.List;
import com.garment.web.domain.TbCulturalContext;

/**
 * 文创内容文本介绍Service接口
 *
 * @author ruoyi
 * @date 2023-12-20
 */
public interface ITbCulturalContextService
{
    /**
     * 查询文创内容文本介绍
     *
     * @param id 文创内容文本介绍主键
     * @return 文创内容文本介绍
     */
    public TbCulturalContext selectTbCulturalContextById(Long id);

    /**
     * 查询文创内容文本介绍列表
     *
     * @param tbCulturalContext 文创内容文本介绍
     * @return 文创内容文本介绍集合
     */
    public List<TbCulturalContext> selectTbCulturalContextList(TbCulturalContext tbCulturalContext);

    /**
     * 新增文创内容文本介绍
     *
     * @param tbCulturalContext 文创内容文本介绍
     * @return 结果
     */
    public int insertTbCulturalContext(TbCulturalContext tbCulturalContext);

    /**
     * 修改文创内容文本介绍
     *
     * @param tbCulturalContext 文创内容文本介绍
     * @return 结果
     */
    public int updateTbCulturalContext(TbCulturalContext tbCulturalContext);

    /**
     * 批量删除文创内容文本介绍
     *
     * @param ids 需要删除的文创内容文本介绍主键集合
     * @return 结果
     */
    public int deleteTbCulturalContextByIds(Long[] ids);

    /**
     * 删除文创内容文本介绍信息
     *
     * @param id 文创内容文本介绍主键
     * @return 结果
     */
    public int deleteTbCulturalContextById(Long id);
}
