plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = "com.amaurypm.mvvmdm"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.amaurypm.mvvmdm"
        minSdk = 24
        targetSdk = 35
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures{
        viewBinding = true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)

    //Corrutinas con alcance del ViewModel
    implementation (libs.androidx.lifecycle.viewmodel.ktx)

    //LiveData (opcional para proyectos legacy)
    implementation (libs.androidx.lifecycle.livedata.core.ktx)

    //Kotlin extensions para instanciar viewmodels sin parámetros desde activities con un delegado
    implementation (libs.androidx.activity.ktx)

    //Kotlin extensions para instanciar viewmodels sin parámetros desde fragments con un delegado
    implementation (libs.androidx.fragment.ktx)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}