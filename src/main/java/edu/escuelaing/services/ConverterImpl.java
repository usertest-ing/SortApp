package edu.escuelaing.services;

import edu.escuelaing.Sort.BubbleSort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConverterImpl implements Converter {

    public List<Double> getStringConvertedToList(String data){
        String[] dataSeparatedByAComa = data.split(",");
        List<Double> numbers = new ArrayList<>();
        for(String x : dataSeparatedByAComa){
            numbers.add(Double.parseDouble(x));
        }

        return numbers;
    }

    public List<Double> getListSorted(List<Double> numbers){
        BubbleSort<Double> bubblesorter = new BubbleSort<>();
        Double[] numbersToArray = new Double[numbers.size()];
        for (int i = 0; i < numbersToArray.length; i++) {
            numbersToArray[i] = numbers.get(i);
        }
        List<Double> numbersSorted = Arrays.asList(bubblesorter.bubbleSort(numbersToArray));
        return numbersSorted;
    }

    public Double getSumOfAList(List<Double> numbers){
        Double sum = 0.0;
        for(Double number : numbers){
            sum = sum + number;
        }
        return sum;
    }

    public Double getAverageOfAList(List<Double> numbers){
        Double average = getSumOfAList(numbers)/numbers.size();
        return average;
    }
}
