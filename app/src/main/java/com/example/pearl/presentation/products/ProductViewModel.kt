package com.example.pearl.presentation.products

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import arrow.core.const
import com.example.pearl.domain.model.Product
import com.example.pearl.domain.repositories.ProductsRepository
import com.example.pearl.domain.usecases.doctors.AddFavoriteDoctorUseCase
import com.example.pearl.domain.usecases.doctors.DoctorUseCases
import com.example.pearl.domain.usecases.products.AddFavoriteProductUseCase
import com.example.pearl.domain.usecases.products.ProductUseCases
import com.example.pearl.presentation.favorites.FavoriteScreenEvents
import com.example.pearl.presentation.favorites.FavoritesViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ProductViewModel @Inject constructor(
    private val mProductUseCase: ProductUseCases,
    private val mDoctorUseCase: DoctorUseCases
) : ViewModel() {
    private val mFavoriteViewModel = FavoritesViewModel(mDoctorUseCase,mProductUseCase)
    val productScreenState = mutableStateOf(ProductScreenState())
    fun onEvent(event : ProductEvents){
        when(event){
            is ProductEvents.AddRemoveFavoriteProduct -> {
                addRemoveProduct(event.product)
            }

            is ProductEvents.ObserveOnProductList -> {
                observeProductList(event.product)
            }
        }
    }
    private fun addRemoveProduct(product : Product){
        mFavoriteViewModel.onEvent(FavoriteScreenEvents.ProductAction(product))
    }

    private fun observeProductList(productList : List<Product>){
        productScreenState.value = productScreenState.value.copy(products = productList)
    }

}