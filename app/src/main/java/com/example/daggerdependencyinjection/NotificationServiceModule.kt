package com.example.daggerdependencyinjection

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Named

@Module
@InstallIn(SingletonComponent::class)
//class NotificationServiceModule(private val retryCount:Int) {--> If you don't use factory
class NotificationServiceModule {
    @MessageQualifier
    @Provides
//    fun getMessageService():NotificationService{
    fun getMessageService(retryCount: Int):NotificationService{
        return MessageService(retryCount)
    }
    @Provides
    fun getEmailService(emailService: EmailService):NotificationService{
        return emailService
    }
}