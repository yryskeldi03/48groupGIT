plugins {
    id(Plugins.AGP.application)
    id(Plugins.Kotlin.android)
    id(Plugins.Kotlin.kapt)
    id(Plugins.Dagger.hilt)
}

android {
    namespace = "com.yrys.mykotlin5group48lesson1"
    compileSdk = AppConfig.compileSdk

    defaultConfig {
        applicationId = "com.yrys.mykotlin5group48lesson1"
        minSdk = AppConfig.minSdk
        targetSdk = AppConfig.targetSdk
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
        viewBinding = true
    }
}

dependencies {

    implementation(project(":data"))
    implementation(project(":domain"))

    // UI
    implementation(Deps.UI.androidCore)
    implementation(Deps.UI.appCompat)
    implementation(Deps.UI.material)
    implementation(Deps.UI.constraint)
    testImplementation(Deps.UI.jUnit)
    androidTestImplementation(Deps.UI.extJUnit)
    androidTestImplementation(Deps.UI.espresso)

    // Fragment
    implementation(Deps.UI.fragment)

    //Room
    implementation(Deps.Room.runtime)
    kapt(Deps.Room.compiler)
    implementation(Deps.Room.room)

    //Dagger-Hlt
    implementation(Deps.Dagger.hilt)
    kapt(Deps.Dagger.compiler)

    //Navigation component
    implementation(Deps.NavigationComponent.fragment)
    implementation(Deps.NavigationComponent.ui)

    //Lifecycle
    implementation(Deps.Lifecycle.viewmodel)
    implementation(Deps.Lifecycle.runtime)

    //ViewBindingDelegateProperty
    implementation(Deps.ViewBindingDelegate.viewBindingDelegate)
}