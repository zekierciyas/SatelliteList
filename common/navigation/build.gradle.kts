plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("com.google.dagger.hilt.android")
    id("androidx.navigation.safeargs.kotlin")
    id("kotlin-parcelize")
}

android {
    compileSdk = Configurations.compileSdk

    defaultConfig {
        minSdk = Configurations.minSdk
        targetSdk = Configurations.targetSdk

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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
}

dependencies {
    api(project(Modules.common.utility))
    implementation(DependencyCatalog.core)
    implementation(DependencyCatalog.appCompat)
    implementation(DependencyCatalog.androidMaterial)
    testImplementation(TestImplementation.junit)
    androidTestImplementation(AndroidTestImplementation.junit)
    androidTestImplementation(AndroidTestImplementation.espresso)
    implementation(DependencyCatalog.daggerHiltAndroid)
    kapt(DependencyCatalog.daggerHiltCompiler)
    api(DependencyCatalog.navigationFragment)
    api(DependencyCatalog.navigationUi)
    api(DependencyCatalog.navigationModuleSupport)
}