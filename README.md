# Ombre — Android-Based Machine Learning Application

**Ombre** is an Android mobile application developed using **Kotlin** and **Firebase**. It was designed as part of a capstone project to demonstrate the integration of client-side Firebase services with local machine learning functionalities. The project follows Android development best practices and is built using Android Studio.

---

## 📋 Overview

This repository contains the full source code of the Ombre application. The app features category-based classification, machine learning integration, and a structured navigation system suitable for academic and prototyping use.

---

## 🔧 System Requirements

- **Android Studio Hedgehog** or later
- **Kotlin 1.8.0+**
- **Gradle Plugin Version 8.2.1**
- **Minimum SDK**: Android API Level 21
- A valid Firebase project configuration

---

## 📂 Project Structure

- `app/` — Source code and resources
- `gradle/` — Build configuration files
- `.gitignore` — Git exclusions for system and IDE files
- `build.gradle.kts` — Project-level build configuration

---

## 🧑‍💻 How to Set Up and Run the Project

### 1. Clone the Repository

```bash
git clone https://github.com/dev-jed/Ombre.git
cd Ombre

--- 
❓ Frequently Asked Questions
Why is google-services.json not included?
For security and compliance reasons, the google-services.json file is excluded from the public repository. It contains private configuration credentials specific to your Firebase project. Each developer must generate their own file via the Firebase Console.

The project fails to build or sync. What should I do?
Ensure that:

Android Studio is updated to Hedgehog or later

You have an active internet connection

The Google Services plugin is configured correctly

All SDK components and plugins are installed via the SDK Manager

Can I use my own Firebase project?
Yes. You may configure your own Firebase project and enable the required services (such as Firestore or Authentication). Ensure that your google-services.json is up to date and correctly placed in the app/ directory.

Is this application production-ready?
No. This application is intended as an academic prototype and is not optimized for production deployment.
