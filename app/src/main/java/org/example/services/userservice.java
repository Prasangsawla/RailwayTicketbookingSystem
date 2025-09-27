package org.example.services;

import com.fasterxml.jackson.core.type.TypeReference;
import org.example.entities.user;
import org.example.util.Jsonutil;
import org.example.util.PasswordUtil;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class userservice {
    private static final File USER_DB = new File("localdb/users/users.json");
    private List<user> users;

    public userservice() {
        this.users = Jsonutil.read(USER_DB, new TypeReference<List<user>>() {}, new ArrayList<>());
    }

    public user signUp(String name, String rawPassword, String newUserId) {
        String hashed = PasswordUtil.hash(rawPassword);
        user u = new user(newUserId, name, hashed);
        users.add(u);
        persist();
        return u;
    }

    public Optional<user> login(String name, String rawPassword) {
        return users.stream()
                .filter(u -> u.getName().equalsIgnoreCase(name) && PasswordUtil.check(rawPassword, u.getHashedPassword()))
                .findFirst();
    }

    public void update(user user) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getUserId().equals(user.getUserId())) {
                users.set(i, user);
                persist();
                return;
            }
        }
        // not found? add
        users.add(user);
        persist();
    }

    public void persist() { Jsonutil.write(USER_DB, users); }
}
