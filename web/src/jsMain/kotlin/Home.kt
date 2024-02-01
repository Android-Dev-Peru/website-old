data class CardContent(
    val title: String,
    val description: String,
    val image: String,
    val cta: String,
    val url: String,
)

data class QuickLink(
    val title: String,
    val url: String,
    val leftIcon: String,
    val rightIcon: String? = null,
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

val highlightSection = listOf(
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