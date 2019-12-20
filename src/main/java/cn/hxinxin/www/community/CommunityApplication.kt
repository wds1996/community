package cn.hxinxin.www.community

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
object CommunityApplication {

    fun main(args: Array<String>) {
        SpringApplication.run(CommunityApplication::class.java, args)
    }

}
