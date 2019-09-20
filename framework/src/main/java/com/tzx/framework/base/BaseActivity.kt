package com.tzx.framework.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import rx.Observable
import rx.Subscription
import rx.subscriptions.CompositeSubscription

/**
 * Created by Tanzhenxing
 * Date: 2018/8/22 下午7:37
 * Description:Activity基类
 */
open class BaseActivity : AppCompatActivity() {
    var TAG : String? = "BaseActivity"
    private var mCompositeSubscription: CompositeSubscription? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        TAG = this::class.simpleName
    }

    fun addSubscription(s: Subscription?) {
        if (null == this.mCompositeSubscription) {
            this.mCompositeSubscription = CompositeSubscription()
        }
        this.mCompositeSubscription!!.add(s)
    }

    fun getCompositeSubscription() : CompositeSubscription? {
        if (null == this.mCompositeSubscription) {
            this.mCompositeSubscription = CompositeSubscription()
        }
        return this.mCompositeSubscription
    }

    protected open fun <T> submitForObservable(task: com.tzx.framework.retrofit.RetrofitTask<T>): Observable<T> {
        return task.exeForObservable()
    }


    override fun onDestroy() {
        super.onDestroy()
        if (null != this.mCompositeSubscription) {
            this.mCompositeSubscription!!.unsubscribe()
            this.mCompositeSubscription = null
        }
    }
}