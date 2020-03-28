package wanzhi.gulu.community.dto;

import lombok.Data;

@Data
public class ResultDTO {
    private Integer code;
    private String message;

    //请求成功的话返回的数据
    public static ResultDTO okOf(){
        ResultDTO resultDTO = new ResultDTO();
        resultDTO.setCode(200);
        resultDTO.setMessage("请求成功");
        return resultDTO;
    }

    public static ResultDTO okOf(String message){
        ResultDTO resultDTO = new ResultDTO();
        resultDTO.setCode(200);
        resultDTO.setMessage(message);
        return resultDTO;
    }
}
