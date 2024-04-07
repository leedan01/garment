package com.garment.web.mapper;

import java.util.List;
import com.garment.web.domain.TbMenu;
import com.garment.web.vo.MenuVO;

/**
 * menuMapper接口
 *
 * @author leedan
 * @date 2023-11-08
 */
public interface TbMenuMapper
{
    /**
     * 查询menu
     *
     * @param id menu主键
     * @return menu
     */
    public TbMenu selectTbMenuById(Long id);

    /**
     * 查询menu列表
     *
     * @param tbMenu menu
     * @return menu集合
     */
    public List<TbMenu> selectTbMenuList(TbMenu tbMenu);

    /**
     * 新增menu
     *
     * @param tbMenu menu
     * @return 结果
     */
    public int insertTbMenu(TbMenu tbMenu);

    /**
     * 修改menu
     *
     * @param tbMenu menu
     * @return 结果
     */
    public int updateTbMenu(TbMenu tbMenu);

    /**
     * 删除menu
     *
     * @param id menu主键
     * @return 结果
     */
    public int deleteTbMenuById(Long id);

    /**
     * 批量删除menu
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTbMenuByIds(Long[] ids);

    /**
     * 获取列表
     *
     *@Author leedan
     *@Description
     *@Date 2023/11/8
     *@param
     *@return java.util.List<com.garment.web.vo.MenuVO>
     *@throws
     */
    public List<MenuVO> getMenuList();
}
