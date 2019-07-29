package com.example.edukacija_masterdetail.data.model

import android.os.Parcel
import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "beer_table")
data class Beer(
    @PrimaryKey val id: Int,
    @ColumnInfo val imageUrl: String?,
    @ColumnInfo val name: String?,
    @ColumnInfo val price: Double,
    @ColumnInfo val promo: Int,
    @ColumnInfo val quantity: Int
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString(),
        parcel.readString(),
        parcel.readDouble(),
        parcel.readInt(),
        parcel.readInt()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(imageUrl)
        parcel.writeString(name)
        parcel.writeDouble(price)
        parcel.writeInt(promo)
        parcel.writeInt(quantity)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Beer> {
        override fun createFromParcel(parcel: Parcel): Beer {
            return Beer(parcel)
        }

        override fun newArray(size: Int): Array<Beer?> {
            return arrayOfNulls(size)
        }
    }
}