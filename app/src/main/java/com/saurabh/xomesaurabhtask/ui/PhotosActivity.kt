package com.saurabh.xomesaurabhtask.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.saurabh.xomesaurabhtask.R
import kotlinx.android.synthetic.main.activity_photos.*

class PhotosActivity : AppCompatActivity() {

    private lateinit var photosViewModel: PhotosViewModel
    private val photosAdapter = PhotosAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_photos)

        search_btn.setOnClickListener{
            searchImage(editText.text.toString())
        }
    }

     private fun searchImage(searchText : String){
        photosViewModel = ViewModelProviders.of(this,PhotosViewModelFactory(searchText)).get(
            PhotosViewModel::class.java)
        recyclerView.adapter = photosAdapter
        recyclerView.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL, true)
        photosViewModel.photosLiveData.observe(this,
            Observer { list ->
                with(photosAdapter) {
                    photos.clear()
                    photos.addAll(list)
                    notifyDataSetChanged()
                }
            })
    }
}
