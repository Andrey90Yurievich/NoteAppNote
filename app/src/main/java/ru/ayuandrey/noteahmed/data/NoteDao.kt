package ru.ayuandrey.noteahmed.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow
@Dao
interface NoteDao {

    @Upsert
    suspend fun upsertNote(note: Note)

    @Delete
    suspend fun deleteNote(note: Note)

    @Query("SELECT * FROM note ORDER BY dateAdded")
    fun getNotesOrderByDateAdded(): Flow<List<Note>> //Каждый раз, когда происходит изменение в таблице, создается новый список с новыми элементами в базе данных

    @Query("SELECT * FROM note ORDER BY title ASC")
    fun getNotesOrderByTitle(): Flow<List<Note>>
}