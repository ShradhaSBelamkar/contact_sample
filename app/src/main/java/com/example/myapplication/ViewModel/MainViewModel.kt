package com.example.myapplication.ViewModel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.Model.Contact
import com.example.myapplication.Utils.Utils
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class MainViewModel(private val utils: Utils) : ViewModel() {
    private val mutableContacts = MutableLiveData<List<Contact>>()
    val contacts: LiveData<List<Contact>> get() = mutableContacts

    fun fetchContacts(context: Context) {
        val jsonString = utils.getJson(context, "data.json")

        val gson = Gson()
        val listContactType = object : TypeToken<List<Contact>>() {}.type

        val contacts = gson.fromJson<List<Contact>>(jsonString, listContactType)
        mutableContacts.value = contacts
    }
}