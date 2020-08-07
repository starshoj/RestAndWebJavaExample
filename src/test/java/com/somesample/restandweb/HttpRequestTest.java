package com.somesample.restandweb;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class HttpRequestTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void restAndWebShouldBeAccessible() throws Exception {
        //log page opens
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/log",
                String.class)).contains("List of incoming requests");
        //data is returned
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/api/code/EUR",
                String.class)).contains("\"code\":\"EUR\"");
        //data is not case sensitive
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/api/code/eur",
                String.class)).contains("\"code\":\"EUR\"");
        //log page opensrecords are added
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/log",
                String.class)).contains("IP:");
    }
}



