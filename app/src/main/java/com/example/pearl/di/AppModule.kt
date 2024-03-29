package com.example.pearl.di

import android.app.Application
import com.example.pearl.data.repositories.AuthRepositoryImpl
import com.example.pearl.domain.repositories.AuthRepository
import com.example.pearl.domain.usecases.authentication.AuthUseCases
import com.example.pearl.domain.usecases.authentication.Login
import com.example.pearl.domain.usecases.authentication.SignOut
import com.example.pearl.domain.usecases.authentication.SignUp
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.ktx.Firebase
import com.google.firebase.ktx.initialize
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideFirebaseApp(context : Application) = FirebaseApp.initializeApp(context)

    @Provides
    @Singleton
    fun provideFirebaseAuth() = FirebaseAuth.getInstance()

    @Provides
    @Singleton
    fun provideFirebaseDatabase() = FirebaseDatabase.getInstance()

    @Provides
    @Singleton
    fun provideAuthRepository(
        firebaseAuth: FirebaseAuth,
        database: FirebaseDatabase
    ) : AuthRepository = AuthRepositoryImpl(firebaseAuth , database)

    @Provides
    @Singleton
    fun provideAuthUseCases(
        authRepository: AuthRepository
    ) = AuthUseCases(
        login = Login(authRepository),
        signUp = SignUp(authRepository),
        signOut = SignOut(authRepository)
    )
}