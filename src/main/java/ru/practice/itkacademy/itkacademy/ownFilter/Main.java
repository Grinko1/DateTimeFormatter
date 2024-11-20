package ru.practice.itkacademy.itkacademy.ownFilter;



/*Напишите метод filter, который принимает на вход массив любого типа, вторым арументом метод должен принимать клас, реализующий интерфейс Filter, в котором один метод - Object apply(Object o).
Метод должен быть реализован так чтобы возращать новый масив, к каждому элементу которого была применена функция apply*/


import ru.practice.itkacademy.itkacademy.ownFilter.customFilters.Filter;
import ru.practice.itkacademy.itkacademy.ownFilter.customFilters.IntegerOverZeroFilter;
import ru.practice.itkacademy.itkacademy.ownFilter.customFilters.StringLengthOverTwoSymbolsFilter;

import java.util.Arrays;

import static ru.practice.itkacademy.itkacademy.ownFilter.utils.ArrayUtils.filter;

public class Main {
    public static void main(String[] args) {

        Filter stringFilter = new StringLengthOverTwoSymbolsFilter();
        Filter intFilter = new IntegerOverZeroFilter();


        Object[] arrayStr = {"one", "two", "three", "a", "bb"};
        Object[] arrayInt = {-12, -100,0, 12, 4, 5};

        Object[] filteredArray = filter(arrayStr, stringFilter);
        Object[] filteredArray2 = filter(arrayInt, intFilter);


        System.out.println(Arrays.toString(filteredArray));
        System.out.println(Arrays.toString(filteredArray2));
    }
}