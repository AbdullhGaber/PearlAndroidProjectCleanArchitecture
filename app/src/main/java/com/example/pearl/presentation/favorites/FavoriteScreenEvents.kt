package com.example.pearl.presentation.favorites

import com.example.pearl.domain.model.Doctor
import com.example.pearl.domain.model.Product

sealed class FavoriteScreenEvents {
    object ObserveFavoriteDoctorsList : FavoriteScreenEvents()
    object ObserveFavoriteProductsList : FavoriteScreenEvents()
    data class AddDoctorToFavorite(val doctor : Doctor) : FavoriteScreenEvents()
    data class AddProductToFavorite(val product : Product) : FavoriteScreenEvents()
    data class RemoveDoctorFromFavorite(val doctor : Doctor) : FavoriteScreenEvents()
    data class RemoveProductFromFavorite(val product: Product) : FavoriteScreenEvents()
    data class UpdateProductList(val products : List<Product>) : FavoriteScreenEvents()
    data class UpdateDoctorList(val doctors : List<Doctor>) : FavoriteScreenEvents()
    data class UpdateErrorMessage(val message : String?) : FavoriteScreenEvents()

    data class ProductAction(val product: Product) : FavoriteScreenEvents()
    data class DoctorAction(val doctor: Doctor) : FavoriteScreenEvents()
    object ShowErrorDialog : FavoriteScreenEvents()
    object HideErrorDialog : FavoriteScreenEvents()
}