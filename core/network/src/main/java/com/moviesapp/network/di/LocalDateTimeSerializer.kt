package com.moviesapp.network.di

import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

object LocalDateTimeSerializer : KSerializer<LocalDateTime> {
    override val descriptor: SerialDescriptor =
        PrimitiveSerialDescriptor("LocalDateTime", PrimitiveKind.STRING)

    override fun serialize(encoder: Encoder, value: LocalDateTime) {
        val formatter = DateTimeFormatter.ISO_LOCAL_DATE
        val formattedString = value.format(formatter)
        encoder.encodeString(formattedString)
    }

    override fun deserialize(decoder: Decoder): LocalDateTime {
        val formatter = DateTimeFormatter.ISO_DATE_TIME
        val formattedString = decoder.decodeString()
        return LocalDateTime.parse(formattedString, formatter)
    }
}


object ServerLocalDateTimeSerializer : KSerializer<LocalDate?> {
    override val descriptor: SerialDescriptor =
        PrimitiveSerialDescriptor("LocalDate", PrimitiveKind.STRING)

    private val formatter: DateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")

    override fun serialize(encoder: Encoder, value: LocalDate?) {
        val formattedString = value?.format(formatter)
        formattedString?.let { encoder.encodeString(it) }
    }

    override fun deserialize(decoder: Decoder): LocalDate? {
        return try {
            val formattedString = decoder.decodeString()
            LocalDate.parse(formattedString, formatter)
        } catch (e: Exception) {
            null
        }
    }
}
