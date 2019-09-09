package com.dandan.tzx.main.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.widget.ImageView
import com.dandan.tzx.R
import com.dandan.tzx.common.activity.BaseActivity
import com.dandan.tzx.config.GlideApp
import kotlinx.android.synthetic.main.image_preview_layout.*

/**
 * Created by Tanzhenxing
 * Date: 2019-09-03 20:03
 * Description:
 */
class PicPreviewActivity : BaseActivity(){
    private var url: String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.image_preview_layout)
        setSupportActionBar(toolBar)
        getIntentData()
        val image = findViewById<ImageView>(R.id.image)
        GlideApp.with(this).load(url).into(image)
    }

    fun getIntentData() {
        if (intent != null) {
            url = intent.getStringExtra("url")
        }
    }

    companion object {
        fun startActivity(context: Context, url: String) {
            if (TextUtils.isEmpty(url)) {
                return
            }
            val intent = Intent(context, PicPreviewActivity::class.java)
            intent.putExtra("url", url)
            context.startActivity(intent)
        }
    }
}