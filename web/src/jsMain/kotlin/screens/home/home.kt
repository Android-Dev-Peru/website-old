package screens.home

import components.*
import data.Links
import kotlinx.html.*

fun DIV.homeContent() {
    div {
        topHeader()
        quickLinksSection()
        highlightSection()
        blogSection()
        organizersSection()
    }
}

fun DIV.topHeader() {
    div {
        id = "top-header"
        h1 { +"Android Dev Peru" }
        h2 { +"🇵🇪 Comunidad de desarrolladores Android en Peru y LATAM 🇵🇪" }
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
            card(caption = "Contenido destacado", content = it)
        }
    }
}

private fun DIV.blogSection() {
    customSection(id = "blog-section", classes="alternate-background") {
        div {
            id = "blog-section-header"
            h2 { +"Artículos recientes" }
            p { +"¿Te perdiste algún evento? No hay problema - ponte al día con las últimas novedades de nuestra comunidad" }
            primaryButton(text = "Ver todos los artículos", href = Links.DevTo)
        }

        div {
            id = "blog-section-content"
            recentBlogPosts.forEach {
                blogEntry(entry = it, caption = "Artículo")
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
    customSection(id = "legacy-organizers-section", classes = "alternate-background") {
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

private fun DIV.customSection(id: String, classes: String = "", content: DIV.()->Unit) {
    section(classes) {
        div(classes = "home-section") {
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
            🗓 fecha: miércoles 21 de agosto<br>
            ⏰ hora: 7PM 🇵🇪 🇨🇴<br>
            🏢 local: Globant<br>
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

val recentBlogPosts = listOf(
    BlogEntry(
        title = "Meetup #57: Kotlin Multiplatform is Stable!",
        url = "https://dev.to/androiddevperu/meetup-57-build-your-first-app-with-kmp-bp0",
        thumbnail = "https://res.cloudinary.com/practicaldev/image/fetch/s--o8Vcpr03--/c_limit%2Cf_auto%2Cfl_progressive%2Cq_auto%2Cw_800/https://dev-to-uploads.s3.amazonaws.com/uploads/articles/p5edmwpvxcnryqohd17q.jpeg",
        description = "El jueves 26 de noviembre de 2023 nos visitó el GDE Yury Camacho desde Bolivia para hablarnos sobre Kotlin Multiplatform.",
    ),
    BlogEntry(
        title = "DevFest 2023 - GDG Open",
        url = "https://dev.to/androiddevperu/devfest-2023-gdg-open-1b37",
        thumbnail = "https://res.cloudinary.com/practicaldev/image/fetch/s--A7FMokQZ--/c_limit%2Cf_auto%2Cfl_progressive%2Cq_auto%2Cw_800/https://dev-to-uploads.s3.amazonaws.com/uploads/articles/x34agc51zzdtnt6x8jbw.jpeg",
        description = "El 12 de noviembre de 2023, participamos en el DevFest 2023 del GDG Open, en donde elaboramos un taller sobre Jetpack Compose.",
    ),
    BlogEntry(
        title = "Feria de comunidades en BCP",
        url = "https://dev.to/androiddevperu/feria-de-comunidades-en-bcp-58df",
        thumbnail = "https://res.cloudinary.com/practicaldev/image/fetch/s--4_TmxZwH--/c_limit%2Cf_auto%2Cfl_progressive%2Cq_auto%2Cw_800/https://dev-to-uploads.s3.amazonaws.com/uploads/articles/fm8vla3rsxaezcp0qvxp.jpeg",
        description = "El 22 de noviembre tuvimos la oportunidad de participar en la feria de comunidades que organizó el BCP, donde participaron más de 400 personas",
    ),
    BlogEntry(
        title = "Meetup #56: Bluetooth desde 0",
        url = "https://dev.to/androiddevperu/meetup-56-controlando-bluetooh-desde-0-3j27",
        thumbnail = "https://res.cloudinary.com/practicaldev/image/fetch/s--AL-Z6Dmp--/c_limit%2Cf_auto%2Cfl_progressive%2Cq_auto%2Cw_800/https://dev-to-uploads.s3.amazonaws.com/uploads/articles/xd3pk3kbay51di61bkiv.jpeg",
        description = "El 30 de octubre, tuvimos una charla virtual!, en nuestro meetup #56 en el cual Hansy Schmitt nos compartió sus conocimientos de Bluetooth."
    ),
)

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