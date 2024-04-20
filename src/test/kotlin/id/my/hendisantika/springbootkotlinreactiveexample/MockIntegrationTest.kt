package id.my.hendisantika.springbootkotlinreactiveexample

import com.ninjasquad.springmockk.MockkBean
import id.my.hendisantika.springbootkotlinreactiveexample.controller.Handler
import id.my.hendisantika.springbootkotlinreactiveexample.controller.RouteConfig
import id.my.hendisantika.springbootkotlinreactiveexample.data.News
import id.my.hendisantika.springbootkotlinreactiveexample.data.toDTO
import id.my.hendisantika.springbootkotlinreactiveexample.dto.NewsDTO
import id.my.hendisantika.springbootkotlinreactiveexample.repository.NewsRepository
import io.mockk.coEvery
import kotlinx.coroutines.flow.flowOf
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest
import org.springframework.context.annotation.Import
import org.springframework.test.web.reactive.server.WebTestClient
import org.springframework.test.web.reactive.server.expectBody

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-kotlin-reactive-example
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 4/20/24
 * Time: 08:54
 * To change this template use File | Settings | File Templates.
 */
@WebFluxTest
@Import(RouteConfig::class, Handler::class)
class MockIntegrationTest(
    @Autowired val client: WebTestClient
) {
    @MockkBean
    private lateinit var repository: NewsRepository

    @Test
    fun `GET news by id test`() {
        val news = News(123, "Test", "Some hot news", "test.com")

        coEvery {
            repository.findById(any())
        } coAnswers {
            news
        }

        client
            .get()
            .uri("/api/v1/news/123")
            .exchange()
            .expectStatus().isOk
            .expectBody<News>()
            .isEqualTo(news)
    }

    @Test
    fun `GET all news test`() {
        val news = News(123, "Test", "Some hot news", "test.com")

        coEvery {
            repository.findAll()
        } coAnswers {
            flowOf(news)
        }

        client
            .get()
            .uri("/api/v1/news")
            .exchange()
            .expectStatus().isOk
            .expectBody<Array<NewsDTO>>()
            .isEqualTo(arrayOf(news.toDTO()))
    }

    @Test
    fun `POST news test`() {
        val news = News(123, "Test", "Some hot news", "test.com")

        coEvery {
            repository.findById(any())
        } coAnswers {
            news
        }

        client
            .get()
            .uri("/api/v1/news/123")
            .exchange()
            .expectStatus().isOk
            .expectBody<NewsDTO>()
            .isEqualTo(news.toDTO())
    }
}
