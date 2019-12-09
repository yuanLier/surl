package com.demo.demosurl.demosurl.util.response;

/**
 * @author yuanyiwen
 * @create 2019-12-07 19:10
 * @description
 */
public class ResponseUtil {
    public static enum ResponseStatus{

        Success(1),
        Fail(0);

        ResponseStatus(int code){
            this.code = code;
        }

        private int code;

        public int getCode(){
            return code;
        }
    }

    /**
     * 创建响应map的工具方法
     * @param code：响应代码：1标识成功，0标识失败
     * @param msg：如果失败后将返回错误信息
     * @param data：需要响应的数据
     * @return ：
     */
    public static <T> ResponseVo<T> toResponseVo(int code, String msg, T data){

        ResponseVo<T> responseVo = new ResponseVo<>();

        responseVo.setCode(code);
        responseVo.setMsg(msg);
        responseVo.setData(data);

        return responseVo;
    }

    public static <T> ResponseVo<T> toSuccessResponseVo(T data){

        ResponseVo<T> responseVo = new ResponseVo<>();

        responseVo.setCode(ResponseStatus.Success.getCode());
        responseVo.setMsg(null);
        responseVo.setData(data);

        return responseVo;
    }

    public static <T> ResponseVo<T> toSuccessResponseVoWithNoData(){

        return toSuccessResponseVo(null);
    }

    public static <T> ResponseVo<T> toFailResponseVo(String msg){

        ResponseVo<T> responseVo = new ResponseVo<>();

        responseVo.setCode(ResponseStatus.Fail.getCode());
        responseVo.setMsg(msg);
        responseVo.setData(null);

        return responseVo;
    }

    public static <T> ResponseVo<T> toFailResponseVoWithNoMessage(){

        return toFailResponseVo(null);
    }

    public  static String tojs(String msg){
        return msg;
    }
}
