package com.example.pearl.data.repositories


import com.example.pearl.domain.model.Routine
import com.example.pearl.domain.repositories.RoutineRepository
import com.example.pearl.util.Constants.USER_REFERENCE
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener


class RoutineRepositoryImpl(
    val mDatabase : FirebaseDatabase,
    val mFirebaseAuth: FirebaseAuth
) : RoutineRepository {

    private fun getRoutineList(
        onComplete: (List<Routine>) -> Unit,
        onFailure: (Exception) -> Unit
    ) {
        val userRef = mDatabase.getReference(USER_REFERENCE).child(mFirebaseAuth.uid!!)
        val routinesRef = userRef.child("routines")
        val routines = mutableListOf<Routine>()

        routinesRef.addValueEventListener(
            object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    if (snapshot.exists()) {
                        snapshot.children.forEach {
                            it.getValue(Routine::class.java)?.let { routine ->
                                routines.add(routine)
                            }
                        }
                        onComplete(routines)
                    } else {
                        onComplete(emptyList())
                    }
                }

                override fun onCancelled(error: DatabaseError) {
                    onFailure(error.toException())
                }
            }
        )
    }

    override fun addProductToRoutine(
        routine: Routine,
        onSuccess : () -> Unit,
        onFailure : (Throwable) -> Unit
    ) {

        val userRef = mDatabase.getReference(USER_REFERENCE).child(mFirebaseAuth.uid!!)

        val routinesRef = userRef.child("routines")

        routinesRef.addListenerForSingleValueEvent(
            object : ValueEventListener{
                override fun onDataChange(snapshot: DataSnapshot) {
                    if(snapshot.exists()){
                       val routines = mutableListOf<Routine>()

                       val routinesSnapshot = snapshot.children

                        routinesSnapshot.forEach {
                            routines.add(it.getValue(Routine::class.java)!!)
                        }

                        routines.add(routine)

                        routinesRef.setValue(routines)
                    }else{
                        routinesRef.setValue(listOf(routine))
                    }

                    onSuccess()
                }

                override fun onCancelled(error: DatabaseError) {
                    onFailure(error.toException())
                }
            }
        )
    }

    override suspend fun getRoutines(
        onSuccess: (List<Routine>) -> Unit,
        onFailure: (Throwable) -> Unit
    ) {
        getRoutineList(
            onComplete = { routines ->
                onSuccess(routines)
            },
            onFailure = { exception ->
                onFailure(exception)
            }
        )
    }

    override fun removeProductFromRoutine(
        routineId : String,
        onSuccess: () -> Unit,
        onFailure: (Throwable) -> Unit
    ) {
        val userRef = mDatabase.getReference(USER_REFERENCE).child(mFirebaseAuth.uid!!)

        val routinesRef = userRef.child("routines")

        routinesRef.addListenerForSingleValueEvent(
            object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                   if(snapshot.exists()){
                       val routines = snapshot.children.mapNotNull { it.getValue(Routine::class.java) }.toMutableList()

                       val routineToRemove = routines.find { it.id == routineId }

                       if(routineToRemove != null){
                           routines.remove(routineToRemove)
                           routinesRef.setValue(routines)
                               .addOnSuccessListener{onSuccess()}
                               .addOnFailureListener{
                                   onFailure(it)
                               }
                       }else{
                           onFailure(Exception("Routine not found"))
                       }
                   }else{
                       onFailure(Exception("No routines found"))
                   }
                }

                override fun onCancelled(error: DatabaseError) {
                    onFailure(error.toException())
                }
            }
        )
    }
}