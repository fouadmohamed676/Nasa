// YApi QuickType插件生成，具体参考文档:https://plugins.jetbrains.com/plugin/18847-yapi-quicktype/documentation

package com.fouad.nasa

data class Data (
    val photos: List<Photo>
)





enum class FullName {
    ChemistryAndCameraComplex,
    FrontHazardAvoidanceCamera,
    MarsDescentImager,
    MarsHandLensImager,
    MastCamera,
    NavigationCamera,
    RearHazardAvoidanceCamera
}

enum class CameraName {
    Chemcam,
    Fhaz,
    Mahli,
    Mardi,
    Mast,
    Navcam,
    Rhaz
}



data class CameraElement (
    val fullName: FullName,
    val name: CameraName
)

enum class RoverName {
    Curiosity
}

enum class Status {
    Active
}
