package com.example.utils;

import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;
import java.util.ArrayList;
public class BeanCopyUtils {

    private BeanCopyUtils() {
        // 私有构造，防止实例化
    }

    /**
     * 复制对象属性，返回目标类型的新对象
     *
     * @param source 源对象
     * @param clazz  目标对象类型Class
     * @param <T>    目标类型泛型
     * @return 目标对象实例，属性已复制；出错返回null
     */
    //单体拷贝
    public static <T> T copyBean(Object source, Class<T> clazz) {
        T result = null;
        try {
            result = clazz.getDeclaredConstructor().newInstance();
            BeanUtils.copyProperties(source, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }


    //数组拷贝
    public static <O,T> List<T> copyBeanList(List<O> list, Class<T> clazz) {
        return list.stream()
                .map(o -> copyBean(o, clazz))
                .collect(Collectors.toList());
    }
}



