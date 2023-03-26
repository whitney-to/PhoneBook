package com.zipcodewilmington.phonebook;

import java.util.*;
import java.util.stream.Collectors;
//import java.util.HashMap;


/**
 * Created by leon on 1/23/18.
 * Made WAY better by kristofer 6/16/20
 */
public class PhoneBook {
    private final Map<String, List<String>> phonebook;

    public PhoneBook(Map<String, List<String>> map) {
        this.phonebook = map;
    }

    public PhoneBook() {
        this.phonebook = new HashMap<>();
        //this(new LinkedHashMap<>()) //=> calling the above constructor passing in linked hashmap
    }

    public void add(String name, String phoneNumber) {
        List<String> newNumbers = new ArrayList<>();
        newNumbers.add(phoneNumber);
        this.phonebook.putIfAbsent(name,newNumbers);
    }

    public void addAll(String name, String... phoneNumbers) {
//        if(this.phonebook.containsKey(name)){
//            Arrays.stream(phoneNumbers)
//                    .forEach(num -> this.phonebook.get(name).add(num));
//        } else {
//            List<String> s = new ArrayList<>();
//            Arrays.stream(phoneNumbers)
//                    .forEach(num ->s.add(num));
//            this.phonebook.put(name,s);
//        }
        List<String> newNumbers = new ArrayList<>();
        newNumbers.addAll(List.of(phoneNumbers));
        this.phonebook.putIfAbsent(name,newNumbers);
    }

    public void remove(String name) {
        this.phonebook.remove(name);
    }

    public Boolean hasEntry(String name) {
        return this.phonebook.containsKey(name);
    }

    public List<String> lookup(String name) {
        return this.phonebook.get(name);
    }

    public String reverseLookup(String phoneNumber)  {
        for(Map.Entry<String, List<String>> item : phonebook.entrySet()){
            if(item.getValue().contains(phoneNumber)){
                return item.getKey();
            }
        }
        return "";
    }

    public List<String> getAllContactNames() {
        return new ArrayList<>(this.phonebook.keySet());
    }

    public Map<String, List<String>> getMap() {
        return this.phonebook;
    }
}
