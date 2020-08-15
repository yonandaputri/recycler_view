package com.example.exercise_recycle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.exercise_recycle.language.viewmodel.LanguageViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), CustomClickListener {

    val languageViewModel by viewModels<LanguageViewModel>()
    lateinit var languageRecycleAdapter: LanguageRecycleAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        language_recycleView.layoutManager = LinearLayoutManager(this)

//        adapter = LanguageRecycleAdapter(languageViewModel.languageLiveData.value!!)
//        language_recycleView.adapter = adapter

        languageRecycleAdapter = LanguageRecycleAdapter(languageViewModel.languageLiveData.value!!)
        languageRecycleAdapter.listener = this
        language_recycleView.adapter = languageRecycleAdapter

        languageViewModel.languageLiveData.observe(this, Observer {
            //language_recycleView.adapter = LanguageRecycleAdapter(it)
            println(it.joinToString())
            languageRecycleAdapter.notifyDataSetChanged()
        })
    }

    fun addButton(view: View) {
        val languageName = language_name_input.text.toString()
        languageViewModel.addLanguage(languageName)
//        language_recycleView.adapter?.notifyDataSetChanged()
    }

    override fun onItemClicked(view: View, language: String) {
        Toast.makeText(view?.context, "${language}", Toast.LENGTH_LONG).show()
    }

    override fun deleteButtonClicked(view: View, index: Int, language: String) {
        Toast.makeText(view?.context, "${language} SUCCESS DELETED", Toast.LENGTH_LONG).show()
        languageViewModel.removeLanguage(index)
    }
}
