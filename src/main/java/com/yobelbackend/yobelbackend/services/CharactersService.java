package com.yobelbackend.yobelbackend.services;

import com.yobelbackend.yobelbackend.models.Character;
import com.yobelbackend.yobelbackend.models.Location;
import com.yobelbackend.yobelbackend.util.Constantes;
import com.yobelbackend.yobelbackend.util.JsonUtil;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CharactersService {

    RequestService requestService = new RequestService();

    private List<Character> getCharacters(ArrayList<Map<String, Object>> characters) throws Exception {

        List<Character> listaPersonajes = new ArrayList<Character>();

        for (int i=0; i<characters.size(); i++){
            Character character = new Character();

            Map<String, Object> dato = new HashMap<String, Object>();

            dato = (Map<String, Object>) characters.get(i);

            Double id = (Double) dato.get("id");

            Long parseId = Math.round(id);

            character.setId(parseId);
            character.setName(dato.get("name").toString());
            character.setStatus(dato.get("status").toString());
            character.setSpecies(dato.get("species").toString());
            character.setGender(dato.get("gender").toString());
            character.setImage(dato.get("image").toString());

            //Instanciar Last Location
            Location lastLocation = new Location();

            Map<String, Object> location = (Map<String, Object>) dato.get("location");

            lastLocation.setName(location.get("name").toString());
            lastLocation.setUrl(location.get("url").toString());

            character.setLastKnownLocation(lastLocation);

            //Instanciar Origin
            Location origin = new Location();

            location = (Map<String, Object>) dato.get("origin");

            origin.setName(location.get("name").toString());
            origin.setUrl(location.get("url").toString());

            character.setOriginLocation(origin);

            listaPersonajes.add(character);
        }

        return  listaPersonajes;
    }

    public Character getCharacter(String name) throws Exception {
        Character character = new Character();

        //CONSUMIR API CHARACTER
        Map<String, Object> resultadoApiCharacter = consumirApiCharacters();

        //INFO
        Map<String, Object> info = (Map<String, Object>)  resultadoApiCharacter.get("info");

        //RESULTS
        List<Character> personajes = this.getCharacters((ArrayList<Map<String, Object>>) resultadoApiCharacter.get("results"));

        //BUSCAR NOMBRE DEL PERSONAJE EN EL ARRAYLIST DE LA PAGINA 1
        character = findByName(personajes, name);

        //SI NO ENCONTRO EL NOMBRE BUSCAR EN LA SIGUIENTE PAGINA (2 hasta la ultima)
        if(character == null){
            Long paginas = Math.round((Double) info.get("pages"));

            for(int i=2; i<=paginas; i++){
                resultadoApiCharacter = consumirApiCharacters(info.get("next").toString());

                info = (Map<String, Object>)  resultadoApiCharacter.get("info");
                personajes = this.getCharacters((ArrayList<Map<String, Object>>) resultadoApiCharacter.get("results"));

                //BUSCAR NOMBRE DEL PERSONAJE EN EL ARRAYLIST DE LA PAGINA 2 EN ADELANTE
                character = findByName(personajes, name);

                if(character != null){
                    break;
                }
            }
        }

        return character;
    }

    private Map<String, Object> consumirApiCharacters() throws Exception {
        String resultado = requestService.requestHttpGet(Constantes.URL_CHARACTERS);

        return JsonUtil.parseJsonToMap(resultado);
    }

    private Map<String, Object> consumirApiCharacters(String next) throws Exception {
        String resultado = requestService.requestHttpGet(next);

        return JsonUtil.parseJsonToMap(resultado);
    }

    private Character findByName(List<Character> personajes, String name){
        for (Character personaje : personajes) {
            if (name.equals(personaje.getName())) {
                return personaje;
            }
        }
        return null;
    }
}
