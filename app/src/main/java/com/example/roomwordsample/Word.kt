package com.example.roomwordsample

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
//INSERT INTO word_table (word)VALUES ('bajaj');
@Entity(tableName = "word_table")
class Word(@PrimaryKey @ColumnInfo(name = "word") val word: String)
//change this Word[Todo]  to hold two values ie title and notes