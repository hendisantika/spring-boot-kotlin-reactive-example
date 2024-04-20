package id.my.hendisantika.springbootkotlinreactiveexample.controller

import id.my.hendisantika.springbootkotlinreactiveexample.data.toDTO
import id.my.hendisantika.springbootkotlinreactiveexample.dto.ErrorDTO
import id.my.hendisantika.springbootkotlinreactiveexample.repository.NewsRepository
import kotlinx.coroutines.flow.map
import org.slf4j.LoggerFactory
import org.springframework.http.MediaType
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.*

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

            suspend fun getNews(req: ServerRequest): ServerResponse {
        val id = req.pathVariable(NEWS_ID).toLongOrNull() ?: return ServerResponse
            .badRequest()
            .bodyValue(ErrorDTO(msg = "Invalid news id in path"))
            .awaitSingle()

        val news = repository.findById(id)?.toDTO() ?: return ServerResponse
            .notFound()
            .buildAndAwait()

        return ServerResponse
            .ok()
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValueAndAwait(news)
    }
)
