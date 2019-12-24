/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ttg;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 *
 * @author suat_
 * @date 24.12.2019
 */
public class Main {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        Integer[] arrayOne = {4, 12, 9, 5, 6, 1};
        Integer[] arrayTwo = {4, 9, 12, 6};

        System.out.println(findMissing(arrayOne, arrayTwo));

        Integer[] arrayThree = {1, 2, 3, 4, 5, 6};
        System.out.println(Arrays.toString(rotate(arrayThree, 1)));
        bankAccounts();
    }
    /**
     * 
     * @param arrayOne One array 
     * @param arrayTwo two array
     * @return array have different elemets
     */
    public static ArrayList<Integer> findMissing(Integer[] arrayOne, Integer[] arrayTwo) {
        ArrayList<Integer> temp = new ArrayList<>();

        Set<Integer> setTemp = new HashSet<>(Arrays.asList(arrayTwo));
        for (int num : arrayOne) {
            if (!setTemp.contains(num)) {
                temp.add(num);
            }
        }

        return temp;
    }
    /**
     * 
     * @param arrayThree input array
     * @param n rotate count
     * @return result arrray
     */
    private static Integer[] rotate(Integer[] arrayThree, int n) {
        Integer[] result = new Integer[arrayThree.length];
        for (int i = 0; i < arrayThree.length; i++) {
            result[(i + (arrayThree.length - n)) % arrayThree.length] = arrayThree[i];
        }

        return result;

    }
    /*
    * Sample content was tried. the method gets using from file after 
    * the methot will make sorting. 26 meaning  2 control digits, an 8-digit code of the bank, 
    * 16 digits user id
    */
    public static void bankAccounts() throws FileNotFoundException, IOException {

        List<String> valueList = new ArrayList<>();

        Path fr = Paths.get("C:\\test.txt");
        valueList = Files.readAllLines(fr);

        Map<String, Integer> map = new TreeMap<>();
        for (String temp : valueList) {
            if (temp.length() >= 26) {

                String value = temp;

                if (!map.containsKey(value)) {
                    map.put(value, 0);
                }

                map.put(value, map.get(value) + 1);

            } else {
                printMap(map);
                map.clear();
                System.out.println("");

            }

        }
        printMap(map);

    }

    private static void printMap(Map<String, Integer> map) {
        map.entrySet().forEach((entry) -> {
            System.out.println(entry.getKey() + " " + entry.getValue());
        });
    }
}
