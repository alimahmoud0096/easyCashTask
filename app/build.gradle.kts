// Define the base URL as a variable
var baseUrl = "https://api.football-data.org/v4/"
var database_secret_key = "pas"


plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    kotlin("kapt")
    id ("kotlin-parcelize")
    id("com.google.dagger.hilt.android")
    id("androidx.navigation.safeargs")
}

android {
    namespace = "com.smart4apps.easyCashTask"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.smart4apps.easyCashTask"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }


    buildTypes {
        debug {
            buildConfigField("String", "BASE_URL", "\"${baseUrl}\"")
            buildConfigField("String", "database_secret_key", "\"${database_secret_key}\"")
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
        release {
            buildConfigField("String", "BASE_URL", "\"${baseUrl}\"")
            buildConfigField("String", "database_secret_key", "\"${database_secret_key}\"")
            isMinifyEnabled = true
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
        dataBinding = true
        buildConfig = true
    }
    
}



dependencies {

    implementation("androidx.test.ext:junit-ktx:1.1.5")
    testImplementation("org.junit.jupiter:junit-jupiter:5.8.1")
    testImplementation("org.junit.jupiter:junit-jupiter:5.8.1")
    val kotlinVersion = "1.7.0"
    implementation ("org.jetbrains.kotlin:kotlin-stdlib-jdk7:$kotlinVersion")
    implementation("androidx.core:core-ktx:1.9.0")

    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.10.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.6.2")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.2")
    implementation("androidx.navigation:navigation-fragment-ktx:2.7.6")
    implementation("androidx.navigation:navigation-ui-ktx:2.7.6")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.3.9")

    //hilt
//    implementation("com.google.dagger:hilt-android:2.42")
//    kapt("com.google.dagger:hilt-android-compiler:2.42")
    implementation("com.google.dagger:hilt-android:2.42")
    kapt("com.google.dagger:hilt-android-compiler:2.42")
//    implementation("androidx.hilt:hilt-lifecycle-viewmodel:1.0.0-alpha03")
//    kapt ("androidx.hilt:hilt-compiler:1.0.0-alpha03")
    // For instrumentation tests
//    androidTestImplementation  ("com.google.dagger:hilt-android-testing:2.49")
//    kaptAndroidTest ("com.google.dagger:hilt-compiler:2.49")


//    implementation("com.squareup.retrofit2:retrofit:2.9.0")
//
    val retrofitVersion = "2.9.0"
    val okhttpLoggingVersion = "4.9.0"
    implementation("com.github.bumptech.glide:glide:4.16.0")
    implementation("com.squareup.retrofit2:retrofit:$retrofitVersion")
    implementation("com.squareup.retrofit2:converter-gson:$retrofitVersion")
    implementation("com.squareup.okhttp3:logging-interceptor:$okhttpLoggingVersion")


    //room
    // Room
    implementation ("androidx.room:room-runtime:2.6.1")
    kapt ("androidx.room:room-compiler:2.6.1")
    implementation ("androidx.room:room-ktx:2.6.1")


    //for secure room db
    implementation ("net.zetetic:android-database-sqlcipher:4.5.3")


    implementation ("com.squareup.picasso:picasso:2.71828")

}