package com.example.demo.customannotation;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class ObjectToJsonConverter {

    public String convertToJson(Object object) throws InvocationTargetException, IllegalAccessException {
        try {
            checkIfSerializable(object);
            initializeObject(object);
            return getJsonString(object);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private void checkIfSerializable(Object object){
        if(object == null)
            throw new JsonSerializationException("can't serialize null object");
        Class<?> clazz = object.getClass();
        if(!clazz.isAnnotationPresent(JsonSerializable.class))
            throw new JsonSerializationException("Object with class: " + clazz.getSimpleName() + "is not annotated with jsonserializable");

    }

    private void initializeObject(Object object) throws InvocationTargetException, IllegalAccessException {
        Class<?> clazz = object.getClass();
        for(Method method : clazz.getDeclaredMethods()){
            if(method.isAnnotationPresent(Init.class)){
                method.setAccessible(true);
                method.invoke(object);
            }
        }
    }

    private String getJsonString(Object object) throws IllegalAccessException {
        Class<?> clazz = object.getClass();
        Map<String,String> jsonElement = new HashMap<>();
        for(Field field : clazz.getDeclaredFields()){
            field.setAccessible(true);
            if(field.isAnnotationPresent(JsonElement.class)){
                jsonElement.put(getKey(field),(String) field.get(object));
            }
        }

        String jsonString = jsonElement.entrySet()
                .stream()
                .map(entry -> "\"" + entry.getKey() + "\":\"" + entry.getValue() + "\"")
                .collect(Collectors.joining(","));
        return "{" + jsonString + "}";
    }

    private String getKey(Field field){
        String value = field.getAnnotation(JsonElement.class).key();
        return value.isEmpty() ? field.getName() : value;
    }
}
