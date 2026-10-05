package dev.zhulidov.labrab2_8.model;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Builder;

@Builder
public record Request(
  @NotBlank @Size(max = 32) String uid,
  @NotBlank @Size(max = 32) String  operationUid,
        String systemName,
  @NotBlank      String systemTime,
        String source,
  @Min(1)@Max(10000) int communicationId,
        int templateId,
        int productCode,
        int smsCode
) {
}
