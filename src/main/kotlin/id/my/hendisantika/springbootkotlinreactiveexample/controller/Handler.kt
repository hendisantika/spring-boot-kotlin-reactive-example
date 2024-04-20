package id.my.hendisantika.springbootkotlinreactiveexample.controller

import id.my.hendisantika.springbootkotlinreactiveexample.repository.NewsRepository
import org.springframework.stereotype.Component

@Component
class Handler(
    private val repository: NewsRepository
)
