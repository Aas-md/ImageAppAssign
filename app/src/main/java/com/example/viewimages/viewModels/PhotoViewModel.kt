package com.example.viewimages.viewModels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.viewimages.PhotoApiService
import com.example.viewimages.Repository.PhotoRepository
import com.example.viewimages.RetrofitClient
import com.example.viewimages.models.Photo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
const val TAG = "PhotoViewModel"
class PhotoViewModel(private val photoApiService: PhotoApiService): ViewModel() {
    private val _photos = MutableLiveData<List<Photo>>()
    val photos: LiveData<List<Photo>> get() = _photos

    init {
        viewModelScope.launch {
            try {
                val response = RetrofitClient.photoApiService.getPhotos()
                val imageList = response.filter { it.url.isNotEmpty() } // Filter images by URL extension
                _photos.value = imageList
            } catch (e: Exception) {
                Log.e(TAG,"Error $e")
            }
        }
    }
}