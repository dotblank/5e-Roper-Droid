# 5e-Roper-Droid
The better D&amp;D 5e app. This app is currently in heavy construction, more details regarding the roadmap may be found in the [wiki](../../wiki).

# Requirements
Android SDK 22 (The target sdk can be changed by editing the pom.xml)

Maven version 3


## Linux Compilation
ANDROID_HOME environmental variable must be set

The following must also be added to your PATH
* $ANDROID_HOME/platform-tools
* $ANDROID_HOME/tools

To comile simply run
> mvn package

If this fails, ensure the android development kit tools directory is on the system path.

If you set your ANDROID_HOME in a .bashrc you will need to resolve the variable as a command line argument
> mvn package -Dandroid.sdk.path=$ANDROID_HOME


# Running

## Emulating from Linux
After compilation has completed the app can be tested in an emulator. Start the emulator by using the Android Virtual Device GUI.

> android avd

The compiled app (assuming the debug version) can be installed to the emulator once the virtual device has started up.

> adb install target/roper.apk

## Running on physical hardware
If the android device is connected and running in debug mode, you can issue one command to compile, install and run

> mvn package android:deploy android:run

or optionally

> mvn package android:deploy android:run -Dandroid.sdk.path=$ANDROID_HOME
