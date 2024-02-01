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
        quickLinksSection()
        highlightSection()
    }
}

fun DIV.quickLinksSection() {
    div(classes = "home-section") {
        id = "quick-links-section"
        quickLinks.forEach {
            quickLink(it, extraClasses = "quick-links-section-item")
        }
    }
}

fun DIV.highlightSection() {
    div(classes = "home-section") {
        id = "highlights-section"
        highlightSection.forEach {
            card(caption = "Contenido destacado", content = it)
        }
    }
}

fun DIV.card(caption: String, content: CardContent) {
    div(classes = "card") {
        id = "card-${content.title.asSlug()}"

        div(classes = "left-container") {
            span { +caption }
            h3 { unsafe { +content.title } }
            p { unsafe { +content.description } }
            div(classes = "cta-container") {
                a("#") { +content.cta }
            }
        }
        div(classes = "right-container") {
            img(src = "images/${content.image}", alt = content.title) {
                id =  "highlight-image"
            }
        }

        onClickFunction = {
            window.open(content.url, "_blank")
        }
    }
}

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

fun String.asSlug() = this.replace(" ", "-").lowercase()