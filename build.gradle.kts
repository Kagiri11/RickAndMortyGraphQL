buildscript {
} // Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application") version "7.2.0" apply false
    id("com.android.library") version "7.2.0" apply false
    id("org.jetbrains.kotlin.android") version "1.5.31" apply false
    id("com.apollographql.apollo3") version "3.7.3" apply false
}

tasks.register(name = "type", type = Delete::class) {
    delete(rootProject.buildDir)
}
