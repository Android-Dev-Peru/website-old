package screens.home

import components.*
import data.*
import kotlinx.html.*

fun DIV.homeContent() {
    div {
        topHeader()
        quickLinksSection()
        highlightSection()
        saveTheDate()
        playlistsSection()
        blogSection()
        organizersSection()
    }
}

fun DIV.topHeader() {
    div {
        id = "top-header"
        img {
            src = "logo.svg"
            alt = "Logo de Android Dev Peru"
        }
        h1 { +"Android Dev Peru" }
        h2 { +"Comunidad de desarrolladores Android en Peru y LATAM" }
        div {
            id = "social-media-icons"
            Socials.entries.forEach { socialIcon(it.data) }
        }
    }
}

private fun DIV.quickLinksSection() {
    customSection(id = "quick-links-section") {
        QuickLinks.entries.forEach {
            quickLink(it.data, classes = "quick-links-section-item")
        }
    }
}

private fun DIV.highlightSection() {
    customSection(id = "highlights-section") {
        highlightCards.forEach {
            card(caption = "Contenido destacado", content = it, classes = "highlights-section-item")
        }
    }
}

private fun DIV.saveTheDate() {
    customSection(id = "save-the-date-section", sectionClasses = "alternate-background") {
        div(classes = "shiny-card") {
            h2 { +"ANDROID DEV CONF" }
            span { +"Sábado 26 de Octubre, 2024" }
            span { +"Lima, Peru 🇵🇪" }
        }
    }
}

private fun DIV.playlistsSection() {
    customSection(id = "events-section", classes = "grid-section") {
        div(classes = "grid-section-header") {
            h2 { +"Playlists" }
            p { +"No te pierdas el material exclusivo que la comunidad nos ha compartido a lo largo de lo años." }
            primaryButton(text = "Síguenos en Youtube", href = Links.YouTube)
        }
        div(classes = "grid-section-content") {
            playlists.forEach {
                borderlessCard(content = it)
            }
        }
    }

}

private fun DIV.blogSection() {
    customSection(id = "blog-section", classes = "grid-section", sectionClasses = "alternate-background") {
        div(classes = "grid-section-header") {
            h2 { +"Artículos recientes" }
            p { +"¿Te perdiste algún evento? No hay problema - ponte al día con las últimas novedades de nuestra comunidad" }
            primaryButton(text = "Ver todos los artículos", href = Links.DevTo)
        }

        div(classes = "grid-section-content") {
            recentBlogPosts.forEach {
                borderlessCard(it)
            }
        }
    }
}

private fun DIV.organizersSection() {
    customSection(id = "current-organizers-section") {
        div(classes = "organizers-section") {
            div {
                id = "organizers-section-header"
                h2 { +"Equipo organizador" }
                p { +"Ellos son quienes se encargan de mantener la comunidad activa mes a mes." }
            }
            div {
                id = "organizers-section-content"
                Organizers.entries.forEach {
                    organizer(it.data)
                }
            }
        }
    }
    customSection(id = "legacy-organizers-section", sectionClasses = "alternate-background") {
        div(classes = "organizers-section legacy-organizers-section") {
            div {
                id = "organizers-section-header"
                h2 { +"Equipo legacy" }
                p { +"Si bien ya no nos acompañan en el equipo, agradecemos mucho el apoyo de nuestros organizadores retirados ❤️" }
            }
            div {
                id = "organizers-section-content"
                LegacyOrganizers.entries.forEach {
                    organizer(it.data)
                }
            }
        }
    }
}

private fun DIV.customSection(id: String, sectionClasses: String = "", classes: String = "", content: DIV.()->Unit) {
    section(sectionClasses) {
        div(classes = "home-section $classes") {
            this.id = id
            content()
        }
    }
}

val highlightCards = listOf(
    CardContent(
        title = "Meetup #61",
        description = """
            Acompañanos en nuestro próximo meetup presencial + virtual.<br><br>
            🗓 Fecha: jueves 25 de abril<br>
            ⏰ Hora: 7.30PM 🇵🇪 🇨🇴<br>
            🏢 Local: Comunal Cavenecia (by Nearsure)<br>
        """.trimIndent(),
        image = "reunion.png",
        cta = "Regístrate",
        url = "https://www.youtube.com/watch?v=E9UH3_LRjmk",
    ),
    CardContent(
        title = "Encuesta salarial 2023",
        description = "La transparencia puede ayudar a reducir brechas salariales. Este mes realizamos encuestas anónimas y recibimos +100 respuestas de mobile devs en LATAM.",
        image = "survey.png",
        cta = "Mira los resultados",
        url = "https://android-dev-peru.notion.site/2023-Salarios-Mobile-Devs-40be984176ce4fd099cef15e1c8e17c7",
    ),
)

val playlists = Playlists.entries.map {
    BorderlessCard(
        title = it.data.title,
        url = it.data.url,
        thumbnail = it.data.thumbnail,
        description = it.data.description,
        caption = "Playlist",
    )
}

val recentBlogPosts = RecentBlogs.entries.map {
    BorderlessCard(
        title = it.data.title,
        url = it.data.url,
        thumbnail = it.data.thumbnail,
        description = it.data.description,
        caption = "Artículo",
    )
}
