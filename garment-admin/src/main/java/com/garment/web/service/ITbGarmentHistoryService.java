package com.garment.web.service;

import java.io.IOException;
import java.util.List;

import com.garment.common.core.domain.AjaxResult;
import com.garment.web.domain.TbGarmentHistory;
import com.garment.web.dto.*;
import com.garment.web.vo.HistoryVO;

/**
 * historyService接口
 *
 * @author lee
 * @date 2023-10-24
 */
public interface ITbGarmentHistoryService
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
     * 查询历史记录
     *
     *@Author leedan
     *@Description
     *@Date 2023/10/31
     *@param
     *@return java.util.List<com.garment.web.vo.HistoryVO>
     *@throws
     */
    public List<HistoryVO> selectTbGarmentHistoryList( );




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
     * 批量删除history
     *
     * @param ids 需要删除的history主键集合
     * @return 结果
     */
    public int deleteTbGarmentHistoryByIds(Long[] ids);

    /**
     * 删除history信息
     *
     * @param id history主键
     * @return 结果
     */
    public int deleteTbGarmentHistoryById(Long id);

    /**
     * 新增历史记录
     *
     *@Author leedan
     *@Description
     *@Date 2023/10/24
     *@param addHistoryDTO
     *@return com.garment.common.core.domain.AjaxResult
     *@throws
     */
    public AjaxResult addHistory(AddHistoryDTO addHistoryDTO);

    /**
     * 文生图
     *
     *@Author leedan
     *@Description
     *@Date 2023/11/13
     *@param txt2ImgDTO
     *@return com.garment.common.core.domain.AjaxResult
     *@throws
     */
    public AjaxResult txt2Img(Txt2ImgDTO txt2ImgDTO) throws IOException;


    /**
     * 图生图
     *
     *@Author leedan
     *@Description
     *@Date 2023/11/13
     *@param imageDTO
     *@return com.garment.common.core.domain.AjaxResult
     *@throws
     */
    public AjaxResult img2Img(Img2ImgDTO imageDTO) throws IOException;


}
