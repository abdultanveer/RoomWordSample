package com.example.roomwordsample

import android.util.Log
import androidx.lifecycle.*
import kotlinx.coroutines.launch

class WordViewModel(private val repository: WordRepository): ViewModel() {
    companion object{
        var TAG = WordViewModel::class.java.simpleName
    }
    val allWords: LiveData<List<Word>> = repository.allWords.asLiveData()

    /* fun getAllWords():LiveData<List<Word>>{

        Log.i(WordRepository.TAG,word.word)
        return repository.allWords.asLiveData()
     }*/

    fun insert(word: Word) = viewModelScope.launch {
        Log.i(WordRepository.TAG,word.word)
        repository.insert(word)
    }
}

class WordViewModelFactory(private val repository: WordRepository) : ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T{
        if (modelClass.isAssignableFrom(WordViewModel::class.java)){
            @Suppress("UNCHECKED_CAST")
            return WordViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
