plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = "com.example.pdm_roteiropratico_11"
    // 💡 CORREÇÃO: Atualizar o compileSdk para 36
    compileSdk = 36

    defaultConfig {
        applicationId = "com.example.pdm_roteiropratico_11"
        minSdk = 24
        // 💡 OPCIONAL: Também ajustando o targetSdk para 36 (boa prática)
        targetSdk = 36
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
        // Mantenha Java 11
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
}

dependencies {
    // Core Android KTX (Mantenha)
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)

    // Material Design (Mantenha e Confirme) - Necessário para TabLayout
    implementation(libs.material)

    // Componentes de Fragmento (CRÍTICO)
    // 💡 Resolve problemas de Fragmentos em Kotlin e uso no ViewPager2
    implementation("androidx.fragment:fragment-ktx:1.6.2")

    // ViewPager2 (CRÍTICO)
    // 💡 Resolve Unresolved reference 'ViewPager2'
    implementation("androidx.viewpager2:viewpager2:1.0.0")

    // Dependências do Ciclo de Vida (Para o SharedViewModel)
    // 💡 Resolve problemas com ViewModel e LiveData no Kotlin
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.7.0")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.7.0")

    // Testes (Mantenha)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}