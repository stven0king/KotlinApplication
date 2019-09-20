package com.tzx.framework.base

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.View
import rx.Observable
import rx.Subscription
import rx.subscriptions.CompositeSubscription


/**
 * Created by Tanzhenxing
 * Date: 2018/8/22 下午8:28
 * Description:
 */

open class BaseFragment : Fragment(), View.OnClickListener {

    protected var TAG: String? = null
    private var mCompositeSubscription : CompositeSubscription? = null

    fun getCompositeSubscription(): CompositeSubscription? {
        if (null == this.mCompositeSubscription) {
            this.mCompositeSubscription = CompositeSubscription()
        }
        return this.mCompositeSubscription
    }

    fun addSubscription(s: Subscription?) {
        if (null == this.mCompositeSubscription) {
            this.mCompositeSubscription = CompositeSubscription()
        }
        this.mCompositeSubscription!!.add(s)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        TAG = this::class.simpleName
    }

    override fun onDestroyView() {
        super.onDestroyView()
        if (null != this.mCompositeSubscription) {
            this.mCompositeSubscription!!.unsubscribe()
            this.mCompositeSubscription = null
        }
    }

    protected open fun <T> submitForObservable(task: com.tzx.framework.retrofit.RetrofitTask<T>): Observable<T> {
        return task.exeForObservable()
    }

    override fun onClick(v: View?) {

    }

}