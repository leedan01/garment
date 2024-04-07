package com.garment.web.service;

import java.util.List;
import com.garment.web.domain.TbCultural;

/**
 * h5文创演示类Service接口
 *
 * @author ruoyi
 * @date 2023-12-20
 */
public interface ITbCulturalService
{
    /**
     * 查询h5文创演示类
     *
     * @param id h5文创演示类主键
     * @return h5文创演示类
     */
    public TbCultural selectTbCulturalById(Long id);

    /**
     * 查询h5文创演示类列表
     *
     * @param tbCultural h5文创演示类
     * @return h5文创演示类集合
     */
    public List<TbCultural> selectTbCulturalList(TbCultural tbCultural);

    /**
     * 新增h5文创演示类
     *
     * @param tbCultural h5文创演示类
     * @return 结果
     */
    public int insertTbCultural(TbCultural tbCultural);

    /**
     * 修改h5文创演示类
     *
     * @param tbCultural h5文创演示类
     * @return 结果
     */
    public int updateTbCultural(TbCultural tbCultural);

    /**
     * 批量删除h5文创演示类
     *
     * @param ids 需要删除的h5文创演示类主键集合
     * @return 结果
     */
    public int deleteTbCulturalByIds(Long[] ids);

    /**
     * 删除h5文创演示类信息
     *
     * @param id h5文创演示类主键
     * @return 结果
     */
    public int deleteTbCulturalById(Long id);
}
