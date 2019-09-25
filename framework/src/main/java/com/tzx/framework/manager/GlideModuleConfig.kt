package com.tzx.framework.manager
import android.content.Context
import com.bumptech.glide.GlideBuilder
import com.bumptech.glide.annotation.GlideModule
import com.bumptech.glide.load.engine.cache.InternalCacheDiskCacheFactory
import com.bumptech.glide.load.engine.cache.LruResourceCache
import com.bumptech.glide.module.AppGlideModule

/**
 * Created by Tanzhenxing
 * Date: 2018/8/24 上午8:57
 * Description:
 */
@GlideModule
class GlideModuleConfig : AppGlideModule() {
    override fun applyOptions(context: Context?, builder: GlideBuilder?) {
        val memoryCacheSizeBytes: Long = 1024 * 1024 * 20 // 20mb
        builder!!.setMemoryCache(LruResourceCache(memoryCacheSizeBytes))
        val diskCacheSizeBytes: Long = 1024 * 1024 * 100  //100 MB
        builder.setDiskCache(InternalCacheDiskCacheFactory(context, "imageCache", diskCacheSizeBytes))
    }
}