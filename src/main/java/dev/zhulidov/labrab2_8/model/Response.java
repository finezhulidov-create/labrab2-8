package dev.zhulidov.labrab2_8.model;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Response{
        String uid;
        String operationUid;
        String systemTime;
        String       code;
        String errorCode;
        String errorMessage;

}
