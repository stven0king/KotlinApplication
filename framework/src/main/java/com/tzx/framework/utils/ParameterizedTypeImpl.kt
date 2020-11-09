package com.tzx.framework.utils

import java.lang.reflect.ParameterizedType
import java.lang.reflect.Type

/**
 * Created by Tanzhenxing
 * Date: 2020/11/6 3:53 PM
 * Description:
 */
class ParameterizedTypeImpl(
        private val ownerType: Type?,
        private val rawType: Type?,
        vararg actualTypeArguments: Type?) : ParameterizedType {

    private val actualTypeArguments: Array<Type> = actualTypeArguments as Array<Type>


    override fun getActualTypeArguments(): Array<Type> {
        return actualTypeArguments
    }

    override fun getRawType(): Type? {
        return rawType
    }

    override fun getOwnerType(): Type? {
        return ownerType
    }

}