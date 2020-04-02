package wanzhi.gulu.community.dto;

import lombok.Data;

//点赞收藏踩关注功能的返回信息的DTO
@Data
public class PTSWResultDTO {
    private Integer code;
    private String message;
    private Integer nowStatus;//现在的点赞状态（0表示未点赞，1表示已点赞）或被踩状态
    private Long nowCount; //现在的点赞数或踩数

    //请求成功的话返回的数据
    public static PTSWResultDTO okOf(Integer nowStatus, Long nowCount){
        PTSWResultDTO resultDTO = new PTSWResultDTO();
        resultDTO.setCode(200);
        resultDTO.setMessage("请求成功");
        resultDTO.setNowStatus(nowStatus);
        resultDTO.setNowCount(nowCount);
        return resultDTO;
    }
}
