package com.usaa.CodingChallenge;

import com.usaa.CodingChallenge.Repo.ChallengeRepository;
import com.usaa.CodingChallenge.Repo.USAACodingChallengeRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.annotation.PostConstruct;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = {ChallengeRepository.class})
public class CodingChallengeApplication {

	public static void main(String[] args) {
		SpringApplication.run(CodingChallengeApplication.class, args);
	}

}
