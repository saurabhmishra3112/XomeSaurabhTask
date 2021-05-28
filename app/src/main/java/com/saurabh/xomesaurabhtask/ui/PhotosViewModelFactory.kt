package com.saurabh.xomesaurabhtask.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class PhotosViewModelFactory(private val search: String) : ViewModelProvider.NewInstanceFactory() {

        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return PhotosViewModel(search) as T
        }

}