package com.fipe.fipe.service;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

public interface IConvertData {
    <T> T getDatas(String json, Class<T> tClass);

    <T> List<T> obterLista(String json, Class<T> classe);
}

