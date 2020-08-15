package com.example.exercise_recycle

import android.view.View

interface CustomClickListener {
    fun onItemClicked(view: View, language: String)
    fun deleteButtonClicked(view: View, index: Int, language: String)
}