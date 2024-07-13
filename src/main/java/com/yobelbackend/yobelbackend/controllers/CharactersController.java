package com.yobelbackend.yobelbackend.controllers;

import com.google.gson.Gson;
import com.google.gson.JsonParser;
import com.yobelbackend.yobelbackend.models.Character;
import com.yobelbackend.yobelbackend.services.CharactersService;
import com.yobelbackend.yobelbackend.services.ResponseService;
import com.yobelbackend.yobelbackend.util.Constantes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.GsonJsonParser;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/api/characters")
public class CharactersController {
    private CharactersService charactersService;

    Gson gson = new Gson();

    @Autowired
    public CharactersController(CharactersService charactersService) {
        this.charactersService = charactersService;
    }

    @GetMapping(value = "buscar/{name}")
    public ResponseService buscarPorNombre(@PathVariable String name) throws Exception {
        ResponseService response = new ResponseService(Constantes.CODE_NOT_FOUND, null);

        Character personaje = charactersService.getCharacter(name);

        if(personaje != null){
            response = new ResponseService(200, personaje);
        }

        return response;
    }

}
