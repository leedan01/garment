package com.garment.web.service.impl;

import java.util.List;
import com.garment.common.utils.DateUtils;
import com.garment.web.domain.TbClothImg;
import com.garment.web.mapper.TbClothImgMapper;
import com.garment.web.service.ITbClothImgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * h5衣服展示图片Service业务层处理
 *
 * @author ruoyi
 * @date 2023-12-18
 */
@Service
public class TbClothImgServiceImpl implements ITbClothImgService
{
    @Autowired
    private TbClothImgMapper tbClothImgMapper;

    /**
     * 查询h5衣服展示图片
     *
     * @param id h5衣服展示图片主键
     * @return h5衣服展示图片
     */
    @Override
    public TbClothImg selectTbClothImgById(Long id)
    {
        return tbClothImgMapper.selectTbClothImgById(id);
    }

    /**
     * 查询h5衣服展示图片列表
     *
     * @param tbClothImg h5衣服展示图片
     * @return h5衣服展示图片
     */
    @Override
    public List<TbClothImg> selectTbClothImgList(TbClothImg tbClothImg)
    {
        return tbClothImgMapper.selectTbClothImgList(tbClothImg);
    }

    /**
     * 新增h5衣服展示图片
     *
     * @param tbClothImg h5衣服展示图片
     * @return 结果
     */
    @Override
    public int insertTbClothImg(TbClothImg tbClothImg)
    {
        tbClothImg.setCreateTime(DateUtils.getNowDate());
        return tbClothImgMapper.insertTbClothImg(tbClothImg);
    }

    /**
     * 修改h5衣服展示图片
     *
     * @param tbClothImg h5衣服展示图片
     * @return 结果
     */
    @Override
    public int updateTbClothImg(TbClothImg tbClothImg)
    {
        tbClothImg.setUpdateTime(DateUtils.getNowDate());
        return tbClothImgMapper.updateTbClothImg(tbClothImg);
    }

    /**
     * 批量删除h5衣服展示图片
     *
     * @param ids 需要删除的h5衣服展示图片主键
     * @return 结果
     */
    @Override
    public int deleteTbClothImgByIds(Long[] ids)
    {
        return tbClothImgMapper.deleteTbClothImgByIds(ids);
    }

    /**
     * 删除h5衣服展示图片信息
     *
     * @param id h5衣服展示图片主键
     * @return 结果
     */
    @Override
    public int deleteTbClothImgById(Long id)
    {
        return tbClothImgMapper.deleteTbClothImgById(id);
    }
}
