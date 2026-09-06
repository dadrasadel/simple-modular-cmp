# simple modular cmp

A Kotlin Multiplatform sample app with a modular structure inspired by the original `refah-cmp` project, but trimmed down to a simple calendar-focused starter.

## Platforms

- Android
- iOS
- JS
- WASM JS

## Module Structure

- `composeApp` - multiplatform app entry point
- `common` - shared app primitives such as `AppResult`, `UiText`, and constants
- `core` - shared app metadata, logging, and dispatcher abstractions
- `domain` - calendar domain models and month generation
- `presentation/ui` - shared Compose UI theme helpers
- `presentation/feature/calendar` - the calendar screen feature

## What It Contains

- A simple month calendar UI
- Previous/next month navigation
- Selected day state
- Shared modular architecture without API URLs or backend keys

## Getting Started

### Android

Open the project in Android Studio and run the `composeApp` configuration.

### JS

Use the Gradle JS task configured by the KMP setup.

### iOS

Use the generated KMP iOS framework from `composeApp`.

## Notes

- This project is intentionally lightweight.
- The modular structure is ready for expanding into more features later.
