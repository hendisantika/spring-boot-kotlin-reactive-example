package id.my.hendisantika.springbootkotlinreactiveexample.dto

import kotlinx.serialization.Serializable

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-kotlin-reactive-example
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 4/20/24
 * Time: 08:42
 * To change this template use File | Settings | File Templates.
 */
@Serializable
data class ErrorDTO(
    val msg: String,
    val fields: Map<String, String> = emptyMap()
)
