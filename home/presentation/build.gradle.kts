plugins {
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.kotlinAndroid)
    id("kotlin-kapt")
    alias(libs.plugins.androidHilt)
    `maven-publish`
}

android {
    namespace = Configs.namespace
    compileSdk = Configs.compileSdk

    defaultConfig {
        minSdk = Configs.minSdk

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
        sourceCompatibility = Configs.javaVersion
        targetCompatibility = Configs.javaVersion
    }
    kotlinOptions {
        jvmTarget = Configs.jvmTarget
    }
    buildFeatures {
        compose = true
        buildConfig = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Configs.kotlinCompilerExtensionVersion
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    publishing {
        multipleVariants("all") {
            allVariants()
            withSourcesJar()
        }
    }
}

publishing {
    val ghUsername = System.getenv("GH_USERNAME")
    val ghPassword = System.getenv("GH_TOKEN")
    repositories {
        maven {
            name = "GitHubPackages"
            url = uri("${Configs.mavenDomain}/${ghUsername}/finance-home")
            credentials {
                username = ghUsername
                password = ghPassword
            }
        }
    }
    publications {
        create<MavenPublication>("mavenAndroid") {
            afterEvaluate {
                from(components["all"])
            }
            groupId = Configs.Artifact.groupId
            artifactId = Configs.Artifact.artifactId
            version = Configs.Artifact.version
        }
    }
}

dependencies {
    implementation(fnlibs.financeTheme)
    implementation(fnlibs.financeNavigation)

    implementation(project(Configs.BuildModule.homeBusiness))
    implementation(libs.coreLibxDomain)
    implementation(libs.coreLibxUiComposex)
    implementation(libs.bundles.coreAndroidComponents)
    implementation(platform(libs.androidxComposeBom))
    implementation(libs.bundles.jetpackComposeComponents)
    implementation(libs.androidxHilt)
    kapt(libs.androidxHiltCompiler)

    testImplementation(libs.bundles.testComponents)
    testImplementation(libs.bundles.composeTestComponents)
    androidTestImplementation(libs.bundles.androidTestComponents)
}

// Allow references to generated code
kapt {
    correctErrorTypes = true
}