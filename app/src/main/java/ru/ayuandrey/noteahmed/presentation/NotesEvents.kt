package ru.ayuandrey.noteahmed.presentation

import android.icu.text.CaseMap.Title
import ru.ayuandrey.noteahmed.data.Note

sealed interface NotesEvent {
    object SortNotes : NotesEvent

    data class DeleteNote(val note: Note) : NotesEvent
    data class SaveNote(
        val title: String,
        val description: String
    ) : NotesEvent
}