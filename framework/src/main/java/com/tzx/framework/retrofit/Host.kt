package com.tzx.framework.retrofit

/**
 * Created by Tanzhenxing
 * Date: 2019-09-20 17:11
 * Description:
 */
@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.PROPERTY, AnnotationTarget.CLASS)
annotation class Host(val baseUrl:String)