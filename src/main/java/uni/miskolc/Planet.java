package uni.miskolc;

import java.util.*;

public class Planet {
    private final int width;
    private final int height;
    private final Map<Integer, Set<Integer>> obstacles;

    public Planet(int width, int height, List<int[]> obstacleCoordinates) {
        this.width = width;
        this.height = height;
        this.obstacles = new HashMap<>();

        // Feltöltjük a Map-ünket az akadályok listájából
        for (int[] coord : obstacleCoordinates) {
            int x = coord[0];
            int y = coord[1];

            // A computeIfAbsent egy modern Java 8+ funkció.
            // Jelentése: "Nézd meg az 'x' kulcsot. Ha nem létezik,
            // hozz létre neki egy új HashSet-et (k -> new HashSet<>()),
            // majd add hozzá 'y'-t."
            this.obstacles.computeIfAbsent(x, k -> new HashSet<>()).add(y);
        }
    }

    // Üres bolygó konstruktora
    public Planet(int width, int height) {
        this(width, height, List.of()); // Üres akadály listát ad át
    }

    /**
     * Elvégzi a koordináták "körbetekerését" a bolygó méretei alapján.
     * @return Egy int[2] tömböt ad vissza a [wrappedX, wrappedY] értékekkel.
     */
    public int[] wrap(int x, int y) {
        // A negatív modulo kezelése
        int wrappedX = (x % width + width) % width;
        int wrappedY = (y % height + height) % height;
        return new int[]{wrappedX, wrappedY};
    }

    /**
     * Ellenőrzi, hogy a megadott (x, y) koordinátán van-e akadály.
     */
    public boolean hasObstacleAt(int x, int y) {
        // A getOrDefault egy Java 8+ funkció.
        // Jelentése: "Kérd le az 'x' kulcshoz tartozó Set-et.
        // Ha nincs 'x' kulcs, adj vissza egy üres Set-et (Set.of())."
        // Ezután ezen a (valódi vagy üres) Set-en hívjuk a contains(y)-t.
        // Ez sokkal tisztább, mint null-ellenőrzést végezni.
        return this.obstacles.getOrDefault(x, Set.of()).contains(y);
    }
}
