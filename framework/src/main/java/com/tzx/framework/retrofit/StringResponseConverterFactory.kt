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
class StringResponseConverterFactory private constructor(): Converter.Factory() {
    companion object{
        private val INSTANCE = StringResponseConverterFactory()
        fun create(): StringResponseConverterFactory = INSTANCE
    }
    private val converter = StringResponseConverter()
    override fun responseBodyConverter(type: Type, annotations: Array<Annotation>, retrofit: Retrofit): Converter<ResponseBody, *>? {
        return if (type == String::class.java) {
            converter
        } else {
            null
        }
    }

    class StringResponseConverter : Converter<ResponseBody, String> {
        override fun convert(value: ResponseBody): String {
            try {
                return value.string()
            } catch (e: Exception) {
                throw IllegalArgumentException(e)
            }
        }

    }
}