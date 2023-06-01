package com.example.viewimages

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.viewimages.Repository.PhotoRepository
import com.example.viewimages.viewModels.PhotoViewModel
import kotlinx.android.synthetic.main.activity_content.*
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val TAG = "ContentActivity"
class ContentActivity : AppCompatActivity() {
    private lateinit var photoViewModel: PhotoViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_content)
progressBar.visibility  = View.VISIBLE

       val  recyclerView :RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

       val BASE_URL = "https://jsonplaceholder.typicode.com/"
         val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val apiService = retrofit.create(PhotoApiService::class.java)

        val viewModelFactory = PhotoViewModelFactory(apiService)


        photoViewModel = ViewModelProvider(this, viewModelFactory).get(PhotoViewModel::class.java)


        photoViewModel.photos.observe(this, { photos ->

            progressBar.visibility = View.GONE
            val photoAdapter = PhotoAdapter(photos)

            recyclerView.adapter = photoAdapter
        })
    }
}