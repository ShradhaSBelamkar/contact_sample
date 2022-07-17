package com.example.myapplication.Module

import com.example.myapplication.ViewModel.MainViewModel
import com.example.myapplication.Utils.Utils
import org.koin.dsl.module

var appModule = module {
    single { Utils() }
    factory { MainViewModel(get()) }
}