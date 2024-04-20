package id.my.hendisantika.springbootkotlinreactiveexample.dto

import id.my.hendisantika.springbootkotlinreactiveexample.data.News
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-kotlin-reactive-example
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 4/20/24
 * Time: 08:43
 * To change this template use File | Settings | File Templates.
 */
@Serializable
data class NewsDTO(
    val id: Long = 0,
    val title: String,
    val text: String,
    val url: String,
    @SerialName("image_url")
    val imageUrl: String? = null
)

fun NewsDTO.toData(): News {
    return News(id, title, text, url, imageUrl)
}
