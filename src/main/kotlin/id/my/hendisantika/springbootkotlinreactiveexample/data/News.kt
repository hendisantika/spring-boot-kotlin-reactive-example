package id.my.hendisantika.springbootkotlinreactiveexample.data

import id.my.hendisantika.springbootkotlinreactiveexample.dto.NewsDTO
import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-kotlin-reactive-example
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 4/20/24
 * Time: 08:41
 * To change this template use File | Settings | File Templates.
 */
@Table("news")
data class News(
    @Id
    val id: Long = 0,

    val title: String,
    val text: String,
    val url: String,
    @Column("image_url")
    val imageUrl: String? = null
)

fun News.toDTO(): NewsDTO {
    return NewsDTO(id, title, text, url, imageUrl)
}
