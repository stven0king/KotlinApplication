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
class JSONObjectResponseConverterFactory private constructor(): Converter.Factory() {
    companion object{
        private val INSTANCE = JSONObjectResponseConverterFactory()
        fun create(): JSONObjectResponseConverterFactory = INSTANCE
    }
    private val converter = JSONObjectResponseConverter()
    override fun responseBodyConverter(type: Type, annotations: Array<Annotation>, retrofit: Retrofit): Converter<ResponseBody, *>? {
        return if (type == JSONObject::class.java) {
            converter
        } else {
            null
        }
    }

    class JSONObjectResponseConverter : Converter<ResponseBody, JSONObject> {
        override fun convert(value: ResponseBody): JSONObject {
            try {
                val s = value.string()
                return JSONObject(s)
            } catch (e: Exception) {
                throw IllegalArgumentException(e)
            }
        }

    }
}