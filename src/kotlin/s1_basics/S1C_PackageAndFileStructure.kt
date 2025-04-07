package kotlin.s1_basics

/*
    ---------------------------------------------------------------------------
    📘 Kotlin Basics – Lecture 3: Package & File Structure
    ---------------------------------------------------------------------------

    ✅ What This File Covers:
    - What is a package in Kotlin?
    - How to declare and organize packages.
    - Default package behavior.
    - Kotlin file structure and naming conventions.
    - Difference between file name and function/class names.
    - Rules & conventions for writing package names.
    - Best practices for scalable project structure.

    ---------------------------------------------------------------------------
    📦 What is a Package?
    ----------------------------------------------------------------------------
    - A package is a **namespace** that logically groups related code.
    - Think of it like a folder that keeps your project clean & organized.
    - Kotlin allows top-level declarations, so you don’t need classes to group code.

    ✅ Example:
        package com.tashyapps.kotlinexpertseries.s1_basics

        fun main() {
            println("Inside a structured package!")
        }

    ---------------------------------------------------------------------------
    🧭 Rules & Conventions for Package Names:
    ----------------------------------------------------------------------------
    ✅ 1. **Reverse Domain Format**:
       - Start with your website domain in reverse.
       - Example: `tashyapps.com` → `com.tashyapps`

    ✅ 2. **Use Lowercase Only**:
       - No uppercase letters, no camelCase.
       - Good: `com.tashyapps.utils`
       - Bad: `com.TashyApps.Utils`

    ✅ 3. **Separate Words with Dots (.)**:
       - Avoid underscores or hyphens.
       - Good: `com.tashyapps.chat.messages`
       - Bad: `com.tashyapps.chat-messages`

    ✅ 4. **Only One Package Declaration per File**:
       - It must be the **first non-comment line** in your `.kt` file.

    ✅ 5. **Match Folder Structure**:
       - Your folder path should match your package declaration exactly.

       Example:
       📁 com
        └── tashyapps
            └── kotlinexpertseries
                └── s1_basics
                    └── S1C_PackageAndFileStructure.kt

    ✅ 6. **Meaningful Names by Feature**:
       - Use packages to separate modules like:
         - `ui`, `data`, `network`, `viewmodel`, `auth`, `settings`, etc.

    ---------------------------------------------------------------------------
    🧾 File Naming in Kotlin:
    ----------------------------------------------------------------------------
    - File names can be anything — they do NOT have to match function or class names.
    - Group reusable code into files with logical names like:
      `MathUtils.kt`, `NetworkService.kt`, `UserRepository.kt`

    ---------------------------------------------------------------------------
*/



fun main() {
    println("Welcome to Lecture 3 – Package and File Structure")
    println("You're now inside the 'com.tashyapps.kotlinexpertseries.s1_basics' package.")
    println("Your file name, package, and folder should all be in sync.")
}
