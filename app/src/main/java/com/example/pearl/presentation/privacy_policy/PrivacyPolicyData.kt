package com.example.pearl.presentation.privacy_policy

data class PrivacyPolicyData(
    val title : String,
    val body : String
)

val privacyPolicyData = listOf(
    PrivacyPolicyData(
        title = "Information We Collect",
        body = "We collect personal information, including your name, email, pictures, and survey responses related to your skin. This information is crucial for tailoring personalized skincare recommendations and connecting you with dermatologists."
    ),

    PrivacyPolicyData(
        title = "Survey Responses",
        body = "The survey responses you provide about your skin condition are used to understand your needs better and customize our services. These responses are treated with the utmost confidentiality."
    ),

    PrivacyPolicyData(
        title = "Data Security",
        body = "We employ industry-standard security measures to protect your personal information. This includes encryption, access controls, and regular security audits to safeguard your data from unauthorized access."
    ),

    PrivacyPolicyData(
        title = "Privacy Assurance",
        body = "Your pictures are confidential and strictly for your eyes only. No one, including dermatologists, will access your pictures without your explicit permission. Your privacy is our top priority, empowering you on your skincare journey."
    ),

    PrivacyPolicyData(
        title = "User Responsibility",
        body = "You hold full responsibility for product selection and usage. Before incorporating any new product, it is imperative to conduct a patch test to ensure compatibility and avoid potential adverse reactions. Your commitment to patch testing is crucial for a safe and personalized skincare experience."
    ),

    PrivacyPolicyData(
        title = "Communication with Dermatologists",
        body = "Our app facilitates communication with dermatologists through video calls and chat features. Dermatologists may have access to your survey answers and results to provide personalized recommendations."
    ),

    PrivacyPolicyData(
        title = "Payment Information",
        body = "For online appointments with dermatologists, we use secure payment methods such as credit cards. Your payment information is encrypted and processed securely to ensure confidentiality."
    ),

    PrivacyPolicyData(
        title = "User Control",
        body = "You have control over your personal information. You can access, update, or delete your data within the app. If you have questions or need assistance, our support team is here to help."
    ),

    PrivacyPolicyData(
        title = "Children's Privacy",
        body = "Our services are not directed at individuals under the age of 12. If you are a parent or guardian and believe your child has provided personal information, please contact us."
    ),


)