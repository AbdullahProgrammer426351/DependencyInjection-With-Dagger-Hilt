package com.example.daggerdependencyinjection

import javax.inject.Inject
import javax.inject.Named


//class UserRegistrationService @Inject constructor(
//    private val userRepository: SQLRepository,
//    @Named("message")private val notificationService: NotificationService
//) {
    // to tell dagger that we need message type implementation, we used @Named annotation.
    // But this can cause typo issues(spelling mistake).To handle this, we will make our
    // own custom annotation class names 'MessageQualifier'
class UserRegistrationService @Inject constructor(
    private val userRepository: SQLRepository,
    @MessageQualifier private val notificationService: NotificationService
) {
    fun registerUser(email: String, password: String) {
        notificationService.send(email, "no_reply@gmail.com", "Happy to register you!")
        userRepository.saveUser(email, password)
    }
}
