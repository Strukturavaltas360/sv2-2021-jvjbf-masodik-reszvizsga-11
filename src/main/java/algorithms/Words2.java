package algorithms;

import java.util.ArrayList;
import java.util.List;

public class Words2 {
    List<String> words = new ArrayList<>();

    public void addWords(String s, String... word) {
        words.add(s);
        for (int i = 0; i < word.length; i++) {
            words.add(word[i]);
        }
    }

    public List<String> findWordsOccursOnes() {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < words.size(); i++) {
            if (getWordsCount(i) == 1) {
                result.add(words.get(i));
            }
        }
        return result;
    }

    public List<String> getWords() {
        return words;
    }

    private int getWordsCount(int index) {
        int count = 0;
        for (int j = 0; j < words.size(); j++) {
            if (words.get(j).equals(words.get(index))) {
                count++;
            }
        }
        return count;
    }
}