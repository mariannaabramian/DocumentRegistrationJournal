package ru.levelup.model;

public enum DocStatus {
    NEW, // новый документ
    VALIDATED, // проверен (верный формат, корректные данные)
    VALIDATIONERROR, // ошибка проверки документа
    REGISTERED, // зарегистрирован
    REGISTRATIONREJECTED, // отказано в регистраци
    UNDERCONSIDARATION,
    PROCESSED // документ обработан
}
