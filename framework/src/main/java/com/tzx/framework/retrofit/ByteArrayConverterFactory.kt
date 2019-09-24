package com.tzx.framework.retrofit

import okhttp3.ResponseBody
import org.json.JSONObject
import retrofit2.Converter
import retrofit2.Retrofit
import java.lang.Exception
import java.lang.reflect.Type

/**
 * Created by Tanzhenxing
 * Date: 2019-09-24 14:22
 * Description:
 */
class ByteArrayConverterFactory private constructor(): Converter.Factory() {
    companion object{
        private val INSTANCE = ByteArrayConverterFactory()
        fun create(): ByteArrayConverterFactory = INSTANCE
    }
    private val converter = ByteArrayConverter()
    override fun responseBodyConverter(type: Type, annotations: Array<Annotation>, retrofit: Retrofit): Converter<ResponseBody, *>? {
        return if (type == ByteArray::class.java) {
            converter
        } else {
            null
        }
    }

    class ByteArrayConverter : Converter<ResponseBody, ByteArray> {
        override fun convert(value: ResponseBody): ByteArray {
            try {
                return value.bytes()
            } catch (e: Exception) {
                throw IllegalArgumentException(e)
            }
        }

    }
}