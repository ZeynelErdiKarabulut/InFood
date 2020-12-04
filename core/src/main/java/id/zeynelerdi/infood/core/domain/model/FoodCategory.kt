package id.zeynelerdi.infood.core.domain.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class FoodCategory(
    val id: Int,
    val title: String?,
    val iconUrl: String?
) : Parcelable