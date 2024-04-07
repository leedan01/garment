package com.garment.web.service.impl;

import java.util.List;
import com.garment.common.utils.DateUtils;
import com.garment.web.vo.MenuVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.garment.web.mapper.TbMenuMapper;
import com.garment.web.domain.TbMenu;
import com.garment.web.service.ITbMenuService;

/**
 * menuService业务层处理
 *
 * @author leedan
 * @date 2023-11-08
 */
@Service
public class TbMenuServiceImpl implements ITbMenuService
{
    @Autowired
    private TbMenuMapper tbMenuMapper;

    /**
     * 查询menu
     *
     * @param id menu主键
     * @return menu
     */
    @Override
    public TbMenu selectTbMenuById(Long id)
    {
        return tbMenuMapper.selectTbMenuById(id);
    }

    /**
     * 查询menu列表
     *
     * @param tbMenu menu
     * @return menu
     */
    @Override
    public List<TbMenu> selectTbMenuList(TbMenu tbMenu)
    {
        return tbMenuMapper.selectTbMenuList(tbMenu);
    }

    /**
     * 新增menu
     *
     * @param tbMenu menu
     * @return 结果
     */
    @Override
    public int insertTbMenu(TbMenu tbMenu)
    {
        tbMenu.setCreateTime(DateUtils.getNowDate());
        return tbMenuMapper.insertTbMenu(tbMenu);
    }

    /**
     * 修改menu
     *
     * @param tbMenu menu
     * @return 结果
     */
    @Override
    public int updateTbMenu(TbMenu tbMenu)
    {
        tbMenu.setUpdateTime(DateUtils.getNowDate());
        return tbMenuMapper.updateTbMenu(tbMenu);
    }

    /**
     * 批量删除menu
     *
     * @param ids 需要删除的menu主键
     * @return 结果
     */
    @Override
    public int deleteTbMenuByIds(Long[] ids)
    {
        return tbMenuMapper.deleteTbMenuByIds(ids);
    }

    /**
     * 删除menu信息
     *
     * @param id menu主键
     * @return 结果
     */
    @Override
    public int deleteTbMenuById(Long id)
    {
        return tbMenuMapper.deleteTbMenuById(id);
    }

    /**
     * 获取菜单列表
     *
     *@Author leedan
     *@Description
     *@Date 2023/11/8
     *@param
     *@return java.util.List<com.garment.web.vo.MenuVO>
     *@throws
     */
    @Override
    public List<MenuVO> getMenuList() {
        return  tbMenuMapper.getMenuList();
    }
}
