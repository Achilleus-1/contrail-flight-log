# Contrail Flight Log

Java Android prototype for recording, browsing, searching, editing, and comparing flight logs.

## Original coursework

- CS 4393-001 — User Interfaces, Spring 2025

Originally completed at the University of Texas at San Antonio during the terms above and imported to GitHub later. This repository preserves the submitted implementation; repository documentation and import housekeeping were added separately.

**Languages and technologies:** Java, Android, XML layouts, Gradle Kotlin DSL, local file storage.

## Implementation

- Team app activities for log lists, log details, comparison, login, recovery, and settings.
- Personal coursework contribution: UI/layout work, coding participation, use cases, and usability testing.
- Local flat-file parsing/search and comparison workflows retained from the submitted app.

## Concepts

- Multi-activity navigation, editable records, local persistence, and user-interface workflows.

## Repository layout

| Directory | Contents |
|---|---|
| `app/src/main/java/cs4393/contrail` | Activities and model classes |
| `app/src/main/res` | Text-based layouts and vector resources |
| `app/build.gradle.kts` | Android build configuration |

## Running the source

Open in Android Studio with the SDK/Gradle versions declared by the project. This source-only import excludes the APK, local.properties, wrapper JAR, and bitmap launcher icons. Regenerate the wrapper and restore compatible launcher resources before a full build.

## Scope and limitations

- The original prototype stores credentials in plaintext, logs passwords, and can display recovered passwords. This is an educational prototype and must not be used with real credentials.
- No credential database or personal local configuration is included. Authentication was not redesigned during import.

Only source code, build configuration, and required text inputs are included. Written submissions, assignment instructions, PDFs, videos, generated outputs, binary builds, and private configuration are omitted. Anonymized contributor labels and supplied-code comments retain the distinction between submitted work and scaffolding. No license for course-provided material is inferred.
