package wanzhi.gulu.community.dto;

import lombok.Data;

@Data
public class PraiseResultDTO {
    private Integer code;
    private String message;
    private Integer status;//现在的点赞状态（0表示未点赞，1表示已点赞）

    //请求成功的话返回的数据
    public static PraiseResultDTO okOf(Integer status){
        PraiseResultDTO resultDTO = new PraiseResultDTO();
        resultDTO.setCode(200);
        resultDTO.setMessage("请求成功");
        resultDTO.setStatus(status);
        return resultDTO;
    }
}
