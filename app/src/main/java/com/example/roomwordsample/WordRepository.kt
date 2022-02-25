package com.example.roomwordsample

import android.util.Log
import androidx.annotation.WorkerThread
import kotlinx.coroutines.flow.Flow

class WordRepository(private val wordDao: WordDao) {
    companion object{
        var TAG = WordRepository::class.java.simpleName
    }

    //check if internet is there
    var allWords: Flow<List<Word>> = wordDao.getAlphabetizedWords()

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert(word: Word){
        Log.i(TAG,word.word)
        wordDao.insert(word)
    }
}