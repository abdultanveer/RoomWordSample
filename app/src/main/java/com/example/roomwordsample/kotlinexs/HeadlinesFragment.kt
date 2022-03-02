package com.example.roomwordsample.kotlinexs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.roomwordsample.R

class HeadlinesFragment: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
         super.onCreateView(inflater, container, savedInstanceState)
        var layout: View = inflater.inflate(R.layout.fragment_headlines,container,false)
        return layout
    }

}