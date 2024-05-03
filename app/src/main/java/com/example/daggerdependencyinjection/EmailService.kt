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

class MessageService:NotificationService{
    override fun send(to: String, from: String, body: String?) {
        Log.d(TAG, "Message Sent")
    }

}