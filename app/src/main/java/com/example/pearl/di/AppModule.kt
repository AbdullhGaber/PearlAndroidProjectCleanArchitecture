package com.example.pearl.di

import com.example.pearl.data.remote.TwilioApiService
import android.app.Application
import androidx.room.Room
import com.example.pearl.data.local.PearlDatabase
import com.example.pearl.data.local.dao.DoctorDao
import com.example.pearl.data.local.dao.ProductDao
import com.example.pearl.data.local.type_converter.PearlTypeConverter
import com.example.pearl.data.manager.LocalManagerImpl
import com.example.pearl.data.repositories.AuthRepositoryImpl
import com.example.pearl.data.repositories.DoctorRepositoryImpl
import com.example.pearl.data.repositories.ProductsRepositoryImpl
import com.example.pearl.data.repositories.QuizRepositoryImpl
import com.example.pearl.data.repositories.RoutineRepositoryImpl
import com.example.pearl.domain.manger.LocalManger
import com.example.pearl.domain.repositories.AuthRepository
import com.example.pearl.domain.repositories.DoctorRepository
import com.example.pearl.domain.repositories.ProductsRepository
import com.example.pearl.domain.repositories.QuizRepository
import com.example.pearl.domain.repositories.RoutineRepository
import com.example.pearl.domain.usecases.app_entry.AppEntryUseCases
import com.example.pearl.domain.usecases.app_entry.ReadAppEntryUseCase
import com.example.pearl.domain.usecases.app_entry.SaveAppEntryUseCase
import com.example.pearl.domain.usecases.authentication.AuthUseCases
import com.example.pearl.domain.usecases.authentication.DeleteAccountUseCase
import com.example.pearl.domain.usecases.authentication.GetUserUseCase
import com.example.pearl.domain.usecases.authentication.Login
import com.example.pearl.domain.usecases.authentication.ResetPasswordUseCase
import com.example.pearl.domain.usecases.authentication.SendOTPMessage
import com.example.pearl.domain.usecases.authentication.SignOut
import com.example.pearl.domain.usecases.authentication.SignUp
import com.example.pearl.domain.usecases.authentication.UpdatePasswordUseCase
import com.example.pearl.domain.usecases.authentication.UpdateUserProfileUseCase
import com.example.pearl.domain.usecases.authentication.ValidateAddressUseCase
import com.example.pearl.domain.usecases.authentication.ValidateAgeUseCase
import com.example.pearl.domain.usecases.authentication.ValidateEmailUseCase
import com.example.pearl.domain.usecases.authentication.ValidateNameUseCase
import com.example.pearl.domain.usecases.authentication.ValidatePasswordUseCase
import com.example.pearl.domain.usecases.doctors.AddFavoriteDoctorUseCase
import com.example.pearl.domain.usecases.doctors.DoctorUseCases
import com.example.pearl.domain.usecases.doctors.GetDoctorDetailsUseCase
import com.example.pearl.domain.usecases.doctors.GetFavoriteDoctorsUseCase
import com.example.pearl.domain.usecases.doctors.RemoveDoctorFromFavoriteUseCase
import com.example.pearl.domain.usecases.products.AddFavoriteProductUseCase
import com.example.pearl.domain.usecases.products.GetFavoriteProductsUseCase
import com.example.pearl.domain.usecases.products.ProductUseCases
import com.example.pearl.domain.usecases.products.RemoveProductFromFavoriteUseCase
import com.example.pearl.domain.usecases.quiz.QuizUseCases
import com.example.pearl.domain.usecases.quiz.SaveAnswersUseCase
import com.example.pearl.domain.usecases.routine.AddRoutineUseCase
import com.example.pearl.domain.usecases.routine.GetRoutinesUseCase
import com.example.pearl.domain.usecases.routine.RemoveRoutineUseCase
import com.example.pearl.domain.usecases.routine.RoutineUseCases
import com.example.pearl.util.Constants.TWILIO_ACCOUNT_SID
import com.example.pearl.util.Constants.TWILIO_AUTH_TOKEN
import com.example.pearl.util.Constants.TWILIO_BASE_URL
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Credentials
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
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
    fun provideTwilioApiService() : TwilioApiService {
        val credentials = Credentials.basic(TWILIO_ACCOUNT_SID,TWILIO_AUTH_TOKEN)

        val client = OkHttpClient.Builder()
            .addInterceptor { chain ->
                val request = chain.request().newBuilder()
                    .addHeader("Authorization", credentials)
                    .build()
                chain.proceed(request)
            }.build()

        val retrofit = Retrofit.Builder()
            .baseUrl(TWILIO_BASE_URL) // Base URL of the API
            .client(client)
            .addConverterFactory(GsonConverterFactory.create()) // Converter library used to convert JSON to Kotlin objects
            .build()

        return retrofit.create(TwilioApiService::class.java)
    }
    @Provides
    @Singleton
    fun provideAuthRepository(
        firebaseAuth: FirebaseAuth,
        database: FirebaseDatabase,
        twilioApiService: TwilioApiService
    ) : AuthRepository = AuthRepositoryImpl(firebaseAuth, database, twilioApiService)

    @Provides
    @Singleton
    fun provideAuthUseCases(
        authRepository: AuthRepository
    ) = AuthUseCases(
        login = Login(authRepository),
        signUp = SignUp(authRepository),
        signOut = SignOut(authRepository),
        resetPasswordUseCase = ResetPasswordUseCase(authRepository),
        deleteAccount = DeleteAccountUseCase(authRepository),
        updatePassword = UpdatePasswordUseCase(authRepository),
        sendOTPMessage = SendOTPMessage(authRepository),
        updateProfile = UpdateUserProfileUseCase(authRepository),
        getUser = GetUserUseCase(authRepository),
        validateEmailUseCase = ValidateEmailUseCase(),
        validatePasswordUseCase = ValidatePasswordUseCase(),
        validateAgeUseCase = ValidateAgeUseCase(),
        validateAddressUseCase = ValidateAddressUseCase(),
        validateNameUseCase = ValidateNameUseCase()
    )


    @Provides
    @Singleton
    fun provideQuizRepository(
        firebaseAuth: FirebaseAuth,
        database: FirebaseDatabase,
    ) : QuizRepository = QuizRepositoryImpl(database, firebaseAuth)

    @Provides
    @Singleton
    fun provideQuizUseCases(quizRepository: QuizRepository) : QuizUseCases =
        QuizUseCases(saveAnswersUseCase = SaveAnswersUseCase(quizRepository))

    @Provides
    @Singleton
    fun provideLocalManger(context : Application) : LocalManger =
        LocalManagerImpl(context)
    @Provides
    @Singleton
    fun provideAppEntryUseCases(localManger: LocalManger) : AppEntryUseCases =
        AppEntryUseCases(
            readAppEntry = ReadAppEntryUseCase(localManger),
            saveAppEntry = SaveAppEntryUseCase(localManger)
        )

    @Provides
    @Singleton
    fun provideRoutineRepository(
        firebaseAuth: FirebaseAuth,
        database: FirebaseDatabase
    ) : RoutineRepository = RoutineRepositoryImpl(database , firebaseAuth)

    @Provides
    @Singleton
    fun provideRoutineUseCases(
        routineRepository: RoutineRepository
    ) : RoutineUseCases {
        return RoutineUseCases(
            addRoutineUseCase = AddRoutineUseCase(routineRepository),
            getRoutinesUseCase = GetRoutinesUseCase(routineRepository),
            removeRoutineUseCase = RemoveRoutineUseCase(routineRepository)
        )
    }

    @Provides
    @Singleton
    fun providePearlDatabase(
        context : Application
    ) : PearlDatabase {
        return Room.databaseBuilder(
            context.applicationContext,
            PearlDatabase::class.java,
            "pearl_db"
        ).addTypeConverter(PearlTypeConverter())
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun provideDoctorDao(pearlDatabase: PearlDatabase) = pearlDatabase.doctorDao
    @Provides
    @Singleton
    fun provideProductDao(pearlDatabase: PearlDatabase) = pearlDatabase.productDao

    @Provides
    @Singleton
    fun provideDoctorRepository(
        doctorDao: DoctorDao,
        database: FirebaseDatabase
    ) : DoctorRepository = DoctorRepositoryImpl(doctorDao,database)

    @Provides
    @Singleton
    fun provideProductRepository(
        productDao: ProductDao
    ) : ProductsRepository = ProductsRepositoryImpl(productDao)

    @Provides
    @Singleton
    fun provideDoctorUseCases(
        doctorRepository: DoctorRepository
    ) : DoctorUseCases{
        return DoctorUseCases(
            getFavoriteDoctors = GetFavoriteDoctorsUseCase(doctorRepository),
            addFavoriteDoctor = AddFavoriteDoctorUseCase(doctorRepository),
            removeDoctorFromFavorite = RemoveDoctorFromFavoriteUseCase(doctorRepository),
            getDoctorDetails = GetDoctorDetailsUseCase(doctorRepository)
        )
    }

    @Provides
    @Singleton
    fun provideProductUseCases(
        productsRepository: ProductsRepository
    ) : ProductUseCases{
        return ProductUseCases(
            getAllProductUseCase = GetFavoriteProductsUseCase(productsRepository),
            addFavoriteProductUseCase = AddFavoriteProductUseCase(productsRepository),
            removeProductFromFavoriteUseCase = RemoveProductFromFavoriteUseCase(productsRepository)
        )
    }
}