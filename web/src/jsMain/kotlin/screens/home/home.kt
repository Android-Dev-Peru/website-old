package screens.home

import components.*
import data.Links
import data.Playlists
import data.RecentBlogs
import kotlinx.html.*

fun DIV.homeContent() {
    div {
        topHeader()
        quickLinksSection()
        highlightSection()
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
            socials.forEach { socialIcon(it) }
        }
    }
}

private fun DIV.quickLinksSection() {
    customSection(id = "quick-links-section") {
        quickLinks.forEach {
            quickLink(it, classes = "quick-links-section-item")
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

private fun DIV.playlistsSection() {
    customSection(id = "events-section", classes = "grid-section") {
        div(classes = "grid-section-header") {
            h2 { +"Playlists" }
            p { +"No te pierdas todo el material exclusivo que la comunidad nos ha compartido a lo largo de lo años." }
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
                organizers.forEach {
                    organizer(it)
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
                legacyOrganizers.forEach {
                    organizer(it)
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

val socials = listOf(
    Social("social_wsp.svg", Links.WhatsApp),
    Social("social_youtube.svg", Links.YouTube),
    Social("social_twitter.svg", Links.Twitter),
    Social("social_instagram.svg", Links.Instagram),
    Social("social_linkedin.svg", Links.LinkedIn),
    Social("social_github.svg", Links.GitHub),
    Social("social_tiktok.svg", Links.TikTok),
)

val quickLinks = listOf(
    QuickLink(
        title = "Únete en WhatsApp",
        url = "https://chat.whatsapp.com/Il7yhDYCj8zLVDrK7OpFOm",
        leftIcon = "social_wsp_filled.svg",
        rightIcon = "icon_external_link.svg",
    ),
    QuickLink(
        title = "Da una charla",
        url = "https://github.com/Android-Dev-Peru/propuestas-meetup/issues/new?assignees=&labels=&projects=&template=plantilla-de-propuesta.md&title=Charla%3A+T%C3%ADtulo+de+la+charla",
        leftIcon = "icon_speaker.png",
        rightIcon = "icon_external_link.svg",
    ),
    QuickLink(
        title = "Síguenos en LinkedIn",
        url = "https://www.linkedin.com/company/android-dev-peru",
        leftIcon = "social_linkedin_filled.svg",
        rightIcon = "icon_external_link.svg",
    ),
)

val highlightCards = listOf(
    CardContent(
        title = "Meetup #59",
        description = """
            Acompañanos en nuestro próximo meetup presencial + virtual.<br><br>
            🗓 Fecha: miércoles 21 de febrero<br>
            ⏰ Hora: 7PM 🇵🇪 🇨🇴<br>
            🏢 Local: Globant<br>
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

val organizers = listOf(
    Organizer(
        name = "Eduardo",
        lastName = "Medina",
        photo = "organizer_edu.png",
    ),
    Organizer(
        name = "Bruno",
        lastName = "Aybar",
        photo = "organizer_bruno.jpeg",
    ),
    Organizer(
        name = "Jose Flavio",
        lastName = "Quispe",
        photo = "organizer_flavio.jpeg",
    ),
    Organizer(
        name = "Daniel",
        lastName = "Anaya",
        photo = "organizer_daniel.jpeg",
    ),
    Organizer(
        name = "Freddy",
        lastName = "Lazo",
        photo = "organizer_freddy.jpeg",
    ),
    Organizer(
        name = "Pedro",
        lastName = "Rau",
        alias = "Krum",
        photo = "organizer_krum.jpeg",
    ),
    Organizer(
        name = "Josue",
        lastName = "Durand",
        photo = "organizer_josue.jpeg",
    ),
    Organizer(
        name = "Carlo",
        lastName = "Huaman",
        alias = "Tohure",
        photo = "organizer_tohure.jpeg",
    ),
)

val legacyOrganizers = listOf(
    Organizer(
        name = "Jonathan",
        lastName = "Nolasco",
        photo = "organizer_nolasco.jpeg",
    ),
)