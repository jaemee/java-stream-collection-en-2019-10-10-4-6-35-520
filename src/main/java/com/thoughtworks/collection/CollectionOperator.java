package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CollectionOperator {
    public List<Integer> getListByInterval(int left, int right) {
        if(left < right){
            return IntStream.rangeClosed(left, right)
                    .boxed()
                    .sorted()
                    .collect(Collectors.toList());
        }
        return IntStream.rangeClosed(right, left)
                .boxed()
                .sorted(Collections.reverseOrder())
                .collect(Collectors.toList());
    }

    public List<Integer> getEvenListByIntervals(int left, int right) {
        if(left < right){
            return IntStream.rangeClosed(left, right)
                    .filter(num -> num%2 == 0)
                    .boxed()
                    .sorted()
                    .collect(Collectors.toList());
        }
        return IntStream.rangeClosed(right, left)
                .filter(num -> num%2 == 0)
                .boxed()
                .sorted(Collections.reverseOrder())
                .collect(Collectors.toList());
    }

    public List<Integer> popEvenElments(int[] array) {
        return Arrays.stream(array)
                .filter(num -> num%2 == 0)
                .boxed()
                .collect(Collectors.toList());
    }

    public int popLastElment(int[] array) {
        throw new NotImplementedException();
    }

    public List<Integer> popCommonElement(int[] firstArray, int[] secondArray) {
        throw new NotImplementedException();
    }

    public List<Integer> addUncommonElement(Integer[] firstArray, Integer[] secondArray) {
        throw new NotImplementedException();
    }
}
