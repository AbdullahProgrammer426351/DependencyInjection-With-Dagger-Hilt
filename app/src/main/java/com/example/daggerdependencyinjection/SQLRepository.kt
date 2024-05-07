package com.example.daggerdependencyinjection

import android.util.Log
import com.example.daggerdependencyinjection.MainActivity.Companion.TAG
import javax.inject.Inject
import javax.inject.Singleton


interface UserRepository{
    fun saveUser(email: String, password: String)
}
@Singleton
class SQLRepository @Inject constructor() :UserRepository{
    override fun saveUser(email: String, password: String) {
        Log.d(TAG, "User saved in DB with email '$email' and password '$password'")
    }
}

class FirebaseRepository:UserRepository{
    override fun saveUser(email: String, password: String) {
        Log.d(TAG, "User saved in Firebase with email '$email' and password '$password'")
    }

}