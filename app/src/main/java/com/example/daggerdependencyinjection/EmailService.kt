package com.example.daggerdependencyinjection

import android.util.Log
import com.example.daggerdependencyinjection.MainActivity.Companion.TAG
import javax.inject.Inject
import javax.inject.Singleton


interface NotificationService {
    fun send(to: String, from: String, body: String?)
}

/*
    ---------------- Singleton ----------
    Sometimes objects used in apps are very expensive with respect to memory usage. So, it is
    better to make one object only and use it in whole app rather than making new objects every time.
    To do this, dagger uses @Singleton annotation.
    In this example, we have to create EmailService object single time and provide it every time
    when we need it using @Inject method or something else.
    We will do it like this:
*/
@Singleton// using this annotation, object will created at once.
class EmailService @Inject constructor(): NotificationService{
    override fun send(to: String, from: String, body: String?) {
        Log.d(TAG, "Email Sent from $from to $to having body $body")
    }
}
class MessageService(private val retryCount:Int):NotificationService{
    override fun send(to: String, from: String, body: String?) {
        Log.d(TAG, "Message Sent - Retry Count -- $retryCount")
    }

}