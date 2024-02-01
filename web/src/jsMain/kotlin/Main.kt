import components.card
import components.navBar
import components.quickLink
import kotlinx.browser.*
import kotlinx.html.*
import kotlinx.html.dom.*
import screens.homeContent
import screens.quickLinks

fun main() {
    document.body!!.append.div {
        navBar()
        homeContent()
    }
}
