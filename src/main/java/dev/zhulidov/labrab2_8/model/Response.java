package dev.zhulidov.labrab2_8.model;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Response{
   private      String uid;
    private     String operationUid;
    private    String systemTime;
    private     Codes       code;
    private     ErrorCodes errorCode;
    private     ErrorMessages errorMessage;

}
