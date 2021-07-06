package com.example.network.model.base

import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

object ResultCodeSerializer : KSerializer<ResultCode> {
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