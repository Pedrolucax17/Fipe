package com.fipe.fipe.service;

import com.fasterxml.jackson.databind.ObjectMapper;

public interface IConvertData {
    <T> T getDatas(String json, Class<T> tClass);
}
