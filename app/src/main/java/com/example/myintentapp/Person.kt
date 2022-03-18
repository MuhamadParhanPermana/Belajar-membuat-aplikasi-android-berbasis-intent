package com.example.myintentapp

import android.os.Parcel
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Person(
    val name: String?,
    val email: String?,
    val age: Int?,
    val city: String?
) : Parcelable