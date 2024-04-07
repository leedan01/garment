package com.garment.web.service;

import com.garment.web.domain.TbCloth;
import com.garment.web.dto.QueryClothDTO;
import com.garment.web.vo.ClouthShowVO;
import com.garment.web.vo.CultrualVO;

import java.util.List;

/**
 * h5衣服展示Service接口
 *
 * @author ruoyi
 * @date 2023-12-18
 */
public interface ITbClothService
{
    /**
     * 查询h5衣服展示
     *
     * @param id h5衣服展示主键
     * @return h5衣服展示
     */
    public TbCloth selectTbClothById(Long id);

    /**
     * 查询h5衣服展示列表
     *
     * @param tbCloth h5衣服展示
     * @return h5衣服展示集合
     */
    public List<TbCloth> selectTbClothList(TbCloth tbCloth);

    /**
     * 新增h5衣服展示
     *
     * @param tbCloth h5衣服展示
     * @return 结果
     */
    public int insertTbCloth(TbCloth tbCloth);

    /**
     * 修改h5衣服展示
     *
     * @param tbCloth h5衣服展示
     * @return 结果
     */
    public int updateTbCloth(TbCloth tbCloth);

    /**
     * 批量删除h5衣服展示
     *
     * @param ids 需要删除的h5衣服展示主键集合
     * @return 结果
     */
    public int deleteTbClothByIds(Long[] ids);

    /**
     * 删除h5衣服展示信息
     *
     * @param id h5衣服展示主键
     * @return 结果
     */
    public int deleteTbClothById(Long id);


     /**
      * 获取h5衣服展示类
      *
      *@Author leedan
      *@Description
      *@Date 2023/12/19
      *@param queryClothDTO
      *@return com.garment.web.vo.ClouthShowVO
      *@throws
      */
     public ClouthShowVO getClouthShowVO(QueryClothDTO queryClothDTO);

     /**
      * 获取文创展示
      *
      *@Author leedan
      *@Description
      *@Date 2023/12/20
      *@param queryClothDTO
      *@return com.garment.web.vo.CultrualVO
      *@throws
      */
     public CultrualVO getCultrualVO(QueryClothDTO queryClothDTO);


}
