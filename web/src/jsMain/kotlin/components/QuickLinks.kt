package components

import kotlinx.browser.window
import kotlinx.html.DIV
import kotlinx.html.a
import kotlinx.html.div
import kotlinx.html.img
import kotlinx.html.js.onClickFunction

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
        a("#") { +link.title }
        link.rightIcon?.let {
            img(
                classes = "right-icon",
                src = "images/$it",
            )
        }
        onClickFunction = {
            window.open(link.url, "_blank")
        }
    }
}