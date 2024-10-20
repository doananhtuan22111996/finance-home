plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.kotlinAndroid)
    id("kotlin-kapt")
    alias(libs.plugins.androidHilt)
}

android {
    namespace = Configs.Demo.namespace
    compileSdk = Configs.compileSdk

    defaultConfig {
        applicationId = Configs.Demo.applicationId
        minSdk = Configs.minSdk
        targetSdk = Configs.targetSdk
        versionCode = Configs.Demo.versionCode
        versionName = Configs.Demo.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = Configs.javaVersion
        targetCompatibility = Configs.javaVersion
    }
    kotlinOptions {
        jvmTarget = Configs.jvmTarget
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Configs.kotlinCompilerExtensionVersion
    }
}

dependencies {
    implementation(project(Configs.BuildModule.homePresentation))
    implementation(project(Configs.BuildModule.homeBusiness))
    implementation(libs.bundles.coreAndroidComponents)
    implementation(platform(libs.androidxComposeBom))
    implementation(libs.bundles.jetpackComposeComponents)
    implementation(libs.androidxHilt)
    kapt(libs.androidxHiltCompiler)
    testImplementation(libs.bundles.testComponents)
    testImplementation(libs.bundles.composeTestComponents)

    implementation(fnlibs.financeTheme)
    implementation(fnlibs.financeLaunch)
}

// Allow references to generated code
kapt {
    correctErrorTypes = true
}