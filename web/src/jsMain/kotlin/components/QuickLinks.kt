package components

import kotlinx.html.DIV
import kotlinx.html.a
import kotlinx.html.div
import kotlinx.html.img

data class QuickLink(
    val title: String,
    val url: String,
    val leftIcon: String,
    val rightIcon: String? = null,
)

fun DIV.quickLink(link: QuickLink, extraClasses: String = "") {
    div(classes = "quick-link $extraClasses") {
        img(
            classes = "left-icon",
            src = "images/${link.leftIcon}",
        )
        a(link.url) { +link.title }
        link.rightIcon?.let {
            img(
                classes = "right-icon",
                src = "images/$it",
            )
        }
    }
}