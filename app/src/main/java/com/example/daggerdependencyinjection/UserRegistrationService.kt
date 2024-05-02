package com.example.daggerdependencyinjection

import javax.inject.Inject


 class UserRegistrationService @Inject constructor(private val userRepository: SQLRepository,
                                                   private val notificationService: NotificationService
) {
    fun registerUser(email: String, password: String) {
        notificationService.send(email, "no_reply@gmail.com", "Happy to register you!")
        userRepository.saveUser(email, password)
    }
}
