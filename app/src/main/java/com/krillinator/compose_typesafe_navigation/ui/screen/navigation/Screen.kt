package com.krillinator.compose_typesafe_navigation.ui.screen.navigation

import kotlinx.serialization.Serializable

sealed interface Screen {

    @Serializable
    data object Splash: Screen

    @Serializable
    data object Home: Screen

    @Serializable
    data object Login: Screen

    @Serializable
    data class User(val username: String, val password: String): Screen

}

