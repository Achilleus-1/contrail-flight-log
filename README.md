# Contrail Flight Log

Java Android prototype for recording, browsing, searching, editing, and comparing flight logs.

## Original coursework

- User Interfaces

Originally completed at the University of Texas at San Antonio and imported to GitHub later. This repository retains the coursework implementation with documented maintenance fixes and demonstration assets.

**Languages and technologies:** Java, Android, XML layouts, Gradle Kotlin DSL, local file storage.

## Implementation

- App activities for log lists, log details, comparison, demo entry, and settings.
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

The official Gradle wrapper is restored and checksum verified. Install JDK 17 and Android SDK 34, then run `./gradlew testDebugUnitTest assembleDebug assembleDebugAndroidTest`. Open in Android Studio to run the local demo. See DEVELOPMENT.md.

## Scope and limitations

- The app now opens as a local demo without collecting usernames or passwords. Legacy plaintext credentials are deleted at startup. Password recovery and credential logging are removed.
- Flight record contents are excluded from diagnostic logging and Android cloud backup/device transfer. Use fictional data; the app provides no authentication or encryption for local flight records.

Only source code, build configuration, and required text inputs are included. Written submissions, assignment instructions, PDFs, videos, generated outputs, binary builds, and private configuration are omitted. Anonymized contributor labels and supplied-code comments retain the distinction between submitted work and scaffolding. No license for course-provided material is inferred.

## Development and reuse

See [DEVELOPMENT.md](DEVELOPMENT.md) for reproducible checks and known archival dependencies, [CONTRIBUTING.md](CONTRIBUTING.md) for contribution guidance, and [SECURITY.md](SECURITY.md) for private reports.

Reuse terms and provenance are documented in [NOTICE.md](NOTICE.md) and [LICENSE](LICENSE). The maintenance license does not grant rights to original course or team material.
