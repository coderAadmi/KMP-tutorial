package com.tc.kmp.tutorial.db

import androidx.room.RoomDatabaseConstructor


@Suppress("KotlinNoActualForExpect")
expect object TodoDbConstructor : RoomDatabaseConstructor<TodoDb>{
    override fun initialize(): TodoDb
}