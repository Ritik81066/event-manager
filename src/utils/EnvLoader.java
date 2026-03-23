package utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class EnvLoader {

    private static final HashMap<String, String> envMap = new HashMap<>();

    static {
        loadEnv();
    }

    private static void loadEnv() {

        try (BufferedReader br = new BufferedReader(new FileReader(".env"))) {

            String line;

            while ((line = br.readLine()) != null) {

                line = line.trim();

                if (line.isEmpty() || line.startsWith("#")) continue;

                String[] parts = line.split("=", 2);

                if (parts.length == 2) {
                    envMap.put(parts[0].trim(), parts[1].trim());
                }
            }

        } catch (IOException e) {
            System.out.println("Failed to load .env file");
            e.printStackTrace();
        }
    }

    public static String get(String key) {
        return envMap.get(key);
    }
}