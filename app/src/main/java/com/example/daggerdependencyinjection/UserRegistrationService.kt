package com.example.daggerdependencyinjection

import javax.inject.Inject

/*
class UserRegistrationService @Inject constructor(private val userRepository: UserRepository,
                              private val emailService: EmailService
) {
If we have to send message instead of email, we will replace above old constructor with below
new constructor
*/
 class UserRegistrationService @Inject constructor(private val userRepository: SQLRepository,
                                                   private val notificationService: NotificationService
) {

    fun registerUser(email: String, password: String) {
        // Now it will only run send() method regardless of what is been sent. Whether
        // it is email, notification or some message
        notificationService.send(email, "no_reply@gmail.com", "Happy to register you!")
        // Similarly, we have also do some changes in UserRepository -> SQLRepository class
        // so it will also do same with saveUser method
        userRepository.saveUser(email, password)
    }
}
