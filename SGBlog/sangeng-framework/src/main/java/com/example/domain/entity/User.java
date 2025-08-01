//package com.example.domain.entity;
//
//import java.util.Date;
//import java.io.Serializable;
//
//import com.baomidou.mybatisplus.annotation.TableName;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
///**
// * 用户表(User)表实体类
// *
// * @author makejava
// * @since 2025-05-25 15:27:37
// */
//@SuppressWarnings("serial")
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//@TableName("sys_user")
//public class User  {
//
//    private Integer id;
////用户名
//    private String userName;
////昵称
//    private String nickName;
////密码
//    private String password;
////用户类型：0代表普通用户，1代表管理员
//    private String type;
////账号状态（0正常 1停用）
//    private String status;
////邮箱
//    private String email;
////手机号
//    private String phonenumber;
////用户性别（0男，1女，2未知）
//    private String sex;
////头像
//    private String avatar;
////创建人的用户id
//    private Long createBy;
////创建时间
//    private Date createTime;
////更新人
//    private Long updateBy;
////更新时间
//    private Date updateTime;
////删除标志（0代表未删除，1代表已删除）
//    private Integer delFlag;
//
//
//}
//

package com.example.domain.entity;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 用户表(User)表实体类
 *
 * @author makejava
 * @since 2023-07-22 20:41:51
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("sys_user")
public class User  {

    //主键
    @TableId(type = IdType.AUTO)
    private Long id;

    //用户名
    private String userName;
    //昵称
    private String nickName;
    //密码
    private String password;
    //用户类型：0代表普通用户，1代表管理员
    private String type;
    //账号状态（0正常 1停用）
    private String status;
    //邮箱
    private String email;
    //手机号
    private String phonenumber;
    //用户性别（0男，1女，2未知）
    private String sex;
    //头像
    private String avatar;
    //字段自增
    @TableField(fill = FieldFill.INSERT)
    private Long createBy;
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Long updateBy;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;
    //删除标志（0代表未删除，1代表已删除）
    private Integer delFlag;

    //关联角色id数组，非user表字段
    @TableField(exist = false)
    private Long[] roleIds;
}