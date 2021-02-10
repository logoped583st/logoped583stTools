package com.logopedBibucket.room.di

import android.content.Context
import androidx.room.Room
import com.logopedBibucket.room.db.AppDb

object RoomModule {

    fun createDb(context: Context): AppDb {
        return Room.databaseBuilder(
                context,
                AppDb::class.java,
                "room"
        ).build()
    }

}