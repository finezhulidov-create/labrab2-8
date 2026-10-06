package dev.zhulidov.labrab2_8.model;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Request{
  @NotBlank @Size(max = 32)private String uid;
  @NotBlank @Size(max = 32)private String  operationUid;
    private Systems systemName;
  @NotBlank
  private    String systemTime;
    private String source;
  @Min(1)@Max(10000)private int communicationId;
    private int templateId;
    private int productCode;
    private int smsCode;
    private Long currentMillis;

    @Override
    public String toString() {
        return "Request{" +
                "uid='" + uid + '\'' +
                ", operationUid='" + operationUid + '\'' +
                ", systemName=" + systemName +
                ", systemTime='" + systemTime + '\'' +
                ", source='" + source + '\'' +
                ", communicationId=" + communicationId +
                ", templateId=" + templateId +
                ", productCode=" + productCode +
                ", smsCode=" + smsCode +
                ", currentMillis=" + currentMillis +
                '}';
    }
}
