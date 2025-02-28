package io.shulie.takin.cloud.open.req.engine;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author moriarty
 */
@Data
@ApiModel("场景使用压测引擎插件")
public class EnginePluginsRefOpen implements Serializable {

    @ApiModelProperty(value = "插件Id")
    private Long pluginId;

    @ApiModelProperty(value = "插件版本号")
    private String version;
}
