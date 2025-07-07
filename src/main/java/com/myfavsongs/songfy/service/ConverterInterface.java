package com.myfavsongs.songfy.service;

import com.fasterxml.jackson.core.type.TypeReference;

import java.util.List;

public interface ConverterInterface {
    <T> T getData(String json, Class<T> cls);
    <T> List<T> getDataList(String json, TypeReference<List<T>> typeRef);
}
