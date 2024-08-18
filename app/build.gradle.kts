plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    id("kotlin-kapt")
}

android {
    namespace = "com.example.myapp"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.myapp"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    // AndroidX and Jetpack Compose
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)

    // Room
    implementation("androidx.room:room-runtime:2.6.0")
    kapt("androidx.room:room-compiler:2.6.0")
    implementation("androidx.room:room-ktx:2.6.0") // Ensure Room KTX is included

    // Jetpack Compose Additional Libraries
    implementation("androidx.compose.ui:ui:1.6.0")
    implementation("androidx.compose.material:material:1.6.0")
    implementation("androidx.compose.ui:ui-tooling-preview:1.6.0")
    implementation("androidx.activity:activity-compose:1.8.0")
    implementation("androidx.navigation:navigation-compose:2.7.4")

    // Coroutines
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.3")

    // Testing Libraries
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation("androidx.compose.ui:ui-test-junit4:1.6.0")
    debugImplementation("androidx.compose.ui:ui-tooling:1.6.0")
    debugImplementation("androidx.compose.ui:ui-test-manifest:1.6.0")

    // Testing Dependencies
    androidTestImplementation ("androidx.compose.ui:ui-test-junit4:1.6.0")
    debugImplementation ("androidx.compose.ui:ui-test-manifest:1.6.0")

    // Compose UI Testing
    androidTestImplementation ("androidx.compose.ui:ui-test-junit4:1.6.0")

    /*
    // Mockito for testing
    testImplementation ("org.mockito:mockito-core:4.8.0")
    androidTestImplementation ("org.mockito:mockito-android:4.8.0")


    //new
    // Compose UI
    implementation ("androidx.compose.ui:ui:1.4.0")
    implementation ("androidx.compose.material:material:1.4.0")
    implementation ("androidx.compose.ui:ui-tooling-preview:1.4.0")
    debugImplementation ("androidx.compose.ui:ui-tooling:1.4.0")

    // Testing
    androidTestImplementation ("androidx.compose.ui:ui-test-junit4:1.4.0")
    androidTestImplementation ("org.mockito:mockito-core:5.5.0")
    androidTestImplementation ("org.mockito:mockito-inline:5.5.0")
    androidTestImplementation ("org.mockito:mockito-kotlin:5.1.0")


    // edit
    // Jetpack Compose Testing
    androidTestImplementation("androidx.compose.ui:ui-test-junit4:1.5.0")
    debugImplementation("androidx.compose.ui:ui-tooling:1.5.0")

    //edit-3
    // Kotlin standard library
    implementation("org.jetbrains.kotlin:kotlin-stdlib:1.8.0")

    // Mockito
    testImplementation("org.mockito:mockito-core:5.5.0")
    testImplementation("org.mockito.kotlin:mockito-kotlin:5.0.0")

    // AndroidX Test
    androidTestImplementation("androidx.compose.ui:ui-test-junit4:1.5.0")
    debugImplementation("androidx.compose.ui:ui-tooling:1.5.0")

    //edit-4
    // Mockito Core
    testImplementation("org.mockito:mockito-core:5.5.0")

    // Mockito Kotlin
    testImplementation("org.mockito.kotlin:mockito-kotlin:5.0.0")

    // AndroidX Test
    androidTestImplementation("androidx.compose.ui:ui-test-junit4:1.5.0")
    debugImplementation("androidx.compose.ui:ui-tooling:1.5.0")

   */

}
