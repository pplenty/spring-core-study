package com.jason.springcorestudy;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;


/**
 * Created by kohyusik on 13/11/2019.
 */
@Slf4j
public class OptionalStudyTest {

    @Test
    public void ofNullable() {
        Map<String, Map<String, String>> map = new HashMap<>();
        Map<String, String> subMap = new HashMap<>();
        subMap.put("1sub", "1value");
        map.put("1", subMap);

        String value = Optional.ofNullable(map)
                .map(parentMap -> parentMap.get("1"))
                .map(childMap -> childMap.get("2sub"))// null
                .orElse("null");

        log.debug("{}", value);
        assertThat(value, is("null"));

        String value2 = Optional.ofNullable(map)
                .map(parentMap -> parentMap.get("2"))//null
                .map(childMap -> childMap.get("2sub"))
                .orElse("null");

        log.debug("{}", value2);
        assertThat(value2, is("null"));
    }

    @Test
    public void sort() {
        List<Integer> scores = Arrays.asList(1, 6, 4, 3, 8, 9, 0, 1, 2, 4, 56, -1);

        List<Integer> sortedScore = scores.stream()
                .sorted(Comparator.comparingInt(Object::hashCode))
                .collect(Collectors.toList());

        log.debug("{}", sortedScore);
        assertThat(sortedScore.get(0), is(-1));

        List<Integer> reversedScore = scores.stream()
                .sorted(Comparator.comparingInt(Object::hashCode).reversed())
                .collect(Collectors.toList());

        log.debug("{}", reversedScore);
        assertThat(reversedScore.get(sortedScore.size() - 1), is(-1));
    }
}
