package com.example.utils;

import com.example.domain.entity.Menu;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author 35238
 * @date 2023/8/10 0010 15:17
 */
//新增角色-获取菜单下拉树列表
public class SystemConverter {

    private SystemConverter() {}

    public static List<com.huanf.vo.MenuTreeVo> buildMenuSelectTree(List<Menu> menus) {
        List<com.huanf.vo.MenuTreeVo> MenuTreeVos = menus.stream()
                .map(m -> new com.huanf.vo.MenuTreeVo(m.getId(), m.getMenuName(), m.getParentId(), null))
                .collect(Collectors.toList());
        List<com.huanf.vo.MenuTreeVo> options = MenuTreeVos.stream()
                .filter(o -> o.getParentId().equals(0L))
                .map(o -> o.setChildren(getChildList(MenuTreeVos, o)))
                .collect(Collectors.toList());


        return options;
    }


    /**
     * 得到子节点列表
     */
    private static List<com.huanf.vo.MenuTreeVo> getChildList(List<com.huanf.vo.MenuTreeVo> list, com.huanf.vo.MenuTreeVo option) {
        List<com.huanf.vo.MenuTreeVo> options = list.stream()
                .filter(o -> Objects.equals(o.getParentId(), option.getId()))
                .map(o -> o.setChildren(getChildList(list, o)))
                .collect(Collectors.toList());
        return options;

    }
}