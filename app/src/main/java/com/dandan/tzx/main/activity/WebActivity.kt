package com.dandan.tzx.main.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import com.dandan.tzx.R
import com.dandan.tzx.common.activity.BaseActivity
import kotlinx.android.synthetic.main.activity_web_layout.*

/**
 * Created by Tanzhenxing
 * Date: 2019-09-16 10:49
 * Description:
 */
class WebActivity : BaseActivity() {
    companion object {
        public val URL = "url"
        public val TITLE = "title"
        fun startActivity(content:Context, title:String, url:String) {
            val intent = Intent(content, WebActivity::class.java)
            intent.putExtra(URL, url).putExtra(TITLE, title)
            content.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_layout)
        setSupportActionBar(toolBar)
        if (intent != null) {
            val url = intent.getStringExtra(URL)
            if (!TextUtils.isEmpty(url)) {
                webview_layout.loadUrl(url)
            }
            val title = intent.getStringExtra(TITLE)
            if (!TextUtils.isEmpty(title)) {
                supportActionBar?.title = title
            }
            return
        }
        finish()
    }
}