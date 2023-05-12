package com.example.happyanddaily;

import com.example.happyanddaily.domain.menu.repository.MenuRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class HappyAndDailyApplication {

    public static void main(String[] args) {

        SpringApplication.run(HappyAndDailyApplication.class, args);
    }

    @Bean
	public CommandLineRunner dataLoader(MenuRepository menuRepository) {
		return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
            }
        };
    }
}
