package com.yobelbackend.yobelbackend;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.yobelbackend.yobelbackend.controllers.CharactersController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Map;

@SpringBootApplication
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
public class YobelbackendApplication {

	public static void main(String[] args) throws IOException {
		SpringApplication.run(YobelbackendApplication.class, args);

		//CharactersController charactersController;
		/*
		URL url = new URL("https://rickandmortyapi.com/api/character/");
		URLConnection connection = url.openConnection();

		try (BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()))){
			String line;
			while ((line = in.readLine()) != null) {
				System.out.println(line);
			}
		}


		String url = "https://rickandmortyapi.com/api/character/";
		String respuesta = "";

		try{
			respuesta = peticionHttpGet(url);
			System.out.println("La respuesta es:\n" + respuesta);

			Gson gson = new Gson();

			Type type = new TypeToken<Map<String, Object>>(){}.getType();
			Map<String, Object> myMap = gson.fromJson(respuesta, type);

			System.out.println(myMap.get("info"));
		} catch ( ){
			// Manejar excepción
			e.printStackTrace();

		}
		*/
	}


}
