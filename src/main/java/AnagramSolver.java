import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class AnagramSolver {

    public static String[] readFile(String filename) throws IOException {
        List<String> listOfStrings = new ArrayList<String>();
        BufferedReader bf = new BufferedReader(
                new FileReader(filename));
        String line = bf.readLine();
        while (line != null) {
            listOfStrings.add(line);
            line = bf.readLine();
        }
        bf.close();
        return listOfStrings.toArray(new String[0]);
    }

    private AnagramSolver() {
    }

    ;

    /**
     * Input: name of text file (containing English words).
     * Output: a hashmap of lists of words that are anagrams.
     *
     * @param filename
     * @return
     */
    public static HashMap<String, ArrayList<String>> anagrams(String filename) throws IOException {
        String[] words = readFile(filename);
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        ArrayList<String> emptyKeys = new ArrayList<>();

        for (String word : words) {

            String key = bubbleSortString(word);

            if (map.get(key) != null) {
                ArrayList<String> tempArr = map.get(key);
                if (tempArr.size() == 1) {
                    emptyKeys.remove(key);
                }
                tempArr.add(word);
                map.put(key, tempArr);

            }
            else {
                ArrayList<String> tempArr = new ArrayList<>();
                tempArr.add(word);
                map.put(key, tempArr);
                emptyKeys.add(key);
            }
        }
        for (String emptyKey : emptyKeys) {
            map.remove(emptyKey);
        }

        return map;
    }

    public static String bubbleSortString(String s){
        char[] arr = s.toCharArray();
        int size = arr.length;
        boolean swapped;

        for(int j = 0; j< size-1; j++){
            swapped = false;
        for(int i = 0; i<size-1-j; i++) {
            if (arr[i] > arr[i + 1]) {
                char temp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = temp;
                swapped = true;
            }
        }
            if(!swapped){
                break;
            }
        }
        return new String(arr);
    }
    /**
     * Input: hashmap of lists of words that are anagrams.
     * Output: largest list of words in hashmap that are anagrams.
     *
     * @param anagrams
     * @return
     */
    public static ArrayList<String> mostFrequentAnagram(HashMap<String, ArrayList<String>> anagrams) {
        ArrayList<ArrayList<String>> listToCompare = new ArrayList<>(anagrams.values());
        ArrayList<String> largest = listToCompare.getFirst();

        for(int i = 0; i<listToCompare.size(); i++){
            ArrayList<String> currentList = listToCompare.get(i);

            if(largest.size() < currentList.size()){
                largest = currentList;
            }
        }
        return largest;
    }

    /**
     * Input: hashmap of lists of words that are anagrams.
     * Output: prints all key value pairs in the hashmap.
     *
     * @param anagrams
     */
    public static void printKeyValuePairs(HashMap<String, ArrayList<String>> anagrams) {
        for(Map.Entry<String, ArrayList<String>> entry : anagrams.entrySet()){
            System.out.println("Key: " + entry.getKey());
            for(String s: entry.getValue()){
                System.out.println("Anagram values: " + s);
            }
        }
    }
}
