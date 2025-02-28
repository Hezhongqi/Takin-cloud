package io.shulie.takin.cloud.data.model.mysql;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value = "t_scene_manage")
public class SceneManageEntity {

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 客户id
     */
    @TableField(value = "customer_id", fill = FieldFill.INSERT)
    private Long customerId;

    /**
     * 部门id
     */
    @TableField(value = "dept_id", fill = FieldFill.INSERT)
    private Long deptId;

    /**
     * 场景名称
     */
    @TableField(value = "scene_name")
    private String sceneName;

    /**
     * 参考数据字典 场景状态
     */
    @TableField(value = "status")
    private Integer status;

    /**
     * 压测场景类型：0普通场景，1流量调试
     */
    @TableField(value = "type")
    private Integer type;

    /**
     * 最新压测时间
     */
    @TableField(value = "last_pt_time")
    private Date lastPtTime;

    /**
     * 施压配置
     */
    @TableField(value = "pt_config")
    private String ptConfig;

    /**
     * 脚本类型：0-Jmeter 1-Gatling
     */
    @TableField(value = "script_type")
    private Integer scriptType;

    /**
     * 是否删除：0-否 1-是
     */
    @TableLogic
    @TableField(value = "is_deleted")
    private Integer isDeleted;

    /**
     * 创建时间
     */
    @TableField(value = "create_time")
    private Date createTime;

    /**
     * 扩展字段
     */
    @TableField(value = "features")
    private String features;


    /**
     * 创建人
     */
    @TableField(value = "create_name")
    private String createName;

    /**
     * 最后修改时间
     */
    @TableField(value = "update_time")
    private Date updateTime;

    /**
     * 最后修改人
     */
    @TableField(value = "update_name")
    private String updateName;

    /**
     * 用户id
     */
    @TableField(value = "user_id", fill = FieldFill.INSERT)
    private Long userId;

}


