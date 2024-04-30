package com.example.daggerdependencyinjection

import android.util.Log
import com.example.daggerdependencyinjection.MainActivity.Companion.TAG

class UserRepository {
    fun saveUser(email:String, password:String){
        Log.d(TAG, "User saved in DB with email '$email' and password '$password'")
    }
}