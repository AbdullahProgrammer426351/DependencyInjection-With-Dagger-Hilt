package com.example.daggerdependencyinjection

import java.lang.annotation.Documented
import java.lang.annotation.Retention
import java.lang.annotation.RetentionPolicy
import javax.inject.Qualifier

@Qualifier// used to make our annotation qualifier
@Documented// this will occur in java document
@Retention(RetentionPolicy.RUNTIME)// this decided timeline of your annotation
annotation class MessageQualifier()
