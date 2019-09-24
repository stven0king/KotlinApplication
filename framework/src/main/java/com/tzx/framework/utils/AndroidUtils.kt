package com.tzx.framework.utils

import android.widget.Toast
import com.tzx.framework.base.FConfig

/**
 * Created by Tanzhenxing
 * Date: 2019-09-24 09:54
 * Description:
 */
fun toast(s:CharSequence) {
    Toast.makeText(FConfig.application!!, s, Toast.LENGTH_SHORT).show()
}