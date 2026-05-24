# Blade Dawn (Android)

Original retro platformer starter for Android and Google Play publishing.

## Google Play-ready app config
- **applicationId:** `io.studioretro.bladedawn`
- **versionCode:** `1`
- **versionName:** `1.0`
- **minSdk:** `24`
- **targetSdk:** `35`

This project uses only original game content and does not include Mario-related copyrighted names, characters, assets, music, enemies, levels, or references.

## Build release AAB locally
From repo root:

```bash
cd android-game
chmod +x ./gradlew
./gradlew bundleRelease
```

Expected output AAB:

`android-game/app/build/outputs/bundle/release/app-release.aab`

## Build release AAB with GitHub Actions
Workflow file:

`.github/workflows/android-release-aab.yml`

The workflow runs `chmod +x ./gradlew
./gradlew bundleRelease` and uploads:

`android-game/app/build/outputs/bundle/release/app-release.aab`

## Build release AAB with Bitrise
1. Use `android-game` as the project directory.
2. Set Java version to 17.
3. Run Gradle task: `bundleRelease`.
4. Publish artifact from:
   `android-game/app/build/outputs/bundle/release/app-release.aab`
