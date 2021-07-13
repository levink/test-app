package com.example.network.http

import kotlinx.serialization.Serializable

@Serializable(with = ResultCodeSerializer::class)
enum class ResultCode(val code: Int) {
    //Server codes
    Unknown(0),
    Ok(1),
    OperationError(2),
    SystemError(3),
    BadSessionError(4),
    DeprecatedClientWarning(5),     /* Предупреждаем */
    LegacyClientError(6),           /* Отказываемся работать */

    //Client codes
    HttpError(-1),
    Exception(-2)
}