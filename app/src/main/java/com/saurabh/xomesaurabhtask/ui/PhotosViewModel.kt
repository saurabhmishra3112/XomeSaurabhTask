package com.saurabh.xomesaurabhtask.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.saurabh.xomesaurabhtask.domain.Photo
import com.saurabh.xomesaurabhtask.networking.WebClient
import kotlinx.coroutines.launch

class PhotosViewModel(var searchText: String) : ViewModel() {
    private val mutablePhotosLiveData = MutableLiveData<List<Photo>>()
    val photosLiveData: LiveData<List<Photo>> = mutablePhotosLiveData

    init {
        viewModelScope.launch {
            val searchResponse = WebClient.client.fetchImages(searchText)
            val photosList = searchResponse.photos.photo.map { photo ->
                Photo(
                    id = photo.id,
                    url = "https://farm${photo.farm}.staticflickr.com/${photo.server}/${photo.id}_${photo.secret}.jpg",
                    title = photo.title
                )
            }
            mutablePhotosLiveData.postValue(photosList)
        }
    }


}
