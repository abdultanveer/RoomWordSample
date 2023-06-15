package com.example.roomwordsample

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.observe
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    private var myAquarium: Aquarium? = null

    companion object{
        var TAG = MainActivity::class.java.simpleName
    }

    private val newWordActivityRequestCode = 1
    private val wordViewModel: WordViewModel by viewModels {
        WordViewModelFactory((application as WordsApplication).repository)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        myAquarium = Aquarium(this.application,lifecycle)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerview)
        val adapter = WordListAdapter()
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        val fab = findViewById<FloatingActionButton>(R.id.fab)
        fab.setOnClickListener {
          val intent = Intent(this@MainActivity, NewWordActivity::class.java)
            startActivityForResult(intent, newWordActivityRequestCode)
            //pleaseShowToast("fab was clicked")
        }


        // Add an observer on the LiveData returned by getAlphabetizedWords.
        // The onChanged() method fires when the observed data changes and the activity is
        // in the foreground. mainactivity is subscribing to viewmodel
        wordViewModel.allWords.observe(owner = this) { words ->   //im registering activity as an observer with the viewmodel
            // Update the cached copy of the words in the adapter.
            Log.i(TAG,"added word is--"+words.get(words.size-1).word)

            words.let { adapter.submitList(it) }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, intentData: Intent?) {
        super.onActivityResult(requestCode, resultCode, intentData)

        if (requestCode == newWordActivityRequestCode && resultCode == Activity.RESULT_OK) {
            intentData?.getStringExtra(NewWordActivity.EXTRA_REPLY)?.let { reply ->
                val word = Word(reply)
                wordViewModel.insert(word)
            }
        } else {
            pleaseShowToast("this is my message")
            Toast.makeText(
                applicationContext,
                R.string.empty_not_saved,
                Toast.LENGTH_LONG
            ).show()
        }
    }

    fun Context.pleaseShowToast(message: String){
        Toast.makeText(applicationContext,message,Toast.LENGTH_SHORT).show()
    }
}