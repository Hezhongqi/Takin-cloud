package io.shulie.takin.cloud.open.resp.scenemanage;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author xr.l
 * @date 2021-05-10
 */
@Data
@ApiModel("脚本流量试跑任务启动返回值对象")
public class SceneTryRunTaskStartResp implements Serializable {

    @ApiModelProperty("虚拟场景ID")
    private Long sceneId;

    @ApiModelProperty("压测报告ID")
    private Long reportId;

    @ApiModelProperty("用户ID")
    private Long customerId;
}
