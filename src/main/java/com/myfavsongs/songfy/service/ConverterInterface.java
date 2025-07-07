package com.myfavsongs.songfy.service;

public interface ConverterInterface {
    <T> T getData(String json, Class<T> cls);
}
