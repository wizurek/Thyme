package com.example.Thyme.service;

import com.example.Thyme.model.User;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Service
public class ObslugaSkierowan {

        private Map<Integer, User> userMap = new HashMap<>();

        public User createUser(String lekarz, String pacjent, int wiek ) {

            int id = new Random().nextInt();
            User user = new User (id, lekarz, pacjent, wiek);
            userMap.put(id, user);
            return user;
        }

        public void deleteUser(int id ) {
            userMap.remove(id);
        }

        public Collection<User> listUsers() {
            return userMap.values();
        }
        public User getUser(int id) {
            return userMap.get(id);
        }


    }


