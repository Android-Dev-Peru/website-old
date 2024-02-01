package components

import kotlinx.html.*

data class Social(
    val icon: String,
    val url: String,
    val name: String = "",
)

fun DIV.socialIcon(social: Social) {
    a(href = social.url, target = "_blank") {
        img(src = "images/${social.icon}", alt = social.name)
    }
}
