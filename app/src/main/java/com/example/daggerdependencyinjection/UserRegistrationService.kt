package com.example.daggerdependencyinjection

import javax.inject.Inject

class UserRegistrationService @Inject constructor(private val userRepository: UserRepository,
                              private val emailService: EmailService
) {// this is called constructor injection.

    fun registerUser(email: String, password: String) {
        userRepository.saveUser(email, password)
        emailService.send(email, "no_reply@gmail.com", "Happy to register you!")
    }
}
/*

This is code without using dependency injection:
dependency injection means injecting objects instead of creating in class on which class depends on
class UserRegistrationService {
    private val userRepository = UserRepository()
    private val emailService = EmailService()

    fun registerUser(email: String, password: String) {
        userRepository.saveUser(email, password)
        emailService.send(email, "no_reply@gmail.com", "Happy to register you!")
    }


}
    Problems ---- (for these details, see first video)
    Unit testing:
    To test it, we need to first test and make ready UserRepository and EmailService classes
    Single Responsibility:
    Instead of creating objects of other classes also (which is not core purpose of this class), it should
    work on its core purpose.
    Lifetime of these objects:
    Lifetime of objects userRepository and emailService is linked with class lifetime. These objects should be
    independent of this class lifetime. They should have their own lifecycles.
    Extensive:
    Future changes may create problems such as instead of sending email, If we want to send text message
    to user in future, we will have to create their object and deal according to their functionality
     which is not good.

     Now we have solved this issue ass above given uncommented code.

     */