package com.example.daggerdependencyinjection

import android.util.Log
import com.example.daggerdependencyinjection.MainActivity.Companion.TAG
import javax.inject.Inject

class EmailService @Inject constructor() {
    fun send(to:String,from:String,body:String?){
        Log.d(TAG, "Email Sent from $from to $to having body $body")
    }
}