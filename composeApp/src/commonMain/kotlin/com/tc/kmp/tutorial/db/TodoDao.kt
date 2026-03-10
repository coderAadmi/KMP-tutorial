package com.tc.kmp.tutorial.db

import androidx.room.ConstructedBy
import androidx.room.Dao
import androidx.room.Database
import androidx.room.Insert
import androidx.room.OnConflictStrategy.Companion.REPLACE
import androidx.room.Query
import androidx.room.RoomDatabase
import kotlinx.coroutines.flow.Flow

@Dao
interface TodoDao {

    @Query("Select * from todo")
    fun getAll() : Flow<List<TodoEntity>>

    @Insert(onConflict = REPLACE)
    suspend fun insert(todos : List<TodoEntity>)

}



@Database(entities = [TodoEntity::class], version = 1)
@ConstructedBy(TodoDbConstructor::class)
abstract class TodoDb : RoomDatabase() {

    abstract fun getTodoDao(): TodoDao

}

