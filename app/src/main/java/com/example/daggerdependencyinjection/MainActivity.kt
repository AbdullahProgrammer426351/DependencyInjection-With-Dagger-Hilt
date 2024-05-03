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


    @Inject
    lateinit var userRegistrationService:UserRegistrationService
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
//        val component = DaggerUserRegistrationComponent.builder() --> If you don't use factory
//            // for defining retry count at runtime. But if we forgot, we will face error. To
//            // prevent that error, we have to use Factory. See userRegistrationComponent class
//            .notificationServiceModule(NotificationServiceModule(3))
//            .build()

        // If we use factory, then we have to do like this
        val component = DaggerUserRegistrationComponent.factory().create(3)
        component.inject(this)
        userRegistrationService.registerUser("testuserforprogramming@gmail.com", "1111")
    }
}