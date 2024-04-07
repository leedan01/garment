package com.garment.web.service;

import com.garment.web.domain.TbClothImg;

import java.util.List;


/**
 * h5衣服展示图片Service接口
 *
 * @author ruoyi
 * @date 2023-12-18
 */
public interface ITbClothImgService
{
    /**
     * 查询h5衣服展示图片
     *
     * @param id h5衣服展示图片主键
     * @return h5衣服展示图片
     */
    public TbClothImg selectTbClothImgById(Long id);

    /**
     * 查询h5衣服展示图片列表
     *
     * @param tbClothImg h5衣服展示图片
     * @return h5衣服展示图片集合
     */
    public List<TbClothImg> selectTbClothImgList(TbClothImg tbClothImg);

    /**
     * 新增h5衣服展示图片
     *
     * @param tbClothImg h5衣服展示图片
     * @return 结果
     */
    public int insertTbClothImg(TbClothImg tbClothImg);

    /**
     * 修改h5衣服展示图片
     *
     * @param tbClothImg h5衣服展示图片
     * @return 结果
     */
    public int updateTbClothImg(TbClothImg tbClothImg);

    /**
     * 批量删除h5衣服展示图片
     *
     * @param ids 需要删除的h5衣服展示图片主键集合
     * @return 结果
     */
    public int deleteTbClothImgByIds(Long[] ids);

    /**
     * 删除h5衣服展示图片信息
     *
     * @param id h5衣服展示图片主键
     * @return 结果
     */
    public int deleteTbClothImgById(Long id);
}
