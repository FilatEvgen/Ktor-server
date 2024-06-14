package data_model

import kotlinx.serialization.Serializable

@Serializable

data class GameCards(
    val image: String,
    val title: String,
    val link: String,
    val icon: String,
    val rating: Float,
)
