package dev.zhulidov.labrab2_8.model;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Request{
    //Уникальный идентификатор сообшенния
  @NotBlank @Size(max = 32)
  private String uid;
  //Уникальный идентификатор операции
  @NotBlank @Size(max = 32)
  private String  operationUid;
  //Имя системы отправителя

    private Systems systemName;
    //Время создания сообщения
  @NotBlank
  private LocalDateTime systemTime;
  //Наименование ресурса
    private String source;
    //Позиция перрсонала
    private Positions position;
    //Зарплата
    private Double salary;
    //Бонус
    private Double bonus;
    //Отработанные дни
    private Integer workDays;
//Уникальный идентификатор коммуникации
  @Min(1)
  @Max(10000)
  private int communicationId;
  //Уникальный идентификатор шаблона
    private int templateId;
    //Код продукта
    private int productCode;
    //Смс код
    private int smsCode;
    //
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
