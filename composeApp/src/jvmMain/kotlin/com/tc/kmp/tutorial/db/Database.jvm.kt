package com.tc.kmp.tutorial.db

import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.RoomDatabaseConstructor
import java.io.File

//actual object TodoDbConstructor :
//    RoomDatabaseConstructor<TodoDb> {
//    actual override fun initialize(): TodoDb {
//        TODO("Not yet implemented")
//    }
//}

fun getDatabaseBuilder(): RoomDatabase.Builder<TodoDb> {
    val dbFile = File(System.getProperty("user.dir"), "todo.db")
    return Room.databaseBuilder<TodoDb>(
        name = dbFile.absolutePath,
    )
        .fallbackToDestructiveMigration(false)
}