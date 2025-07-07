package com.myfavsongs.songfy.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Converter implements ConverterInterface {
    private ObjectMapper mapper = new ObjectMapper();
    @Override
    public <T> T getData(String json, Class<T> cls) {
        try {
            return mapper.readValue(json, cls);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
