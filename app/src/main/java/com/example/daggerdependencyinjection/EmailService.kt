package com.example.daggerdependencyinjection

import android.util.Log
import com.example.daggerdependencyinjection.MainActivity.Companion.TAG
import javax.inject.Inject


interface NotificationService {
    fun send(to: String, from: String, body: String?)
}


class EmailService @Inject constructor(): NotificationService{
    override fun send(to: String, from: String, body: String?) {
        Log.d(TAG, "Email Sent from $from to $to having body $body")
    }
}
// Suppose we have to get some code from dagger at runtime such as an object using context like room db
// we will do that like following
class MessageService(private val retryCount:Int):NotificationService{
    override fun send(to: String, from: String, body: String?) {
        Log.d(TAG, "Message Sent - Retry Count -- $retryCount")
    }

}