package code.heitao.small.framework.exception;

import code.heitao.small.framework.constant.ErrorEnum;
import lombok.Data;

@Data
public class BaseException extends RuntimeException{
    private String code;
    private String msg;

    public BaseException(ErrorEnum errorConst){
        this.msg = errorConst.getMsg();
        this.code = errorConst.getCode();
    }
}
