package wanzhi.gulu.community.dto;

import lombok.Data;

@Data
public class SmsResponse {
    private String Message;
    private String RequestId;
    private String BizId;
    private String Code;
}
