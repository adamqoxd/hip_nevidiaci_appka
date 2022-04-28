package sk.zavacky.hip_zadanie_appka.initial_settings

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Question(
    val datastoreTag: String,
    val description: String,
    val fuck : Boolean
) : Parcelable
