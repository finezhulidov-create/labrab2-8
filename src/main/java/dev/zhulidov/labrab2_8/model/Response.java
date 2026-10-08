package dev.zhulidov.labrab2_8.model;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Response{
    //Уникальный идентификатор сообщение
   private      String uid;
   //Уникальный идентификатор операции
    private     String operationUid;
    //Имя системы отправителя
    private    String systemTime;
    //Время создания сообщения
    private     Codes       code;
    //Наименование ресурса
    private     ErrorCodes errorCode;
    //Сообщение об ошибке
    private     ErrorMessages errorMessage;
    //Годовой бонус
    private Double annualBonus;

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
