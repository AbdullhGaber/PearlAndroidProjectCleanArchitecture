package com.example.pearl.data.local.type_converter

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.example.pearl.presentation.products.ProductType
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

@ProvidedTypeConverter
class PearlTypeConverter {
    @TypeConverter
    fun productTypeToString(productType: ProductType) : String = productType.name

    @TypeConverter
    fun stringToProductType(productType : String) : ProductType{
        return when(productType){
            ProductType.CLEANSER -> {
                ProductType.createCleanser()
            }

            ProductType.SERUM -> {
                ProductType.createSerum()
            }

            ProductType.MOISTURIZER -> {
                ProductType.createMoisturizer()
            }

            ProductType.EYE_CARE -> {
                ProductType.createEyeCare()
            }

            ProductType.TONER -> {
                ProductType.createToner()
            }

            ProductType.SHEET_MASK -> {
                ProductType.createSheetMask()
            }

            ProductType.LIP_CARE -> {
                ProductType.createEyeCare()
            }

            ProductType.SUN_SCREEN -> {
                ProductType.createSunScreen()
            }

            else -> ProductType.createCleanser()
        }
    }

    @TypeConverter
    fun fromString(ingredients: String): List<String> {
        val listType = object : TypeToken<List<String>>() {}.type
        return Gson().fromJson(ingredients, listType)
    }

    @TypeConverter
    fun fromList(ingredients: List<String>): String {
        return Gson().toJson(ingredients)
    }
}