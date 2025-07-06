package com.example.constants;

/**
 * 系统通用常量类
 * <p>
 * 用于统一定义系统中使用的固定值，例如文章状态、通用标志位等，
 * 避免魔法数字（magic number），提高代码可读性和可维护性。
 */
public class SystemConstants {

    /**
     *  文章是草稿
     */
    public static final int ARTICLE_STATUS_DRAFT = 1;

    /**
     *  文章是正常分布状态
     */
    public static final int ARTICLE_STATUS_NORMAL = 0;

    /**
     * 文章列表当前查询页数
     */
    public static final int ARTICLE_STATUS_CURRENT = 1;

    /**
     * 文章列表每页显示的数据条数
     */
    public static final int ARTICLE_STATUS_SIZE = 10;

    /**
     * 分类表的分类状态是正常状态
     */
    public static final String STATUS_NORMAL = "0";

    /**
     * 友链状态为审核通过
     */
    public static final String LINK_STATUS_NORMAL = "0";

    /**
     * 评论区的某条评论是根评论
     */
    public static final String COMMENT_ROOT = "-1";

    /**
     * 评论类型为文章评论
     */
    public static final String ARTICLE_COMMENT = "0";
    /**
     * 评论类型为链接评论
     */
    public static final String LINK_COMMENT = "1";

    /**
     * 权限类型，菜单
     */
    public static final String TYPE_MENU = "C";

    /**
     * 权限类型，按钮
     */
    public static final String TYPE_BUTTON = "F";

    /**
     * 正常状态
     */
    public static final String NORMAL = "0";

    /**
     * 判断为管理员用户
     */
    public static final String IS_ADMAIN = "1";
}
