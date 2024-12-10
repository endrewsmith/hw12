package org.example;


import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public class HomeWork {

    /**
     * <h1>Задание 1.</h1>
     * Решить задачу https://codeforces.com/problemset/problem/1324/C
     */
    @SneakyThrows
    public void frogSteps(InputStream in, OutputStream out) {
        // По традиции проверим входные параметры
        if (in == null) {
            throw new IllegalArgumentException("Входящий поток не может быть null");
        }
        if (out == null) {
            throw new IllegalArgumentException("Выходящий поток не может быть null");
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(in));

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; ++i) {
            String data = br.readLine();
            out.write(String.valueOf(min(data)).getBytes());
            // В одной idea на одном ПК требовал \r, на другом нет,
            // оставил, но если не проходит тест, то можно убрать, тогда пройдет
            out.write(("\r\n").getBytes());
        }
    }

    private int min(String s) {
        int length = s.length();
        List<Integer> position = new ArrayList<>();
        position.add(0);
        for (int i = 0; i < length; i++) {
            if (s.charAt(i) == 'R') {
                position.add(i + 1);
            }
        }
        position.add(length + 1);
        int m = 0;
        for (int i = 0; i < position.size() - 1; i++) {
            m = Math.max(m, position.get(i + 1) - position.get(i));
        }
        return m;
    }
}

