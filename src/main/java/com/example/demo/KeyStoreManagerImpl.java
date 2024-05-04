package com.example.demo;

import org.apache.commons.lang3.tuple.ImmutablePair;

import java.util.*;

//Question - {"bootcamp": {"title": "anmol","age": 24}, "str2": {"empCode": "34","title": "anmol"}}
public class KeyStoreManagerImpl implements KeyStoreManager {
    private TreeMap<String, Set<Document>> documentIndex; // attribute name -> list of documents

    private Map<String,Document> map; //contains key and document

    static class Document {
        private String key;
        private Object value;

        public Document(String key, Object value) {
            this.key = key;
            this.value = value;
        }

        public String getKey() {
            return key;
        }

        public Object getValue() {
            return value;
        }

        public String toString(){
            return this.key + ":" + this.value;
        }
    }

    public KeyStoreManagerImpl(){
        documentIndex = new TreeMap<>();
        map = new HashMap<>();
    }



    @Override
    public Object get(String key) {
      if(map.containsKey(key)){
          return  map.get(key).toString();
      }
      return null;
    }

    @Override
    public Object search(String attributeKey, String attributeValue) {
        List<Object> resultSet = new ArrayList<>();
        if(documentIndex.containsKey(attributeKey)){
            Set<Document> documentSet = documentIndex.get(attributeKey);
            Iterator it = documentSet.iterator();
            while(it.hasNext()){
                Document document = (Document) it.next();
                resultSet.add(document.getValue());
            }
        }
        return resultSet;
    }

    @Override
    public void put(String key, List<ImmutablePair<String, String>> listOfAttributePairs) {
        Document document = new Document(key,listOfAttributePairs);
      map.put(key,document);
      for(ImmutablePair<String,String> pair : listOfAttributePairs){
          Set<Document> documentSet = documentIndex.get(pair.getKey());

          if(documentSet == null){
              documentSet = new HashSet<>();
          }
          documentSet.add(document);
          documentIndex.put(pair.getKey(),documentSet);
      }
    }

    @Override
    public void delete(String key) {
      return;
    }

    @Override
    public Set<String> keys() {
        return map.keySet();
    }
}
