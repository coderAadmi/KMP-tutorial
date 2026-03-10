package com.tc.kmp.tutorial.db

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.RoomDatabaseConstructor

//actual object TodoDbConstructor :
//    RoomDatabaseConstructor<TodoDb> {
//    actual override fun initialize(): TodoDb {
//
//    }
//}

fun getDatabaseBuilder(context : Context): RoomDatabase.Builder<TodoDb> {
    val appContext = context.applicationContext
    val dbFile = appContext.getDatabasePath("todo.db")
    return Room.databaseBuilder<TodoDb>(
        context,
        name = dbFile.absolutePath,
    )
        .fallbackToDestructiveMigration(false)
}