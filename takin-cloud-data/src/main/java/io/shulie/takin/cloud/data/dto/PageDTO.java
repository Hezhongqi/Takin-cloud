package io.shulie.takin.cloud.data.dto;

import javax.validation.constraints.Null;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Setter;
import lombok.ToString;

/**
 * 分页类
 *
 * @author liuchuan
 * @date 2021/3/26 6:07 下午
 **/
@ToString
@ApiModel(value = "分页参数类", description = "分页的各种初始化!")
public class PageDTO {

    /**
     * 每页最大数量限制
     */
    public static final int SIZE_LIMIT = 666;

    /**
     * 0
     */
    private static final int ZERO = 0;

    /**
     * 初始页
     */
    private static final int INIT_PAGE = 1;

    /**
     * 初始每页数据量
     */
    private static final int INIT_SIZE = 10;

    @Null
    @ApiModelProperty(value = "当前页数", dataType = "int", example = "1")
    @Setter
    private Integer page;

    @Null
    @ApiModelProperty(value = "每页显示数据个数", dataType = "int", example = "10")
    @Setter
    private Integer size;

    public PageDTO() {
        page = INIT_PAGE;
        size = INIT_SIZE;
    }

    public Integer getPage() {
        return null == page || page < ZERO
                ? INIT_PAGE
                : page;
    }

    public Integer getSize() {
        return null == size || size < ZERO
                ? INIT_SIZE
                : Math.min(size, SIZE_LIMIT);
    }

    /**
     * 起始数
     *
     * @return 起始数
     */
    @ApiModelProperty(hidden = true)
    public Integer getStart() {
        return getPage() > 0 ? (getPage() - 1) * getSize() : 0;
    }

}
