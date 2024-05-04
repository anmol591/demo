package com.example.demo;

import java.util.List;
import java.util.Set;

import org.apache.commons.lang3.tuple.ImmutablePair;

public interface KeyStoreManager {
    Object get(String key);

    Object search(String attributeKey, String attributeValue);

    void put(String key, List<ImmutablePair<String, String>> listOfAttributePairs);

    void delete(String key);

    Set<String> keys();
}
