package com.example.pearl.presentation.favorites

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pearl.domain.model.Doctor
import com.example.pearl.domain.model.Product
import com.example.pearl.domain.usecases.doctors.DoctorUseCases
import com.example.pearl.domain.usecases.products.ProductUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavoritesViewModel @Inject constructor(
    private val mDoctorUseCases: DoctorUseCases,
    private val mProductUseCases: ProductUseCases
) : ViewModel() {

    val mFavoriteScreenState by lazy {
        mutableStateOf(FavoriteScreenState())
    }
    init{
        onEvent(FavoriteScreenEvents.ObserveFavoriteDoctorsList)
        onEvent(FavoriteScreenEvents.ObserveFavoriteProductsList)
    }

    private fun getDoctors(
        onSuccess : (List<Doctor>) -> Unit,
        onFailure : (Throwable) -> Unit
    ){
        viewModelScope.launch {
            mDoctorUseCases.getFavoriteDoctors(onSuccess , onFailure)
        }
    }

    private fun getProducts(
        onSuccess : (List<Product>) -> Unit,
        onFailure : (Throwable) -> Unit
    ){
        viewModelScope.launch {
            mProductUseCases.getAllProductUseCase(onSuccess , onFailure)
        }
    }

    private fun addDoctor(
        doctor: Doctor,
        onFailure: (Throwable) -> Unit
    ){
        viewModelScope.launch {
            mDoctorUseCases.addFavoriteDoctor(doctor , onFailure)
        }
    }

    private fun addProduct(
        product : Product,
        onFailure: (Throwable) -> Unit
    ){
        viewModelScope.launch {
            mProductUseCases.addFavoriteProductUseCase(product , onFailure)
        }
    }

    private fun removeDoctor(
        doctor: Doctor,
        onFailure: (Throwable) -> Unit
    ){
        viewModelScope.launch {
            mDoctorUseCases.removeDoctorFromFavorite(doctor , onFailure)
        }
    }

    private fun removeProduct(
        product: Product,
        onFailure: (Throwable) -> Unit
    ){
       viewModelScope.launch {
           mProductUseCases.removeProductFromFavoriteUseCase(product , onFailure)
       }
    }

    fun onEvent(event : FavoriteScreenEvents){
        when (event){
            is FavoriteScreenEvents.UpdateProductList -> {
                mFavoriteScreenState.value = mFavoriteScreenState.value.copy(favoriteProducts = event.products)
            }

            is FavoriteScreenEvents.UpdateDoctorList -> {
                mFavoriteScreenState.value = mFavoriteScreenState.value.copy(favoriteDoctors = event.doctors)
            }

            is FavoriteScreenEvents.UpdateErrorMessage -> {
                mFavoriteScreenState.value = mFavoriteScreenState.value.copy(error = event.message)
            }

            is FavoriteScreenEvents.ShowErrorDialog -> {
                mFavoriteScreenState.value = mFavoriteScreenState.value.copy(isErrorShown = true)
            }

            is FavoriteScreenEvents.HideErrorDialog -> {
                mFavoriteScreenState.value = mFavoriteScreenState.value.copy(isErrorShown = false)
            }

            is FavoriteScreenEvents.ObserveFavoriteDoctorsList -> {
                getDoctors(
                    onSuccess = {
                         onEvent(FavoriteScreenEvents.UpdateDoctorList(it))
                    },
                    onFailure = {
                        onEvent(FavoriteScreenEvents.UpdateErrorMessage(it.message))
                        onEvent(FavoriteScreenEvents.ShowErrorDialog)
                    }
                )
            }

            is FavoriteScreenEvents.ObserveFavoriteProductsList -> {
                getProducts(
                    onSuccess = {
                        onEvent(FavoriteScreenEvents.UpdateProductList(it))
                    },
                    onFailure = {
                        onEvent(FavoriteScreenEvents.UpdateErrorMessage(it.message))
                        onEvent(FavoriteScreenEvents.ShowErrorDialog)
                    }
                )
            }

            is FavoriteScreenEvents.AddDoctorToFavorite -> {
                event.doctor.isFavorite = true
                addDoctor(
                    doctor = event.doctor,
                    onFailure = {
                        onEvent(FavoriteScreenEvents.UpdateErrorMessage(it.message))
                        onEvent(FavoriteScreenEvents.ShowErrorDialog)
                    }
                )
            }

            is FavoriteScreenEvents.AddProductToFavorite -> {
                event.product.isFavorite = true
                addProduct(
                    product = event.product,
                    onFailure = {
                        onEvent(FavoriteScreenEvents.UpdateErrorMessage(it.message))
                        onEvent(FavoriteScreenEvents.ShowErrorDialog)
                    }
                )
            }

            is FavoriteScreenEvents.RemoveDoctorFromFavorite -> {
               event.doctor.isFavorite = false
               removeDoctor(
                   doctor = event.doctor,
                   onFailure = {
                       onEvent(FavoriteScreenEvents.UpdateErrorMessage(it.message))
                       onEvent(FavoriteScreenEvents.ShowErrorDialog)
                   }
               )
            }

            is FavoriteScreenEvents.RemoveProductFromFavorite -> {
               event.product.isFavorite = false
               removeProduct(
                   product = event.product,
                   onFailure = {
                       onEvent(FavoriteScreenEvents.UpdateErrorMessage(it.message))
                       onEvent(FavoriteScreenEvents.ShowErrorDialog)
                   }
               )
            }

            is FavoriteScreenEvents.ProductAction -> {
                if(event.product.isFavorite){
                    onEvent(FavoriteScreenEvents.RemoveProductFromFavorite(event.product))
                }else{
                    onEvent(FavoriteScreenEvents.AddProductToFavorite(event.product))
                }
                onEvent(FavoriteScreenEvents.ObserveFavoriteProductsList)
            }

            is FavoriteScreenEvents.DoctorAction -> {
                if(event.doctor.isFavorite){
                    onEvent(FavoriteScreenEvents.RemoveDoctorFromFavorite(event.doctor))
                }else{
                    onEvent(FavoriteScreenEvents.AddDoctorToFavorite(event.doctor))
                }
                onEvent(FavoriteScreenEvents.ObserveFavoriteDoctorsList)
            }
        }
    }
}