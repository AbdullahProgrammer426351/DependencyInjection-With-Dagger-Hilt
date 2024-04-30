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

    /* === Concepts for Dagger ===
    1. Consumer: Which takes(consumes) generated code(usually objects)
    2. Producer(Component-MB): takes instructions from consumer and generates code
    3. Connector:Links between consumer and producer
    * */
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

        val component = DaggerUserRegistrationComponent.builder().build()// to get methods created with dagger
        val userRegistrationService = component.getUserRegistrationService()
        // similarly for getting email service
        val emailService = component.getEmailService()
        userRegistrationService.registerUser("testuserforprogramming@gmail.com", "1111")
    }
}