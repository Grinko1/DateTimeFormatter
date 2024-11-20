package ru.practice.itkacademy.itkacademy.ownFilter.utils;


import ru.practice.itkacademy.itkacademy.ownFilter.customFilters.Filter;

import java.util.Arrays;
import java.util.Objects;


public class ArrayUtils {
    public static Object[] filter(Object[] array, Filter filter) {
        return Arrays.stream(array)
                .map(filter::apply)
                .filter(Objects::nonNull)
                .toArray();
    }

}
