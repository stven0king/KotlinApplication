package com.dandan.tzx.common.network

import android.util.Log
import rx.Subscriber
import java.io.IOException
import java.io.PrintWriter
import java.io.StringWriter
import java.lang.Exception

/**
 * Created by Tanzhenxing
 * Date: 2019-09-03 15:22
 * Description:
 */
open class SimpleSubscriber<T> : Subscriber<T>() {
    open override fun onNext(t: T) {
        Log.d("SimpleSubscriber", "onNext")
    }

    open override fun onCompleted() {
        Log.d("SimpleSubscriber", "onCompleted")
    }

    open override fun onError(e: Throwable?) {
        Log.w("SimpleSubscriber", "[onError]" + getStackTrace(e!!))
    }

    fun getStackTrace(e: Throwable): String {
        val sw = StringWriter()
        val pw = PrintWriter(sw)
        try {
            e.printStackTrace(pw)
            pw.flush()
            sw.flush()
        } catch (e: Exception) {
            e.printStackTrace()
        } finally {
            try {
                sw.close()
            } catch (e: IOException) {
                e.printStackTrace()
            }
            pw.close()
        }
        return sw.toString()
    }
}