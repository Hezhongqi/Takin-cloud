package com.pamirs.takin.entity.domain.vo.strategy;

import java.io.Serializable;

import io.shulie.takin.common.beans.page.PagingDevice;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author qianshui
 * @date 2020/5/9 下午3:38
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class StrategyConfigQueryVO extends PagingDevice implements Serializable {

    private static final long serialVersionUID = -3147379828546697247L;

}
