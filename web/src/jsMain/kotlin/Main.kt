import kotlinx.browser.*
import kotlinx.html.*
import kotlinx.html.dom.*
import kotlinx.html.js.onClickFunction
import kotlinx.html.org.w3c.dom.events.Event

fun main() {
    document.body!!.append.div {
        navBar()
        topHeader(socials)
        homeContent()
    }
}

fun DIV.topHeader(socials: List<Social>) {
    div {
        id = "top-header"
        h1 {
            +"Comunidad de desarrolladores Android 🇵🇪"
        }
        div {
            id = "social-media-icons"
            socials.forEach {
                a(href = it.url, target = "_blank") {
                    img(src = "images/${it.icon}", alt = "Facebook")
                }
            }
        }
    }
}

fun DIV.navBar() {
    nav {
        id = "navbar"

        img(src = "logo.svg", alt = "Logo") {
            id = "logo"
            height = "48px"
            width = "48px"
        }
        span {
            id = "nav-title"
            +"Android Dev Peru"
        }
        div {
            id = "hamburger"
            onClickFunction = ::toggleNav
            +"☰"
        }
        ul {
            li { a("#") { +"Eventos" } }
            li { a("#") { +"Blog" } }
            li { a("#") { +"Miembros" } }
            li { a("#") { +"Contactanos" } }
        }
    }
}

fun toggleNav(event: Event) {
    val nav = document.getElementById("navbar")!!
    if (nav.classList.contains("open")) {
        nav.classList.remove("open")
    } else {
        nav.classList.add("open")
    }
}

fun DIV.homeContent() {
    div {
        id = "home-content"
        highlightedContent.forEach { post ->
            div {
                id = "highlighted-content"
                div {
                    id = "text-content"
                    span(classes = "caption") {
                        +"Contenido destacado"
                    }
                    h3 { unsafe { +post.title } }
                    p { unsafe { +post.description } }
                    div {
                        id = "cta-container"
                        a("#") { +post.cta }
                    }
                }
                div {
                    id = "highlight-image-container"
                    img(src = "images/${post.image}", alt = post.title) {
                        id =  "highlight-image"
                    }
                }

                onClickFunction = {
                    window.open(post.url, "_blank")
                }
            }
        }
    }
}