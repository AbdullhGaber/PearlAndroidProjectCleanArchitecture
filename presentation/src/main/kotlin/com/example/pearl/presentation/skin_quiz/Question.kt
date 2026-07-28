package com.example.pearl.presentation.skin_quiz

import com.example.pearl.domain.model.UserGender

data class Question(
    val questionText : String = "",
    val options : List<String> = emptyList(),
    val category: QuestionCategory = QuestionCategory.GENERAL,
    val gender : UserGender = UserGender.MALE
)

private val yesNoList = listOf("Yes" , "No")

val questions = listOf(
    Question(
        questionText = "Are you pregnant or breastfeeding ?",
        options = yesNoList,
        gender = UserGender.FEMALE
    ),

    Question(
        questionText = "Have you had any previous skin treatments, prescriptions, or procedures ?",
        options = yesNoList
    ),

    Question(
        questionText = "How much time are you willing to dedicate to your skincare routine daily ?",
        options = listOf("10 min" , "15 min" , "20 min"),
    ),

    Question(
        questionText = "Are you smoking ?",
        options = yesNoList
    ),

    Question(
        questionText = "How long do you engage in prolonged sun exposure without sunscreen ?",
        options = listOf("Less than 1 hour" , "1-2 hours" , "2-4 hours" , "More than 4 hours" , "I always use sunscreen during sun exposure"),
    ),

    Question(
        questionText = "Do you have any allergies to medications or skincare products ?",
        options = listOf("Essential oils" , "Fragrance and Perfume" , "Preservatives" , "Sunscreen" , "Cosmetics", "None" , "Other"),
    ),

    Question(
        questionText = "Do you have a history of autoimmune diseases or medical conditions that could impact your skin ?",
        options = listOf("Pemphigus" , "Epidermolysis Bullosa" , "Atopic Dermatitis" , "Rosacea" , "Vitiligo" , "None" , "Other"),
    ),

    Question(
        questionText = "Have you noticed any changes in your skin?",
        options = listOf("New moles" , "Rashes" , "Lesions" , "Change in texture" , "Redness" , "Roughness", "None" , "Other"),
    ),

    Question(),

    Question(
        questionText = "How much water do you drink daily ?",
        options = listOf("Less than 8 cups" , "8 cups exactly" , "More than 8 cups"),
        category = QuestionCategory.NUTRITION
    ),

    Question(
        questionText = "Do you have any food allergies or sensitivities ?",
        options = listOf("Tree nuts" , "Eggs" , "Milk" , "Wheat and triticale" , "Fish" , "None" , "Other"),
        category = QuestionCategory.NUTRITION
    ),


    Question(
        questionText = "Do you have any food allergies or sensitivities ?",
        options = yesNoList,
        category = QuestionCategory.NUTRITION
    ),

    Question(
        questionText = "Do you have any dietary preferences or habits?",
        options = listOf("Salty snacks" , "Processed foods" , "Sugar" , "Fatty foods"),
        category = QuestionCategory.NUTRITION
    ),
    Question(),
    Question(),
    Question(),
    Question(),
    Question(),
)

