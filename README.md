# 5e-Roper-Droid
The better D&amp;D 5e app. This app is currently in heavy construction, more details regarding the roadmap may be found in the [wiki](../../wiki).

# Compilation

## Linux Compilation
Before compilation the android development kit needs to generate local.properties. After cloning the repository run the command below in its root directory.

> android update project --path .

If this fails, ensure the android development kit tools directory is on the system path.

The ant build tool is necessary to compile the app. Running this command from the repository root will compile the debug version of the app.

> ant debug

# Running

## Emulating from Linux
After compilation has completed the app can be tested in an emulator. Start the emulator by using the Android Virtual Device GUI.

> android avd

The compiled app (assuming the debug version) can be installed to the emulator once the virtual device has started up.

> adb install bin/Roper5eDroid-debug.apk
