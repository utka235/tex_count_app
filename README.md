# Tex Count App

This is a minimal Android example for calculating total cost with a 13% tax (Canada).
You can add up to 999 product prices. The app sums the prices and shows the total
before and after tax.

## Building

This project uses Gradle. From Android Studio choose **Open** and select this
folder. Then build and run on a device or emulator.

### Offline environment

Gradle needs to download its dependencies the first time you build. Without
internet access the build will fail with missing artifact errors. Run the
project once on a networked machine or copy the required artifacts into your
local Gradle cache so you can use the `--offline` flag for subsequent builds.
