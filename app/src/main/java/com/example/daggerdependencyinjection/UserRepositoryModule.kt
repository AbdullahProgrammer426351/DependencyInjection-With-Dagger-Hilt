package com.example.daggerdependencyinjection

import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class UserRepositoryModule {
    /* Before this tutorial, compile time error was occurring because dagger don't know which module
    is to be implemented because there are two classes SQLRepository and FirebaseRepository from which
     dagger don't know which to implement. For handling this, we made this file for providing
     repository class which we want. Same will done for NotificationService type.


     @Module ---- it will tell dagger that this is a module
     @Provides --- it will mean that this method will return an object to dagger

     */

    // For firebase repository
    /*@Provides
    fun getFirebaseRepository():UserRepository{
        return FirebaseRepository()
    }*/


    // if we want to get sql repository then
    /*@Provides
    fun getSQLRepository(sqlRepository: SQLRepository):SQLRepository{
        // SQLRepository uses @inject annotation in its constructor. Therefor, object can
//        be created by dagger so that we have passed this in constructor.
        return sqlRepository
    }*/
    // But it simple form can be done by creating abstract method(for which we have also to make
    // this class abstract  with @Binds because dagger can create SQLRepository
    // object himself due to @inject annotation
    @Binds
    abstract fun bindSQLRepository(sqlRepository: SQLRepository):UserRepository


    // d/w @Provided and @Binds is for @Provides we have to create object manually
    // and for @Binds dagger will return because it can return
}