package com.yobelbackend.yobelbackend.services;

import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@Service
public class RequestService {

    public static String requestHttpGet(String urlAPI) throws Exception {
        StringBuilder resultado = new StringBuilder();
        URL url = new URL(urlAPI);

        // Abrir la conexión e indicar que será de tipo GET
        HttpURLConnection conexion = (HttpURLConnection) url.openConnection();
        conexion.setRequestMethod("GET");

        // Búferes para leer
        BufferedReader rd = new BufferedReader(new InputStreamReader(conexion.getInputStream()));

        String linea;
        // Mientras el BufferedReader se pueda leer, agregar contenido a resultado
        while ((linea = rd.readLine()) != null) {
            resultado.append(linea);
        }

        // Cerrar el BufferedReader
        rd.close();

        return resultado.toString();
    }
}
