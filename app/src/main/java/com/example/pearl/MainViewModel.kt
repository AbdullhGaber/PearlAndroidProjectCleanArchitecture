package com.example.pearl

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pearl.domain.usecases.app_entry.AppEntryUseCases
import com.example.pearl.presentation.nav_graph.Route
import com.example.pearl.util.Constants.USER_REFERENCE
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject
@HiltViewModel
class MainViewModel @Inject constructor(
    appEntryUseCases: AppEntryUseCases,
    mFirebaseAuth : FirebaseAuth,
    mDatabase : FirebaseDatabase
) : ViewModel() {
    var startDestination by mutableStateOf(Route.AppStartNavigation.route)
        private set

    init {
        appEntryUseCases.readAppEntry().onEach { isEnteredAppBefore ->
          if(isEnteredAppBefore){
                if(mFirebaseAuth.currentUser == null) {
                    startDestination = Route.AuthNavigation.route
                    return@onEach
                }else{
                    mDatabase.getReference(USER_REFERENCE).child(mFirebaseAuth.uid!!).child("questionAnswers").addListenerForSingleValueEvent(
                        object : ValueEventListener {
                            override fun onDataChange(dataSnapshot: DataSnapshot) {
                                startDestination = if(dataSnapshot.exists()){
                                    Route.PearlNavigation.route
                                }else{
                                    Route.QuizScreen.route
                                }
                            }

                            override fun onCancelled(p0: DatabaseError) {
                                TODO("Not yet implemented")
                            }
                        }
                    )
                }
            }else{
                Route.AppStartNavigation.route
            }
        }.launchIn(viewModelScope)
    }
}