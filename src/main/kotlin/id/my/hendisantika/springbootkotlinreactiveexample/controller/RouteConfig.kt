package id.my.hendisantika.springbootkotlinreactiveexample.controller

import id.my.hendisantika.springbootkotlinreactiveexample.dto.ErrorDTO
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.bodyValueAndAwait
import org.springframework.web.reactive.function.server.coRouter

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-kotlin-reactive-example
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 4/20/24
 * Time: 08:45
 * To change this template use File | Settings | File Templates.
 */
const val NEWS_ID = "newsID"

@Configuration
class RouteConfig(
    private val handler: Handler
) {
    @Bean
    fun apiRouter() = coRouter {
        GET("") {
            ServerResponse.ok().bodyValueAndAwait(ErrorDTO("test"))
        }
        ("/api/v1" and accept(MediaType.APPLICATION_JSON)).nest {
            "/news".nest {
                GET("", handler::getNewsList)
                GET("/{$NEWS_ID}", handler::getNews)
                POST("", handler::addNews)
            }
        }
    }
}
