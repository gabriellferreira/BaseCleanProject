import com.sun.tools.javadoc.Main.execute
import java.io.ByteArrayOutputStream
import java.text.SimpleDateFormat
import java.util.*

val kotlin_version = "1.3.50"
val detektVersion = "1.0.0.RC8"

buildscript {

    repositories {
        google()
        jcenter()
        maven { uri("https://maven.fabric.io/public") }
        maven { uri("https://plugins.gradle.org/m2/") }
    }

    dependencies {
        classpath("com.android.tools.build:gradle:3.5.1")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlin_version")
        //noinspection GradleDynamicVersion
        classpath("io.fabric.tools:gradle:1.+")
    }
}

plugins {
    id("nebula.lint") version "9.3.1"
}

gradleLint {
    rules = ["dependency-parentheses", "duplicate-dependency-class", "unused-exclude-by-dep", "unused-exclude-by-conf"]
    criticalRules = ["unused-dependency"]
    // <-- this will fail the build in the event of a violation
}

allprojects {
    repositories {
        google()
        jcenter()
        maven { url "https://maven.fabric.io/public" }
    }
    apply plugin("nebula.lint")
}

ext {
    compileSdkVersion = 29
    targetSdkVersion = 29
    buildToolsVersion = "29.0.0"

    versionCode = computeVersionCode()
    versionName = computeVersionName()
    changeLog = getChangelog()
}

tasks.register("clean",Delete::class){
    delete(rootProject.buildDir)
}

fun getChangelog (): String {
    val stdout = ByteArrayOutputStream()
    exec {
        commandLine ("git", "--no-pager", "log", "--pretty=format:'%s (%an)'", "--since='1 week ago'", "--no-merges")
        standardOutput = stdout
    }
    return String(stdout.toByteArray()).replace("'", "")
}

fun computeVersionCode(): Int {
    val stdout = ByteArrayOutputStream()
    project.exec {
        commandLine = "git describe --abbrev=0".split(" ")
        standardOutput = stdout
    }
    String(stdout.toByteArray()).toInt()
}

// Version name in the form: 2018.02.01-1162a97
fun computeVersionName() {
    val stdout = ByteArrayOutputStream()
    project.exec {
        commandLine = "git describe --abbrev=0".split(" ")
        standardOutput = stdout
    }

    var name = "${now("yyyy.MM.dd")}-${String(stdout.toByteArray()).trim()}"
    val prRef = getPrRef()
    if (prRef) {
        name = "$name@$prRef"
    }
    name
}

fun now(formatString: String) {
    SimpleDateFormat (formatString).format(Date())
}

fun getPrRef(): String {
    val stdout = ByteArrayOutputStream()
    exec {
        commandLine ("git rev-parse --short HEAD")
        standardOutput = stdout
    }
    val head = String(stdout.toByteArray()).trim()

    val stdout2 = ByteArrayOutputStream()
    exec {
        commandLine ("git branch -r --contains $head")
        standardOutput = stdout2
    }
    val ref = String(stdout2.toByteArray()).trim()

//    val m = ref.trim() =~ /origin\/pr\/(\d+)\/merge/
//    return if (m) {
//        "pr-${m[0][1]}"
//    } else {
//         Not building a PR, nothing to return
//        null
//    }
}