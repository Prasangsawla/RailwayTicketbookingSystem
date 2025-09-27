package org.example.util;

import org.mindrot.jbcrypt.BCrypt;

public class PasswordUtil {
    public static String hash(String raw) {
        return BCrypt.hashpw(raw, BCrypt.gensalt(10));
    }
    public static boolean check(String raw, String hashed) {
        return BCrypt.checkpw(raw, hashed);
    }
}
