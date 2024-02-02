import kotlinx.browser.*
import kotlinx.html.*
import kotlinx.html.dom.*
import screens.home.homeContent

fun main() {
    document.body!!.append.div {
        homeContent()
    }
}
