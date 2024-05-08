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

    /* bad approach
    private lateinit var emailService: EmailService
    private lateinit var emailService1: EmailService*/

    // good approach
    @Inject
    private lateinit var emailService: EmailService
    @Inject
    private lateinit var emailService1: EmailService

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
        /* Bad approach
        val component = DaggerUserRegistrationComponent.factory().create(3)
        component.inject(this)

        // through this, we will get same object reference. But when component will be recreated,
        // it will create new object. To avoid this, we can use create object on Application level scope.
        // Every object has a scope that is same as its class where It is created. So Application is
        // not destroyed like activity and fragment class. So, we have to do this in Application class.
        emailService = component.getEmailService()
        emailService1 = component.getEmailService()*/


        // Good approach
        val component = (application as UserApplication).userRegistrationComponent
        component.inject(this)
        userRegistrationService.registerUser("testuserforprogramming@gmail.com", "1111")
    }
}