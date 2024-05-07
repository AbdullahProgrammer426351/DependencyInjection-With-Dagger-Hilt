package com.example.daggerdependencyinjection

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NotificationServiceModule {
    @Singleton
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