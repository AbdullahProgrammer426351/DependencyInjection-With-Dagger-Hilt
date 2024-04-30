package com.example.daggerdependencyinjection

import dagger.Component

@Component
interface UserRegistrationComponent {
    fun getUserRegistrationService():UserRegistrationService

    // similarly, for getting email service
    fun getEmailService():EmailService
}