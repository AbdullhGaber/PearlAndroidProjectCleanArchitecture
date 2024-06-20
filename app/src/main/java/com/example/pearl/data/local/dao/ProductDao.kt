package com.example.pearl.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.pearl.domain.model.Product

@Dao
interface ProductDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addProductToFavorite(product: Product)

    @Delete
    suspend fun removeProductFromFavorite(product: Product)

    @Query("SELECT * FROM product")
    suspend fun getProducts() : List<Product>
}