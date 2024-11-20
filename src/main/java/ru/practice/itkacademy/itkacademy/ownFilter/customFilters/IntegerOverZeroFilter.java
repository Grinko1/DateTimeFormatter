package ru.practice.itkacademy.itkacademy.ownFilter.customFilters;


public class IntegerOverZeroFilter implements Filter {
    @Override
    public Object apply(Object o) {
        if (o instanceof Integer) {
            if ((Integer) o > 0) {
                return o;
            }
        }
        return null;
    }
}

