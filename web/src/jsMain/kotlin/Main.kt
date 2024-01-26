import kotlinx.browser.*
import kotlinx.html.*
import kotlinx.html.dom.*

fun main() {
    document.body!!.append.div {
        h1 {
            +"Welcome to Android Dev Peru!"
        }
        p {
            +"Fancy joining this year's "
            a("https://kotlinconf.com/") {
                +"Android Dev Conf"
            }
            +"?"
        }
    }
}