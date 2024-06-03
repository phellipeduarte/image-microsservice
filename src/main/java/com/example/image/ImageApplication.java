package com.example.image;

import com.cloudinary.Cloudinary;
import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ImageApplication {

	Dotenv dotenv = Dotenv.load();

	public static void main(String[] args) {
		SpringApplication.run(ImageApplication.class, args);
	}

	@Bean
	public Cloudinary cloudinary(){
		return new Cloudinary(dotenv.get("CLOUDINARY_URL"));
	}
}
