package com.example.pearl.data.repositories

import com.example.pearl.data.local.dao.ProductDao
import com.example.pearl.domain.model.Product
import com.example.pearl.domain.repositories.ProductsRepository

class ProductsRepositoryImpl(
    val mProductDao: ProductDao
)  : ProductsRepository{
    override suspend fun addProductToFavorite(
        product: Product,
        onFailure: (Throwable) -> Unit
    ) {
       try{
           mProductDao.addProductToFavorite(product)
       }catch (ex : Exception){
           onFailure(ex)
       }
    }

    override suspend fun removeProductFromFavorite(
        product: Product,
        onFailure: (Throwable) -> Unit
    ) {
        try {
            mProductDao.removeProductFromFavorite(product)
        }catch (ex :Exception){
            onFailure(ex)
        }
    }

    override suspend fun getProducts(
        onSuccess : (List<Product>) -> Unit,
        onFailure : (Throwable) -> Unit
    ): List<Product> {
        return try {
            val products = mProductDao.getProducts()
            onSuccess(products)
            products
        }catch (ex : Exception){
            onFailure(ex)
            emptyList()
        }
    }
}