package science.example.week5cat.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import kotlinx.serialization.Serializable

@Parcelize
@Serializable
data class Cat(
    val id: String = "",
    val url: String = ""
) : Parcelable
