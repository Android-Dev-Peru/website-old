import components.navBar
import kotlinx.browser.*
import kotlinx.html.*
import kotlinx.html.dom.*
import screens.homeContent

fun main() {
    document.body!!.append.div {
        navBar()
        homeContent()
    }
}
