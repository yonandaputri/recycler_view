package com.example.exercise_recycle.language.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.text.FieldPosition

class LanguageViewModel : ViewModel() {
    val languageList: MutableList<String> = mutableListOf<String>(
        "Java",
        "Python",
        "C",
        "Golang",
        "Swift",
        "Kotlin",
        "Ruby",
        "JS",
        "C++",
        "Dart",
        "C#",
        "R"
    )

    val languageLiveData: MutableLiveData<MutableList<String>> = MutableLiveData(languageList)

    fun addLanguage(name: String) {
        languageList.add(name)
        languageLiveData.value = languageList
        println(languageLiveData.value?.size)
    }

    fun removeLanguage(position: Int) {
        languageList.removeAt(position)
        languageLiveData.value = languageList
    }
}