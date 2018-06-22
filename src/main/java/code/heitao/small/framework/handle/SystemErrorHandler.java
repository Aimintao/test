package code.heitao.small.framework.handle;

import code.heitao.small.framework.constant.ErrorEnum;
import code.heitao.small.framework.exception.BaseException;
import code.heitao.small.framework.exception.BaseResult;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Aimin
 * @Title: SystemErrorHandler
 * @ProjectName lightFrame架构
 * @Description: 系统异常全局处理
 * @date 2018/6/14 12:04
 */
@Slf4j
public class SystemErrorHandler {
    /**
     * @Description: TODO
     * @param 
     * @return 
     * @author Aimin 
     * @date 2018/6/14 14:02
     */
    public BaseResult<Void> errorHandler(Exception ex){
        if (ex instanceof BaseException) {
            BaseException baseException =(BaseException) ex;
            return BaseResult.buildFailResult(baseException.getMsg());
        }else{
            log.error("系统未知错误.",ex);
            return BaseResult.buildFailResult(ErrorEnum.SYSTEM_ERROR.getMsg());
        }
    }

}
