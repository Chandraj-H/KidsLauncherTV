# KidsLauncherTV
A Launcher app for Android TV that engages Kids Mode with followinng features:
- App Restriction Feature: Only approved apps visible
- Grid based UI (below average appeal currently)
- Exit protection: 4 digit PIN for getting back the system launcher.
- Easy launch of apps
- Navigation (Questionable as responds to arrow keys in emulator but not checked on a real Android TV)

## Execution
Project was developed on Android Studio Ladybug 2024.2.1, gradle version 8.9.
In case you are running this on an emulator and the emulator allows to change the default launcher. then you will have tob choose if you want the app's launcher as default or the default one.
If emulator doesn't allow you to change the default TV launcher then you have to click on this app to run the launcher.
To exit just press 1234 (and OK) for getting back the default system launcher.

## Still Working on:
- Better UI
- Restrict access to system setting (no real Android TV to work on)

## Implementation
Follows Clean Architecture:
Presentation layer : Has all ui elements.
Data layer: gets data from ata source.
utils layer: processing of data to later display.
