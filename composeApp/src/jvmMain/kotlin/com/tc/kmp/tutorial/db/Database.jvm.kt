package com.tc.kmp.tutorial.db

import androidx.room.Room
import androidx.room.RoomDatabase
import java.io.File


fun getDatabaseBuilder(): RoomDatabase.Builder<TodoDb> {
    val dbFile = File(System.getProperty("user.dir"), "todo.db")
    return Room.databaseBuilder<TodoDb>(
        name = dbFile.absolutePath,
    )
        .fallbackToDestructiveMigration(false)
}