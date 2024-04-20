package id.my.hendisantika.springbootkotlinreactiveexample

import id.my.hendisantika.springbootkotlinreactiveexample.dto.ErrorDTO
import id.my.hendisantika.springbootkotlinreactiveexample.dto.NewsDTO
import org.springframework.aot.hint.annotation.RegisterReflectionForBinding
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@RegisterReflectionForBinding(
    classes = [
        NewsDTO::class,
        ErrorDTO::class
    ]
)
@SpringBootApplication
class SpringBootKotlinReactiveExampleApplication

fun main(args: Array<String>) {
    runApplication<SpringBootKotlinReactiveExampleApplication>(*args)
}
