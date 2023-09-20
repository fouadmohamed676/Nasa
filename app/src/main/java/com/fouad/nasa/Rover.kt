package com.fouad.nasa

data class Rover (
    val maxSol: Long,
    val cameras: List<CameraElement>,
    val maxDate: String,
    val totalPhotos: Long,
    val name: RoverName,
    val id: Long,
    val launchDate: String,
    val landingDate: String,
    val status: Status
)
