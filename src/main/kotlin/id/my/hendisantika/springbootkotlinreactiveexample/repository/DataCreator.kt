package id.my.hendisantika.springbootkotlinreactiveexample.repository

import id.my.hendisantika.springbootkotlinreactiveexample.data.News
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.slf4j.LoggerFactory
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.stereotype.Component

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
@Component
data class DataCreator(
    private val repository: NewsRepository
) : ApplicationRunner {

    private val logger = LoggerFactory.getLogger(javaClass)

    override fun run(args: ApplicationArguments?): Unit = runBlocking {
        // Test coroutine functionality
        launch(Dispatchers.Default) {
            repository.save(News(0, "News 1", "Sample text of news one", "no url"))
            logger.info("Added initial news to database")
        }
    }
}
