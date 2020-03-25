package model;

public enum DocStatus {
    NEW, // новый документ
    VALIDATED, // проверен (верный формат, корректные данные)
    VALIDATIONERROR, // ошибка проверки документа
    REGISTERED, // зарегистрирован
    REGISTRATIONNUMBERCHANGED, // регистрационный номер изменен
    REGISTRATIONREJECTED, // отказано в регистраци
    PROCESSED // документ обработан
}
