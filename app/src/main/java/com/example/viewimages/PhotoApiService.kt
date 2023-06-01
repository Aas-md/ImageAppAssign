package com.example.viewimages

import com.example.viewimages.models.Photo
import retrofit2.http.GET

interface PhotoApiService {

    @GET("photos")
    suspend fun getPhotos(): List<Photo>
    //baseUrl + photos
}