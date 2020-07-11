package com.demo.core.util;

import com.demo.core.exception.ServerInnerException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;

/**
 * 输出转换工具类
 *
 * @author liuyiling
 * @date on 2018/7/7
 */
@Component
public class JsonUtil {

    @Autowired
    public ObjectMapper objectMapper;

    public static ObjectMapper staticObjectMapper;

    /**
     * 静态变量注入Bean的方式
     */
    @PostConstruct
    public void init(){
        staticObjectMapper = objectMapper;
    }

    public static String parseObject2String(Object object) {
        try {
            return staticObjectMapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            throw new ServerInnerException(object, "json转换失败", e);
        }
    }

    public static <T> T parseString2Object(String objStr, TypeReference<T> type) {
        try {
            return (T) staticObjectMapper.readValue(objStr, type);
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public static String parseJsonNode2String(JsonNode jsonNode) throws JsonProcessingException {
        return staticObjectMapper.writeValueAsString(jsonNode);
    }

    public static JsonNode parseString2JsonNode(String jsonStr) throws IOException {
        JsonNode jsonNode = staticObjectMapper.readTree(jsonStr);
        return jsonNode;
    }
}
