package com.lanlantu.blog;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class LanlantuBlogApplicationTests {
    @Autowired
    BlogInfoService blogInfoService;

    @Autowired
    RedisTemplate redisTemplate;

    @Test
    void contextLoads() {
    }

}
