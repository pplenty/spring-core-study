package com.jason.springcorestudy.learning;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * Created by yusik on 2020/04/22.
 */
public class HashMapLearningStudy {

    private static final int MAXIMUM_CAPACITY = 1 << 30;

    @DisplayName("hashCode vs System hashCode")
    @Test
    void hashCodeAndSystemHashCode() {
        Key key1 = new Key(1, "test");
        Key key2 = new Key(1, "test");
        System.out.println("동일하지 않고 동등한 두 객체");
        System.out.println("key1 == key2 : " + (key1 == key2));
        System.out.println("key1.equals(key2) : " + (key1.equals(key2)));

        System.out.println("\n해시코드 비교");
        System.out.println("key1.hashCode() : " + key1.hashCode());
        System.out.println("key2.hashCode() : " + key2.hashCode());

        System.out.println("\n시스템 해시코드 비교");
        System.out.println("System.identityHashCode(key1) : " + System.identityHashCode(key1));
        System.out.println("System.identityHashCode(key2) : " + System.identityHashCode(key2));
    }

    @DisplayName("동시성 테스트")
    @Test
    void concurrency() {

        // given
        ConcurrentMap<Key, String> map = new ConcurrentHashMap<>(3);

        // when
        for (int i = 0; i < 100; i++) {
            map.put(new Key(i, String.valueOf(i)), "dummy-" + i);
        }

        // then
        System.out.println(map.size());
    }

    @DisplayName("테이블 사이즈")
    @Test
    void testTableSizeFor() {

        System.out.println("해시 배열 크기");
        System.out.println("tableSizeFor(1) : " + tableSizeFor(1));
        System.out.println("tableSizeFor(2) : " + tableSizeFor(2));
        System.out.println("tableSizeFor(3) : " + tableSizeFor(3));
        System.out.println("tableSizeFor(4) : " + tableSizeFor(4));
        System.out.println("tableSizeFor(5) : " + tableSizeFor(5));
        System.out.println("tableSizeFor(8) : " + tableSizeFor(8));
        System.out.println("tableSizeFor(9) : " + tableSizeFor(9));
        System.out.println("tableSizeFor(63) : " + tableSizeFor(63));
        System.out.println("tableSizeFor(157) : " + tableSizeFor(157));
        System.out.println("tableSizeFor(256) : " + tableSizeFor(256));
        System.out.println("tableSizeFor(257) : " + tableSizeFor(257));
        System.out.println("tableSizeFor(258) : " + tableSizeFor(258));
    }

    private static int tableSizeFor(int c) {
        int n = c - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }

    @EqualsAndHashCode
    @AllArgsConstructor
    static class Key {
        int id;
        String nick;
    }
}
