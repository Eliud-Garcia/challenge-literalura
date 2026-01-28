package com.alura.literalura.service;

public interface IConvertData {
    <T> T getDataFromJson(String json, Class<T> clase);
}
