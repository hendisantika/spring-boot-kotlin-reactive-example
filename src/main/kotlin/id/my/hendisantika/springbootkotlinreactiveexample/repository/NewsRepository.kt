package id.my.hendisantika.springbootkotlinreactiveexample.repository

import id.my.hendisantika.springbootkotlinreactiveexample.data.News
import kotlinx.coroutines.flow.Flow
import org.springframework.data.repository.kotlin.CoroutineCrudRepository

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-kotlin-reactive-example
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 4/20/24
 * Time: 08:44
 * To change this template use File | Settings | File Templates.
 */
interface NewsRepository : CoroutineCrudRepository<News, Long> {
    override fun findAll(): Flow<News>
    override suspend fun findById(id: Long): News?
    override suspend fun existsById(id: Long): Boolean
    override suspend fun <S : News> save(entity: S): News
    override suspend fun deleteById(id: Long)
}
