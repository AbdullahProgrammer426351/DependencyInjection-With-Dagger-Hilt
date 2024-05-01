package com.example.daggerdependencyinjection

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.daggerdependencyinjection.databinding.ActivityMainBinding
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding


    @Inject// this annotation tells dagger where to give/pass/inject the code
    private lateinit var userRegistrationService:UserRegistrationService
    companion object{
        const val TAG = "APP_TAG"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        binding = ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
// we will use filed injection in this part instead of constructor injection.
        // some related detail is mentioned  @UserRegistrationComponent.kt
        val component = DaggerUserRegistrationComponent.builder().build()// to get methods created with dagger
        component.inject(this)
        userRegistrationService.registerUser("testuserforprogramming@gmail.com", "1111")
    }
}