package com.tzx.framework.utils

import android.content.Context

/**
 * Created by Tanzhenxing
 * Date: 2019-09-23 15:55
 * Description:
 */
class SpUtils(private val context: Context,
              private val spName:String) {
    private var mode = Context.MODE_PRIVATE
    private val mContext by lazy { context.applicationContext }
    private val mPreferences by lazy { mContext.getSharedPreferences(spName, mode) }
    private val mEditor by lazy { mPreferences.edit() }

    constructor(context: Context,
                spName:String,
                mode:Int): this(context, spName) {
        this.mode = mode
    }
    
    fun isContainKey(key:String): Boolean = this.mPreferences.contains(key)
    
    fun clearItem(key: String): Boolean = this.mEditor.remove(key).commit()
    
    fun setString(key: String, value:String): Boolean {
        if (isContainKey(key)) {
            this.mEditor.remove(key)
        }
        return this.mEditor.putString(key, value).commit()
    }

    fun setBoolean(key: String, value: Boolean): Boolean {
        if (isContainKey(key)) {
            this.mEditor.remove(key)
        }
        return this.mEditor.putBoolean(key, value).commit()
    }

    fun setInt(key: String, value: Int): Boolean {
        if (isContainKey(key)) {
            this.mEditor.remove(key)
        }
        return this.mEditor.putInt(key, value).commit()
    }

    fun setFloat(key: String, value: Float): Boolean {
        if (isContainKey(key)) {
            this.mEditor.remove(key)
        }
        return this.mEditor.putFloat(key, value).commit()
    }

    fun setLong(key: String, value: Long): Boolean {
        if (isContainKey(key)) {
            this.mEditor.remove(key)
        }
        return this.mEditor.putLong(key, value).commit()
    }
    
    fun getString(key: String): String = this.mPreferences.getString(key, "")

    fun getString(key: String, defValue: String): String = this.mPreferences.getString(key, defValue)
    
    fun getInt(key: String): Int = this.mPreferences.getInt(key, 0)
    
    fun getInt(key: String, defValue: Int): Int = this.mPreferences.getInt(key, defValue)

    fun getFloat(key: String): Float = this.mPreferences.getFloat(key, 0f)

    fun getFloat(key: String, defValue: Float): Float = this.mPreferences.getFloat(key, defValue)

    fun getBoolean(key: String): Boolean = this.mPreferences.getBoolean(key, false)

    fun getBoolean(key: String, defValue: Boolean): Boolean = this.mPreferences.getBoolean(key, defValue)

    fun getLong(key: String): Long = this.mPreferences.getLong(key, 0)

    fun getLong(key: String, defValue: Long): Long = this.mPreferences.getLong(key, defValue)
}