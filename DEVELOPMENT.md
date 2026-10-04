# Development

Use JDK 17 and Android SDK 34. Run `./gradlew testDebugUnitTest assembleDebug
assembleDebugAndroidTest` (Windows: `gradlew.bat ...`). The official Gradle 8.7
wrapper and distribution checksum are committed; SDK paths remain local.
Run `python tools/check_repository.py` for source and privacy checks.

The entry screen opens a local demo without credentials. Existing legacy
`credentials.csv` is deleted on launch. The existing activity names are retained
for compatibility, but there is no recovery or account-creation functionality.
Cloud backups are disabled and both legacy backup and device-transfer rules
exclude flight records and legacy credentials. Settings can clear local logs.

Use fictional records. Flight data is stored locally as an unencrypted CSV;
this is not a production aviation record system. A build verifies compilation,
not full navigation, visual accessibility, or aviation accuracy.
