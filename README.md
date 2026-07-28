# ✨ Pearl — Skincare & Dermatology Companion

[![Android](https://img.shields.io/badge/Platform-Android-3DDC84?style=for-the-badge&logo=android&logoColor=white)](https://developer.android.com/)
[![Kotlin](https://img.shields.io/badge/Language-Kotlin_2.2.10-7F52FF?style=for-the-badge&logo=kotlin&logoColor=white)](https://kotlinlang.org/)
[![Jetpack Compose](https://img.shields.io/badge/UI-Jetpack_Compose-4285F4?style=for-the-badge&logo=jetpackcompose&logoColor=white)](https://developer.android.com/jetpack/compose)
[![Clean Architecture](https://img.shields.io/badge/Architecture-Clean_Architecture_%2B_MVVM-FF6F00?style=for-the-badge)](https://developer.android.com/topic/architecture)
[![Hilt](https://img.shields.io/badge/DI-Hilt_2.60.1-000000?style=for-the-badge&logo=google&logoColor=white)](https://dagger.dev/hilt/)
[![Min SDK](https://img.shields.io/badge/Min_SDK-26_(Android_8.0)-blue?style=for-the-badge)](https://developer.android.com/about/versions/oreo)
[![Target SDK](https://img.shields.io/badge/Target_SDK-37-0052CC?style=for-the-badge)](https://developer.android.com/about/versions)

---

## 📌 Overview

**Pearl** is an Android application designed to revolutionize skincare management and dermatology consultations. Pearl provides personalized skin diagnostics, tailored morning and evening routines, smart product recommendation engines, ingredient safety checks, and an appointment booking ecosystem connecting users with top dermatologists.

Built using **Jetpack Compose**, **Clean Architecture**, and **MVVM**, Pearl adheres to Android best practices, leveraging modern asynchronous reactive streams and dependency injection.

---

## 🚀 Key Features & Required Functionality

### 🔐 1. Authentication & Security
- **Multi-Factor Auth**: Sign in and sign up backed by **Firebase Authentication**.
- **SMS OTP Verification**: Automated SMS verification via **Twilio API** combined with **Google Play SMS Retrieval API** for zero-touch OTP autofill.
- **Phone Input Support**: Country code selection powered by `xMaterialccp`.
- **Password Recovery & Security**: Change password, reset password via email or phone, and account deletion flows.

### 🧪 2. Skin Diagnostic Quiz & Personalization
- Interactive questionnaire evaluating user skin health, skin type (**OILY**, **DRY**, **NORMAL**), main concerns (Acne, Sensitivity, Aging, Pigmentation), and nutritional habits.
- Real-time skin score calculation with answers saved to **Firebase Realtime Database**.

### 🧴 3. Customized Skincare & Nutrition Routines
- **Morning & Evening Routines**: Step-by-step skincare guide with product assignment and completion toggles.
- **Ingredient Safety Analyzer**: Highlights beneficial vs. hazardous/avoidable ingredients based on skin type.
- **Nutrition & Hydration Tracker**: Tailored dietary suggestions and healthy recipes for glowing skin.
- **Routine Maintenance**: Add/remove products and track routine consistency over time.

### 🛍️ 4. Product Catalog & Recommendations
- Searchable product catalog categorized by type (Cleansers, Moisturizers, Sunscreens, Serums, etc.).
- Detailed product view containing ingredients, usage instructions, safety warnings, and ratings.
- Personalized recommendation engine suggesting suitable products based on skin quiz diagnostics.

### 👨‍⚕️ 5. Dermatologist Consultations & Appointments
- **Dermatologist Directory**: Browse verified dermatologists complete with ratings, years of experience, locations, and reviews.
- **Appointment Booking**: Select preferred date/time slots for **Online** or **In-Person** consultations.
- **Checkout & Summary**: Review appointment details, consultation breakdown, mock payment processing, and confirmation screen.
- **My Appointments Hub**: View upcoming and historical medical appointments.

### 💬 6. Community, Notifications & Utilities
- **Community Feed**: Connect with other users, share skincare journeys, ask questions, and discover expert tips.
- **Notification Center**: Activity alerts categorized into General and Community updates.
- **Favorites Hub**: Save preferred products and bookmarked dermatologists for quick access.
- **QR Code Utility**: Scan and share QR codes for quick profile and product lookup.

---

## 🏗️ Architecture & Multi-Module Hierarchy

The project follows strict **Clean Architecture** principles enforced by a **multi-module Gradle setup** alongside the **MVVM (Model-View-ViewModel)** design pattern. This ensures a robust separation of concerns, faster build times, and framework independence.

```mermaid
graph TD
    APP[":app"] --> PRES[":presentation"]
    APP --> DATA[":data"]
    APP --> DOM[":domain"]
    APP --> NAV[":navigation"]
    APP --> DS[":design_system"]
    
    NAV --> PRES
    NAV --> DOM
    
    PRES --> DOM
    PRES --> DS
    
    DATA --> DOM
```

### 📐 Module Breakdown & Dependency Rule

The dependency rule states that **inner modules (Domain) must not know anything about outer modules (Data or Presentation)**.

#### 1. 🧠 `:domain` (Pure Kotlin Layer)
- **Zero Android Dependencies**: A pure Kotlin library module.
- **Entities / Models**: Core data models (`User`, `Doctor`, `Product`, `Routine`, `UserAddress`).
- **Repository Interfaces**: Abstract contracts defining data operations.
- **Use Cases**: Granular units encapsulating business rules (e.g., `SignUp`, `GetDoctorDetailsUseCase`, `SaveAnswersUseCase`).

#### 2. 💾 `:data` (Data Sources & Implementations)
- Implements repository contracts defined in the `:domain` module.
- **Local Data Sources**: 
  - **Room Database** (`PearlDatabase`, `DoctorEntity`, `ProductEntity`, `PearlTypeConverter`) for offline caching and entity mapping.
  - **Preferences DataStore** (`LocalManagerImpl`) for user session flags and app entry state.
- **Remote Data Sources**:
  - **Firebase Authentication & Realtime Database** for user data and sync.
  - **Retrofit & OkHttp** (`TwilioApiService`) for RESTful SMS API requests.

#### 3. 🎨 `:presentation` (Compose UI & ViewModels)
- Depends on `:domain` and `:design_system`.
- Built entirely with **Jetpack Compose**.
- **ViewModels**: Expose reactive UI state using `StateFlow` and process single-shot events via `MVI / Event` patterns.
- Feature screens isolated from implementation details.

#### 4. 🧭 `:navigation` (Navigation Graph)
- Depends on `:presentation` and `:domain`.
- **NavGraph**: Centralized compose navigation (`PearlNavigator`) with typed routes.

#### 5. 💅 `:design_system` (UI Kit)
- Core design tokens (Colors, Typography, Themes).
- Reusable Compose UI components (`PrimaryButton`, `ErrorDialog`, `TopAppBar`, etc.).
- Shared drawable resources to ensure UI consistency across features.

#### 6. 📱 `:app` (Application & DI Layer)
- Ties everything together.
- Managed by **Dagger-Hilt** for Dependency Injection.
- Configures singleton instances (`AppModule`) for Firebase, Retrofit, Room DB, Repositories, and Use Case wrappers.

#### 7. 🛠 `:build-logic` (Convention Plugins)
- Custom Gradle plugins (`pearl.android.library`, `pearl.android.hilt`, etc.) using Version Catalogs (`libs.versions.toml`).
- Centralizes and simplifies build configuration across all modules.

---

## 📦 Dependencies & Tech Stack

All dependencies are managed centrally via a Gradle Version Catalog (`libs.versions.toml`):

### 🛠️ Core & Architecture
| Dependency | Version | Badge |
| :--- | :---: | :--- |
| **Android Core KTX** | `1.19.0` | ![Core KTX](https://img.shields.io/badge/AndroidX_Core_KTX-1.19.0-blue?style=flat-square) |
| **Lifecycle Runtime KTX** | `2.11.0` | ![Lifecycle](https://img.shields.io/badge/Lifecycle_Runtime-2.11.0-blue?style=flat-square) |
| **Kotlin Version** | `2.2.10` | ![Kotlin](https://img.shields.io/badge/Kotlin-2.2.10-purple?style=flat-square) |
| **Activity Compose** | `1.13.0` | ![Activity Compose](https://img.shields.io/badge/Activity_Compose-1.13.0-blue?style=flat-square) |
| **Splash Screen API** | `1.0.1` | ![Splash Screen](https://img.shields.io/badge/Core_SplashScreen-1.0.1-blue?style=flat-square) |

### 🎨 Jetpack Compose & UI
| Dependency | Version | Badge |
| :--- | :---: | :--- |
| **Compose BOM** | `2026.02.01` | ![Compose BOM](https://img.shields.io/badge/Compose_BOM-2026.02.01-green?style=flat-square) |
| **Compose Navigation** | `2.8.5` | ![Navigation](https://img.shields.io/badge/Navigation_Compose-2.8.5-green?style=flat-square) |
| **Accompanist System UI Controller** | `0.31.4-beta` | ![Accompanist](https://img.shields.io/badge/Accompanist-0.31.4--beta-teal?style=flat-square) |
| **Country Code Picker (xMaterialccp)** | `v1.27` | ![xMaterialccp](https://img.shields.io/badge/xMaterialccp-v1.27-orange?style=flat-square) |

### ⚡ Dependency Injection & Asynchronous Processing
| Dependency | Version | Badge |
| :--- | :---: | :--- |
| **Dagger Hilt** | `2.60.1` | ![Hilt](https://img.shields.io/badge/Dagger_Hilt-2.60.1-black?style=flat-square) |
| **Hilt Navigation Compose** | `1.2.0` | ![Hilt Navigation](https://img.shields.io/badge/Hilt_Navigation-1.2.0-black?style=flat-square) |
| **Arrow Core & FX Coroutines** | `1.2.0` | ![Arrow](https://img.shields.io/badge/Arrow_KT-1.2.0-purple?style=flat-square) |

### 🌐 Networking & Backend
| Dependency | Version | Badge |
| :--- | :---: | :--- |
| **Retrofit** | `2.11.0` | ![Retrofit](https://img.shields.io/badge/Retrofit-2.11.0-red?style=flat-square) |
| **Gson Converter** | `2.10.1` | ![Gson](https://img.shields.io/badge/Retrofit_Gson-2.10.1-red?style=flat-square) |
| **Firebase Realtime Database** | `20.2.2` | ![Firebase DB](https://img.shields.io/badge/Firebase_Database-20.2.2-FFCA28?style=flat-square) |
| **Firebase Auth** | `23.0.0` | ![Firebase Auth](https://img.shields.io/badge/Firebase_Auth-23.0.0-FFCA28?style=flat-square) |
| **Firebase Messaging** | `24.0.0` | ![Firebase Messaging](https://img.shields.io/badge/Firebase_Messaging-24.0.0-FFCA28?style=flat-square) |
| **Google Play Auth API Phone (SMS Retrieval)** | `18.0.1` | ![SMS Retrieval](https://img.shields.io/badge/Play_Services_Auth_Phone-18.0.1-4285F4?style=flat-square) |
| **Google Play Auth** | `20.3.0` | ![Play Auth](https://img.shields.io/badge/Play_Services_Auth-20.3.0-4285F4?style=flat-square) |

### 💾 Data Persistence & Image Loading
| Dependency | Version | Badge |
| :--- | :---: | :--- |
| **Room Database** | `2.7.0-alpha11` | ![Room](https://img.shields.io/badge/Room_DB-2.7.0--alpha11-blue?style=flat-square) |
| **Preferences DataStore** | `1.1.2` | ![DataStore](https://img.shields.io/badge/DataStore-1.1.2-blue?style=flat-square) |
| **Coil Compose & GIF** | `2.7.0` / `2.2.2` | ![Coil](https://img.shields.io/badge/Coil-2.7.0-darkgreen?style=flat-square) |
| **Paging 3** | `3.1.1` | ![Paging](https://img.shields.io/badge/Paging_3-3.1.1-blue?style=flat-square) |

---

## 📸 Screenshots & UI Showcase

The project includes an extensive UI screen showcase located in the `UI/` folder:

### 🌟 Onboarding & Introduction
| Welcome Screen | First Onboarding | Second Onboarding | Last Onboarding |
| :---: | :---: | :---: | :---: |
| ![Intro](<UI/Introduction screen when it's the first time for the user to enter application.png>) | ![Onboarding 1](<UI/First onboarding screen  .png>) | ![Onboarding 2](<UI/Second onboarding screen .png>) | ![Onboarding 3](<UI/Last onboarding screen .png>) |

### 🔐 Authentication & Verification
| Sign Up | OTP Verification | Verification Screen |
| :---: | :---: | :---: |
| ![Sign Up](<UI/sign up screen when user has enterd app before but doesn't have auth [Part 1].png>) | ![OTP](<UI/after sign up, app sends otp message to verify phone number.png>) | ![Verification](UI/Verification.png) |

### 🧪 Skin Diagnostic Quiz
| Skin Concerns | Nutrition Quiz | Skin Result |
| :---: | :---: | :---: |
| ![Quiz Concerns](<UI/quiz screen -  Main Skin Concerns.png>) | ![Quiz Nutrition](<UI/quiz screen - nutrition question STARTER.png>) | ![Quiz Result](<UI/quiz screen -  Skin Type Result.png>) |

### 🏠 Home, Routines & Products
| Home Dashboard | Routine Screen | Add Routine | Product Details |
| :---: | :---: | :---: | :---: |
| ![Home](UI/Home%20Screen.png) | ![Routines](UI/Routines%20Screen.png) | ![Add Routine](<UI/User can add any specific type of routine.png>) | ![Product Details](<UI/Product details screen [part 1].png>) |

### 👨‍⚕️ Dermatologist Booking & Payment
| Doctor Details | Book Appointment | Payment Method | Summary |
| :---: | :---: | :---: | :---: |
| ![Doctor](<UI/dermatologist details screen.png>) | ![Book](<UI/Book Appointment Screen.png>) | ![Payment](<UI/User can choose his payment method .png>) | ![Summary](<UI/Appiontment Summary Screen.png>) |

---

## 🛠️ Setup & Installation

### Prerequisites
- **Android Studio**: Ladybug (2024.2.1) or newer
- **JDK**: Java 17 or newer
- **Android SDK**: API Level 37

### Configuration & Secret Management
To ensure security, sensitive API keys (e.g., Twilio API credentials) are stored locally and loaded at compile-time into `BuildConfig`.

1. Clone the repository:
   ```bash
   git clone https://github.com/AbdullhGaber/PearlAndroidProjectCleanArchitecture.git
   cd PearlAndroidProjectCleanArchitecture
   ```

2. Create a `local.properties` file in the root directory if it does not exist, and insert your Twilio credentials:
   ```properties
   sdk.dir=YOUR_ANDROID_SDK_PATH

   # Twilio Secrets
   TWILIO_BASE_URL=https://api.twilio.com/
   TWILIO_SERVICE_SID=your_service_sid
   TWILIO_ACCOUNT_SID=your_account_sid
   TWILIO_AUTH_TOKEN=your_auth_token
   TEST_TWILIO_ACCOUNT_SID=your_test_account_sid
   TEST_TWILIO_AUTH_TOKEN=your_test_auth_token
   ```

3. Ensure `google-services.json` is present in the `app/` directory for Firebase initialization.

4. Sync Gradle and run the app on an emulator or physical device running Android 8.0 (API 26) or higher.

---

## 📄 License
This project is licensed under the MIT License - see the `LICENSE` file for details.
