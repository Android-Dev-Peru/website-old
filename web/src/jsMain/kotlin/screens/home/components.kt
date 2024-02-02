package screens.home

import kotlinx.html.*
import utils.asSlug

fun DIV.socialIcon(social: Social) {
    a(href = social.url) {
        attributes["aria-label"] = "Visit us on ${social.name}"
        img(
            src = "images/${social.icon}",
            alt = "" // handling accessibility through parent
        )
    }
}

fun DIV.blogEntry(entry: BlogEntry, caption: String) {
    div(classes = "blog-entry") {
        div(classes = "img-container") {
            a(href = entry.url) {
                img(src = entry.thumbnail, alt = entry.title) {
                    classes = setOf("thumbnail")
                }
            }
        }
        div(classes = "content") {
            span { +caption }
            a(href = entry.url) {
                h3 { +entry.title }
            }
            p { +entry.description }
        }
    }
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