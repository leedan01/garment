package com.garment.web.mapper;

import java.util.List;
import com.garment.web.domain.TbGarmentHistory;
import com.garment.web.vo.HistoryVO;

/**
 * historyMapper接口
 *
 * @author lee
 * @date 2023-10-24
 */
public interface TbGarmentHistoryMapper
{
    /**
     * 查询history
     *
     * @param id history主键
     * @return history
     */
    public TbGarmentHistory selectTbGarmentHistoryById(Long id);

    /**
     * 查询history列表
     *
     * @param tbGarmentHistory history
     * @return history集合
     */
    public List<TbGarmentHistory> selectTbGarmentHistoryList(TbGarmentHistory tbGarmentHistory);

    /**
     * 获取历史记录
     *
     *@Author leedan
     *@Description
     *@Date 2023/10/31
     *@param
     *@return java.util.List<com.garment.web.vo.HistoryVO>
     *@throws
     */
    public List<HistoryVO> getHistoryList();

    /**
     * 新增history
     *
     * @param tbGarmentHistory history
     * @return 结果
     */
    public int insertTbGarmentHistory(TbGarmentHistory tbGarmentHistory);

    /**
     * 修改history
     *
     * @param tbGarmentHistory history
     * @return 结果
     */
    public int updateTbGarmentHistory(TbGarmentHistory tbGarmentHistory);

    /**
     * 删除history
     *
     * @param id history主键
     * @return 结果
     */
    public int deleteTbGarmentHistoryById(Long id);

    /**
     * 批量删除history
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTbGarmentHistoryByIds(Long[] ids);
}
