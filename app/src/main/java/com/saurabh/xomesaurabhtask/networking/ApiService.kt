package com.saurabh.xomesaurabhtask.networking

import com.saurabh.xomesaurabhtask.data.PhotosSearchResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("?method=flickr.photos.search&api_key=3e7cc266ae2b0e0d78e279ce8e361736&format=json&nojsoncallback=1&safe_search=1")
    suspend fun fetchImages(@Query("text") text: String): PhotosSearchResponse
}
