package com.tzx.framework.utils

import android.text.TextUtils
import com.google.gson.Gson
import com.google.gson.JsonSyntaxException
import java.lang.reflect.ParameterizedType
import java.lang.reflect.Type

/**
 * Created by Tanzhenxing
 * Date: 2020/11/6 3:48 PM
 * Description:
 */
object JsonUtils {
    fun toJson(obj: Any?): String? {
        if (obj == null) {
            return null
        }
        try {
            return Gson().toJson(obj)
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return null
    }

    /**
     * 将Json转换成对象
     *
     * @param jsonContent json串
     * @param clazz       Json对象
     * @return 返回对应的object
     */
    fun <T> fromJson(jsonContent: String?, clazz: Class<T>?): T? {
        var instance: T? = null
        try {
            instance = Gson().fromJson(jsonContent, clazz)
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return instance
    }

    /**
     * 将Json转换成数组
     *
     * @param jsonContent json串
     * @param type        Json数组
     * @return 返回对应的object
     */
    @Deprecated("")
    fun fromJson(jsonContent: String?, type: Type?): Any? {
        var instance: Any? = null
        try {
            instance = Gson().fromJson<Any>(jsonContent, type)
        } catch (e: JsonSyntaxException) {
            e.printStackTrace()
        }
        return instance
    }

    /**
     * 从json数据中获得list列表
     *
     * @param jsonContent json数据
     * @param clazz       vo数据类型
     * @return 返回ArrayList
     */
    fun <T> toList(jsonContent: String?, clazz: Class<T>?): MutableList<*>? {
        return fromJson(jsonContent, MutableList::class.java, clazz)
    }

    /**
     * json转化的object
     *
     * @param json                json字符串
     * @param rawType             actualTypeArguments的外部类
     * @param actualTypeArguments json转化的class
     * @return json转化的object
     */
    fun <T> fromJson(json: String?, rawType: Class<T>?, vararg actualTypeArguments: Type?): T? {
        return fromJson(json, ParameterizedTypeImpl(null, rawType, *actualTypeArguments))
    }

    /**
     * json转化的object
     *
     * @param json              json字符串
     * @param parameterizedType json转化的type
     * @return json转化的object
     */
    private fun <T> fromJson(json: String?, parameterizedType: ParameterizedType?): T? {
        if (TextUtils.isEmpty(json) || parameterizedType == null) {
            return null
        }
        try {
            return Gson().fromJson(json, parameterizedType)
        } catch (e: JsonSyntaxException) {
            e.printStackTrace()
        }
        return null
    }
}