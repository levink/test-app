package com.example.network.model

import kotlinx.serialization.KSerializer
import kotlinx.serialization.Serializable
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

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

object ResultCodeSerializer :  KSerializer<ResultCode> {
    override val descriptor: SerialDescriptor
        get() = PrimitiveSerialDescriptor("Enum", PrimitiveKind.INT)

    override fun deserialize(decoder: Decoder): ResultCode {
        val index = decoder.decodeInt()
        val items = ResultCode.values()
        if (0 < index && index < items.size) {
            return items[index]
        }
        return ResultCode.Unknown
    }
    override fun serialize(encoder: Encoder, value: ResultCode) {
        encoder.encodeInt(value.code)
    }
}