package com.kiyotakeshi.jpaPlayground;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
class JpaPlaygroundApplicationTests {

    @Autowired
    private TestRestTemplate restTemplate;

    @LocalServerPort
    private int port;

    @Test
    void contextLoads() {
        ResponseEntity<String> response = this.restTemplate.getForEntity("http://localhost:" + port + "/employees", String.class);
        String expected =
                "[{\"id\":1,\"firstName\":\"mike\",\"lastName\":\"popcorn\",\"mailAddress\":\"mike.popcorn@example.com\"}," +
                        "{\"id\":2,\"firstName\":\"kanye\",\"lastName\":\"kendrick\",\"mailAddress\":\"kanye.kendrick@example.com\"}]";

        Assertions.assertEquals(expected, response.getBody());

        // 発行される SQL
        // Hibernate:
        //    select
        //        employee0_.id as id1_0_,
        //        employee0_.first_name as first_na2_0_,
        //        employee0_.last_name as last_nam3_0_,
        //        employee0_.mail_address as mail_add4_0_
        //    from
        //        employee employee0_
    }
}
