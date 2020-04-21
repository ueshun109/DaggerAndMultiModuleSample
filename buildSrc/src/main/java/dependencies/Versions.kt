package dependencies

object Versions {
    const val androidTargetSdkVersion = 29
    const val androidCompileSdkVersion = 29
    const val androidMinSdkVersion = 26

    private const val majorVersion = 1
    private const val minorVersion = 0
    private const val patchVersion = 0

    val androidVersionCode =
        ( majorVersion * 10000 + minorVersion * 100 + patchVersion) * 10
    val androidVersionName = "$majorVersion.$minorVersion.$patchVersion"

}