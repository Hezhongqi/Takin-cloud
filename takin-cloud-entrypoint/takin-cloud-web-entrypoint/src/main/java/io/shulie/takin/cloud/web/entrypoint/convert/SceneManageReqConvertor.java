package io.shulie.takin.cloud.web.entrypoint.convert;

import io.shulie.takin.cloud.biz.input.scenemanage.SceneManageWrapperInput;
import io.shulie.takin.cloud.web.entrypoint.request.scenemanage.SceneManageWrapperRequest;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author zhaoyong
 */
@Mapper
public interface SceneManageReqConvertor {

    SceneManageReqConvertor INSTANCE = Mappers.getMapper(SceneManageReqConvertor.class);

    /**
     * 入参转换
     * @param wrapperRequest
     * @return -
     */
    SceneManageWrapperInput ofSceneManageWrapperInput(SceneManageWrapperRequest wrapperRequest);
}
