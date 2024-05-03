package com.example.daggerdependencyinjection

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Named

@Module
@InstallIn(SingletonComponent::class)
class NotificationServiceModule {
//    @Named("message") --> due to typo mistake chances
    @MessageQualifier
    @Provides
    fun getMessageService():NotificationService{
        return MessageService()
    }

    // What If we need both MessageService and EmailService? Let's see how can we do.
//    @Named("email") --> due to typo mistake chances
    @Provides
    fun getEmailService(emailService: EmailService):NotificationService{
        // If we run app, we will see duplicate binding error because their are multiple functions
        // from which dagger don't know which to implement
        // To handle this,we use qualifiers @Named("...")
        // next time we will have to tell dagger which object is required to us
        return emailService
    }
}