package edu.escuelaing.services;

import java.util.List;

public interface Converter {

    public List<Double> getStringConvertedToList(String data);

    public List<Double> getListSorted(List<Double> numbers);

    public Double getSumOfAList(List<Double> numbers);

    public Double getAverageOfAList(List<Double> numbers);
}
