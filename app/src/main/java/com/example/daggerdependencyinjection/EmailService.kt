package com.example.daggerdependencyinjection

import android.util.Log
import com.example.daggerdependencyinjection.MainActivity.Companion.TAG
import javax.inject.Inject


interface NotificationService {
    fun send(to: String, from: String, body: String?)
}

// for sending notification instead of email, we will implemented it by above interface

class EmailService @Inject constructor(): NotificationService{
    override fun send(to: String, from: String, body: String?) {
        Log.d(TAG, "Email Sent from $from to $to having body $body")
    }
}

// For Message sending
class MessageService:NotificationService{
    override fun send(to: String, from: String, body: String?) {
        Log.d(TAG, "Message Sent")
    }

}