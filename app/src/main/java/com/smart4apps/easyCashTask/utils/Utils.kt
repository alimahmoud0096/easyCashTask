package com.smart4apps.easyCashTask.utils

import android.content.Context


class Utils {


    // Enum or constant representing installers/sources
    enum class Installer {
        GOOGLE_PLAY_STORE,
        // Add other installers/sources as needed
    }

    companion object {

        fun verifyInstaller(context: Context, installer: Installer): Boolean {
            when (installer) {
                Installer.GOOGLE_PLAY_STORE -> {
                    // A list with valid installers package name
                    val validInstallers: List<String> =
                        ArrayList(
                            mutableListOf(
                                "com.android.vending",
                                "com.google.android.feedback"
                            )
                        )

                    // The package name of the app that has installed your app
                    val installer =
                        context.packageManager.getInstallerPackageName(context.packageName)

                    // true if your app has been downloaded from Play Store
                    return installer != null && validInstallers.contains(installer)
                }

                else -> {
                    return false
                }

            }

        }
    }
}