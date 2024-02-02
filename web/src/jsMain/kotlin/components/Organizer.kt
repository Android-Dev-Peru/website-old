package components

import kotlinx.html.*
import utils.asSlug

data class Organizer(
    val name: String,
    val lastName: String,
    val photo: String,
    val alias: String? = null,
) {
    val fullName: String
        get() = "$name $lastName"
}

fun DIV.organizer(organizer: Organizer) {
    div(classes = "organizer-entry") {
        id = "organizer-${organizer.alias ?: organizer.fullName.asSlug()}"
        img {
            src = "images/${organizer.photo}"
            alt = "${organizer.name} ${organizer.lastName}"
        }
        span { +"${organizer.name} ${organizer.lastName}" }
    }

}