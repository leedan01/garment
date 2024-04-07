package com.garment.web.mapper;

import java.util.List;
import com.garment.web.domain.TbCulturalContext;

/**
 * 文创内容文本介绍Mapper接口
 *
 * @author ruoyi
 * @date 2023-12-20
 */
public interface TbCulturalContextMapper
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
     * 删除文创内容文本介绍
     *
     * @param id 文创内容文本介绍主键
     * @return 结果
     */
    public int deleteTbCulturalContextById(Long id);

    /**
     * 批量删除文创内容文本介绍
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTbCulturalContextByIds(Long[] ids);
}
