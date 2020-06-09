package com.example.playwithcompose

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.ui.core.setContent
import com.example.playwithcompose.components.BassDetail


class BassDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BassDetail(fakeBasses.first())
        }
    }
}