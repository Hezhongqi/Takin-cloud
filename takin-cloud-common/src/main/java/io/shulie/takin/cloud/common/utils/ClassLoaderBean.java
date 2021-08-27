package io.shulie.takin.cloud.common.utils;

import java.io.Serializable;

import lombok.Data;

/**
 * @author shulie
 * @package: com.pamirs.takin.common.util
 * @Date 2019-06-25 17:15
 */
@Data
public class ClassLoaderBean implements Serializable {

    private ClassLoader classLoader;

    private Class<?> loadClass;
}
