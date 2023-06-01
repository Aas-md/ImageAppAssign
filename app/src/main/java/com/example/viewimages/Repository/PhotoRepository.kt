package com.example.viewimages.Repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.viewimages.PhotoApiService
import com.example.viewimages.models.Photo

const val TAG = "PhotoRepository"
class PhotoRepository(private val photoService : PhotoApiService) {

    private val photosLiveData  = MutableLiveData<List<Photo>>()
    val photos : LiveData<List<Photo>>
        get() = photosLiveData

    suspend fun getPhotos(){

        try {
//            val response = RetrofitClient.photoApiService.getPhotos()
    val response = photoService.getPhotos()
            val imageList = response.filter { it.url.endsWith(".jpg") }
               photosLiveData.value = imageList

            }
           catch (e: Exception) {

               Log.e(TAG,"Error $e")
        }
    }

}