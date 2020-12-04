package id.zeynelerdi.infood.core.util

import id.zeynelerdi.infood.core.BuildConfig

object UrlHelper {

    fun getThumbnailUrl(id: String?, imageType: String): String {
        return "${BuildConfig.BASE_URL}/recipeImages/$id-312x231.$imageType"
    }

    fun getBackdropUrl(id: String?, imageType: String): String {
        return "${BuildConfig.BASE_URL}/recipeImages/$id-636x393.$imageType"
    }
}