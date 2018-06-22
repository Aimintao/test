package code.heitao.small.framework.exception;

import lombok.Data;

@Data
public class BaseResult<T> {
    private boolean success;
    private String msg;
    private T value;

    private BaseResult(boolean success){
        this.success = success;
    }

    private BaseResult(boolean success,T value){
        this.success = success;
        this.value = value;
    }

    private BaseResult(boolean success,String msg){
        this.success = success;
        this.msg = msg;
    }
    public static BaseResult<Void> buildSimpleSuccessResult(){
        return new BaseResult<Void>(true);
    }
    public static <T> BaseResult<T> buildSuccessResult(T value){
        return new BaseResult<T>(true,value);
    }
    public static <T> BaseResult<T> buildFailResult(String msg){
        return new BaseResult<T>(false,msg);
    }
}
