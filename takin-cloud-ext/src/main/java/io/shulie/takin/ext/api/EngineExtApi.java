package io.shulie.takin.ext.api;

import io.shulie.takin.ext.content.script.ScriptParseExt;
import io.shulie.takin.ext.content.script.ScriptVerityExt;
import io.shulie.takin.ext.content.script.ScriptVerityRespExt;
import io.shulie.takin.plugin.framework.core.extension.ExtensionPoint;

import java.util.List;

/**
 * @author zhaoyong
 * 脚本相关扩展点
 */
public interface EngineExtApi extends ExtensionPoint, Typed {

    /**
     * 脚本内容校验
     * 不实现代表不需要校验，默认通过
     * @param scriptVerityExt 脚本路径和业务请求
     * @return 返回错误信息列表，返回空值代表校验通过
     */
    ScriptVerityRespExt verityScript(ScriptVerityExt scriptVerityExt);


    /**
     * 更新脚本,调整脚本内容以匹配压测
     * 不需要调整可不实现
     * @param uploadPath
     */
    void updateScriptContent(String uploadPath);


    /**
     * 解析脚本文件
     * @param uploadPath
     * @return -
     */
    ScriptParseExt parseScriptFile(String uploadPath);
}
