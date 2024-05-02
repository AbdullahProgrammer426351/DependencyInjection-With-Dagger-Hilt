package com.example.daggerdependencyinjection

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class NotificationServiceModule {
    // its logic detail is in UserRepositoryModule
    @Provides
    fun getMessageService():NotificationService{
        return MessageService()
    }
}