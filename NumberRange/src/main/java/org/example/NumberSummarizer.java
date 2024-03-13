package org.example;

import java.util.*;

public class NumberSummarizer implements NumberRangeSummarizer{
    public static void main(String[] args) {
        NumberSummarizer numberRange = new NumberSummarizer();
        String input = "1,3,6,7,8,12,13,14,15,21,22,23,24,31";
        try {
            Collection<Integer> collectionInput = numberRange.collect(input);
            String range = numberRange.summarizeCollection(collectionInput);
            System.out.println("Your summarized numbers are: "+ range + ". Thank you goodbye");

        } catch (ClassCastException exc) {
            System.out.println("Please check your numbers entered");
        }
    }

    /**
     * @param input
     * @return
     */
    @Override
    public Collection<Integer> collect(String input) {
        String[] convertedRangeArray = input.split(",");
        List<Integer> convertedRangeList = new ArrayList<>();

        for (String number : convertedRangeArray) {
            Collections.sort(convertedRangeList);
            convertedRangeList.add(Integer.parseInt(number.trim()));
        }
        return convertedRangeList;
    }

    /**
     * @param input list of integers
     * @return
     */
    @Override
    public String summarizeCollection(Collection<Integer> input) {
        int count = 0;
        int firstElement; int next;
        StringBuilder sb = new StringBuilder();

        ArrayList<Integer> inputList = new ArrayList<>(input);
        int length = inputList.size();

        for (int num = 0; num < length; num++)
        {
            if (num == length - 1)
            {
                if(inputList.get(length-2) != inputList.get(length-1))
                {
                    sb.append(inputList.get(num) + ",");
                }
                break;
            }

            firstElement = inputList.get(num);
            next = inputList.get(num + 1);
            if (next == firstElement + 1)
            {
                count++;
                int lowestBound = firstElement;
                for (int i = num + 1; ; i++)
                {
                    firstElement = inputList.get(i);
                    next = inputList.get(i + 1);

                    if (next == firstElement + 1)
                    {
                        count++;
                    }
                    else
                    {
                        num = i;
                        if (count != 0)
                        {
                            sb.append(lowestBound + " - " + inputList.get(i) + ", ");
                        }
                        break;
                    }
                }
                count = 0;
            }
            else
            {
                // goes through the ones with no range
                sb.append(firstElement + ", ");
            }
        }
        String ranges = sb.toString();
        return ranges.substring(0, ranges.length() - 1);
    }
}