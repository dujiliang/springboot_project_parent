package com.djl.satoken.user;

import java.time.LocalDateTime;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 * 资源权限
 * </p>
 *
 * @author djl
 * @since 2020-11-17
 */
@Data
@TableName("TB_RESOURCE")
public class Resource implements Serializable {


    private static final long serialVersionUID = -247726191853117340L;
    /**
     * 资源ID
     */
    @TableId(value = "ID", type = IdType.AUTO)
    private Long id;

    /**
     * 资源名
     */
    private String resourceName;

    /**
     * 资源级别
     */
    private String resourceType;

    /**
     * 菜单url
     */
    private String resourceUrl;

    /**
     * 父ID
     */
    private Long parentId;

    /**
     * 创建时间
     */
    private LocalDateTime createDate;

    /**
     * 修改时间
     */
    private LocalDateTime updateDate;


}
