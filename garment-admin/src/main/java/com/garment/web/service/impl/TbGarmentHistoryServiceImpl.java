package com.garment.web.service.impl;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

import com.alibaba.fastjson2.JSON;
import com.garment.common.core.domain.AjaxResult;
import com.garment.common.utils.DateUtils;
import com.garment.web.controller.ai.config.AiConfig;
import com.garment.web.dto.*;
import com.garment.web.enums.ImgFlagEnums;
import com.garment.web.util.AIUtil;
import com.garment.web.vo.HistoryVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.garment.web.mapper.TbGarmentHistoryMapper;
import com.garment.web.domain.TbGarmentHistory;
import com.garment.web.service.ITbGarmentHistoryService;

/**
 * historyService业务层处理
 *
 * @author lee
 * @date 2023-10-24
 */
@Service
public class TbGarmentHistoryServiceImpl implements ITbGarmentHistoryService
{
    @Autowired
    private TbGarmentHistoryMapper tbGarmentHistoryMapper;

    @Autowired
    private AiConfig aiConfig;

    private static final Logger log = LoggerFactory.getLogger(TbGarmentHistoryServiceImpl.class);

    /**
     * 查询history
     *
     * @param id history主键
     * @return history
     */
    @Override
    public TbGarmentHistory selectTbGarmentHistoryById(Long id)
    {
        return tbGarmentHistoryMapper.selectTbGarmentHistoryById(id);
    }

    /**
     * 查询history列表
     *
     * @param tbGarmentHistory history
     * @return history
     */
    @Override
    public List<TbGarmentHistory> selectTbGarmentHistoryList(TbGarmentHistory tbGarmentHistory)
    {
        return tbGarmentHistoryMapper.selectTbGarmentHistoryList(tbGarmentHistory);
    }

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
    @Override
    public List<HistoryVO> selectTbGarmentHistoryList() {
        return tbGarmentHistoryMapper.getHistoryList();
    }

    /**
     * 新增history
     *
     * @param tbGarmentHistory history
     * @return 结果
     */
    @Override
    public int insertTbGarmentHistory(TbGarmentHistory tbGarmentHistory)
    {
        tbGarmentHistory.setCreateTime(DateUtils.getNowDate());
        return tbGarmentHistoryMapper.insertTbGarmentHistory(tbGarmentHistory);
    }

    /**
     * 修改history
     *
     * @param tbGarmentHistory history
     * @return 结果
     */
    @Override
    public int updateTbGarmentHistory(TbGarmentHistory tbGarmentHistory)
    {
        tbGarmentHistory.setUpdateTime(DateUtils.getNowDate());
        return tbGarmentHistoryMapper.updateTbGarmentHistory(tbGarmentHistory);
    }

    /**
     * 批量删除history
     *
     * @param ids 需要删除的history主键
     * @return 结果
     */
    @Override
    public int deleteTbGarmentHistoryByIds(Long[] ids)
    {
        return tbGarmentHistoryMapper.deleteTbGarmentHistoryByIds(ids);
    }

    /**
     * 删除history信息
     *
     * @param id history主键
     * @return 结果
     */
    @Override
    public int deleteTbGarmentHistoryById(Long id)
    {
        return tbGarmentHistoryMapper.deleteTbGarmentHistoryById(id);
    }

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
    @Override
    public AjaxResult addHistory(AddHistoryDTO addHistoryDTO) {
        List<String> list = addHistoryDTO.getUrlList();
        list.forEach(v ->{
            TbGarmentHistory tbGarmentHistory = new TbGarmentHistory();
            BeanUtils.copyProperties(addHistoryDTO,tbGarmentHistory);
            tbGarmentHistory.setImgUrl(v);
            int result = tbGarmentHistoryMapper.insertTbGarmentHistory(tbGarmentHistory);
            log.info("插入历史数据结果---"+result);
        });
        return AjaxResult.success("操作成功");
    }

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

    @Override
    public AjaxResult txt2Img(Txt2ImgDTO txt2ImgDTO) throws IOException {
        log.info("文生图请求");
        String username = aiConfig.getUserName();
        String password = aiConfig.getPassWord();
        String credentials = username + ":" + password;
        String context = txt2ImgDTO.getContext();
//        String transLateContext = txt2ImgDTO.getTranslateContext();
        String auth = Base64.getEncoder().encodeToString(credentials.getBytes());
        ImagineText2ImageDTO imagineText2ImageDTO = new ImagineText2ImageDTO();
        BeanUtils.copyProperties(txt2ImgDTO,imagineText2ImageDTO);
        String param =  JSON.toJSONString(imagineText2ImageDTO);
        String lastUrl = aiConfig.getIp()+aiConfig.getText2ImageInterface();
        log.info("接口地址"+lastUrl);
        List<String> list = AIUtil.getImage(lastUrl,param,auth);
        list.forEach(v ->{
            TbGarmentHistory tbGarmentHistory = new TbGarmentHistory();
            tbGarmentHistory.setImgUrl(v);
            tbGarmentHistory.setContext(context);
            tbGarmentHistory.setUpdateFlag(ImgFlagEnums.YES.getCode());
//            tbGarmentHistory.setTranslateContext(transLateContext);
            int insertResult = tbGarmentHistoryMapper.insertTbGarmentHistory(tbGarmentHistory);
            log.info("插入数据结果"+insertResult);
        });
        return AjaxResult.success(list);
    }

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

    @Override
    public AjaxResult img2Img(Img2ImgDTO imageDTO) throws IOException {
        log.info("图生图请求");
        String username = aiConfig.getUserName();
        String password = aiConfig.getPassWord();
        String credentials = username + ":" + password;
        String context = imageDTO.getContext();
        String transLateContext = imageDTO.getTranslateContext();
        String auth = Base64.getEncoder().encodeToString(credentials.getBytes());
        ImagineImage2ImageDTO interfaceImageDTO = new ImagineImage2ImageDTO();
        BeanUtils.copyProperties(imageDTO,interfaceImageDTO);
        String param =  JSON.toJSONString(imageDTO);
        String lastUrl = aiConfig.getIp()+aiConfig.getImage2ImageInterface();
        List<String> list = AIUtil.getImage(lastUrl,param,auth);
        list.forEach(v ->{
            TbGarmentHistory tbGarmentHistory = new TbGarmentHistory();
            tbGarmentHistory.setImgUrl(v);
            tbGarmentHistory.setContext(context);
            tbGarmentHistory.setUpdateFlag(ImgFlagEnums.YES.getCode());
            tbGarmentHistory.setTranslateContext(transLateContext);
            int insertResult = tbGarmentHistoryMapper.insertTbGarmentHistory(tbGarmentHistory);
            log.info("插入数据结果"+insertResult);
        });
        return AjaxResult.success(list);
    }
}
