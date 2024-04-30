package com.example.daggerdependencyinjection

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.daggerdependencyinjection.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    companion object{
        const val TAG = "APP_TAG"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        /* Without injection
        val userRegistrationService = UserRegistrationService()
        userRegistrationService.registerUser("testuserforprogramming@gmail.com", "1111")*/

        // with injection (called manual dependency injection because we are handling it manually)
        // manually doing this is a problem for big projects. To solve this, we use dagger.
        val userRepository = UserRepository()
        val emailService = EmailService()


        val userRegistrationService = UserRegistrationService(userRepository, emailService)
        userRegistrationService.registerUser("testuserforprogramming@gmail.com", "1111")
    }

}