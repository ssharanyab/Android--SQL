package com.hs1121.deligetsexample.RecyclerView

import android.content.ContentResolver
import android.content.Context
import android.net.Uri

data class VersionModel(val name:String,val version:Double,val resourceId: Int)

fun Context.resourceUri(resourceId:Int): Uri = with(resources) {
    Uri.Builder()
        .scheme(ContentResolver.SCHEME_ANDROID_RESOURCE)
        .authority(getResourcePackageName(resourceId))
        .appendPath(getResourceTypeName(resourceId))
        .appendPath(getResourceEntryName(resourceId))
        .build()
}
