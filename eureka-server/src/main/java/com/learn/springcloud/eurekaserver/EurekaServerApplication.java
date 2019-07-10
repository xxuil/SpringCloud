package com.learn.springcloud.eurekaserver;

import cn.hutool.core.net.NetUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class EurekaServerApplication {

    public static void main(String[] args) {
        // Make sure port is working
        int port = 8761;
        if(!NetUtil.isUsableLocalPort(port)) {
            System.err.printf("Port Error: %n", port);
            System.exit(1);
        }

        new SpringApplicationBuilder(EurekaServerApplication.class)
                .properties("server.port=" + port).run(args);
    }

}
