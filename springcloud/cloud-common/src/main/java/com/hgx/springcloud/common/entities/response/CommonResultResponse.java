package com.hgx.springcloud.common.entities.response;

import lombok.Data;

@Data
public class CommonResultResponse<T> {

    private String code;

    private String message;

    private T data;

    public CommonResultResponse() {

    }

    public CommonResultResponse(String code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }


//
//
//
//
//
//
//    public static CommonResultResponse success(){
//        CommonResultResponse commonResultResponse = new CommonResultResponse();
//        commonResultResponse.setCode("200");
//        commonResultResponse.setMessage("成功");
//        return commonResultResponse ;
//    }
//
//    public static CommonResultResponse success(Object data){
//        CommonResultResponse commonResultResponse = new CommonResultResponse();
//        commonResultResponse.setCode("200");
//        commonResultResponse.setMessage("成功");
//        commonResultResponse.setData(data);
//        return commonResultResponse ;
//    }
//
//    public static CommonResultResponse fail(Object data){
//        CommonResultResponse commonResultResponse = new CommonResultResponse();
//        commonResultResponse.setCode("500");
//        commonResultResponse.setMessage("失败");
//        commonResultResponse.setData(data);
//        return commonResultResponse ;
//    }
//
//    public static CommonResultResponse fail(){
//        CommonResultResponse commonResultResponse = new CommonResultResponse();
//        commonResultResponse.setCode("500");
//        commonResultResponse.setMessage("失败");
//        return commonResultResponse ;
//    }
//
//
//    public static CommonResultResponse fail(String code,String message){
//        CommonResultResponse commonResultResponse = new CommonResultResponse();
//        commonResultResponse.setCode(code);
//        commonResultResponse.setMessage(message);
//        return commonResultResponse ;
//    }
//
//
//    public static CommonResultResponse fail(String code,String message,Object data){
//        CommonResultResponse commonResultResponse = new CommonResultResponse();
//        commonResultResponse.setCode(code);
//        commonResultResponse.setMessage(message);
//        commonResultResponse.setData(data);
//        return commonResultResponse ;
//    }


}
