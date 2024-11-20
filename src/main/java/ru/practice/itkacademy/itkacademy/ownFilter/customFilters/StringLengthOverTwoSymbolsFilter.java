package ru.practice.itkacademy.itkacademy.ownFilter.customFilters;

public class StringLengthOverTwoSymbolsFilter implements Filter {

    @Override
    public Object apply(Object o) {
        if (o instanceof String) {
            if (((String) o).length() > 2){
                return o;
            }
        }
        return null;
    }
}
