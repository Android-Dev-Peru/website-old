package components

import kotlinx.html.*

data class BlogEntry(
    val title: String,
    val url: String,
    val thumbnail: String,
    val description: String,
)

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