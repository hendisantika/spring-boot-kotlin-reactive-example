package id.my.hendisantika.springbootkotlinreactiveexample.controller

import id.my.hendisantika.springbootkotlinreactiveexample.data.toDTO
import id.my.hendisantika.springbootkotlinreactiveexample.repository.NewsRepository
import kotlinx.coroutines.flow.map
import org.slf4j.LoggerFactory
import org.springframework.http.MediaType
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.bodyAndAwait

@Component
class Handler(
    private val repository: NewsRepository

    private val log = LoggerFactory.getLogger(javaClass)

            suspend fun getNewsList(req: ServerRequest): ServerResponse {
        val news = repository.findAll().map { it.toDTO() }

        return ServerResponse
            .ok()
            .contentType(MediaType.APPLICATION_JSON)
            .bodyAndAwait(news)
    }
)
