package com.englishlearn.demo;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.englishlearn.demo.util.Menu;

@SpringBootApplication
public class EngloterApplication {

	public static void main(String[] args) throws IllegalAccessException, IOException {

		String pathDic = "server\\src\\main\\java\\com\\englishlearn\\demo\\util\\dic\\";
        String pathEnglish = "server\\src\\main\\java\\com\\englishlearn\\demo\\util\\dic\\english.txt";
        String pathAnother = "server\\src\\main\\java\\com\\englishlearn\\demo\\util\\dic\\another.txt";

		Menu.startMenu(pathDic, pathEnglish, pathAnother);

		// SpringApplication.run(EngloterApplication.class, args);
	}

}
