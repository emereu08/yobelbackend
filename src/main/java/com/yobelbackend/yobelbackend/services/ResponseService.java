package com.yobelbackend.yobelbackend.services;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.yobelbackend.yobelbackend.models.Character;
import lombok.Getter;

@Getter
public class ResponseService {
    private int code = -1;

    private final Character body;

    public ResponseService(final int code, final Character body) {
        this.code = code;
        this.body = body;
    }

}
