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

    @Override
    public String toString() {
        return "Response{" +
                "uid='" + uid + '\'' +
                ", operationUid='" + operationUid + '\'' +
                ", systemTime='" + systemTime + '\'' +
                ", code=" + code +
                ", errorCode=" + errorCode +
                ", errorMessage=" + errorMessage +
                '}';
    }
}
