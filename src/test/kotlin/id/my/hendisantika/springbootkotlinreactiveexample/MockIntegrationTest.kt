package id.my.hendisantika.springbootkotlinreactiveexample

import id.my.hendisantika.springbootkotlinreactiveexample.controller.Handler
import id.my.hendisantika.springbootkotlinreactiveexample.controller.RouteConfig
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest
import org.springframework.context.annotation.Import
import org.springframework.test.web.reactive.server.WebTestClient

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
)
