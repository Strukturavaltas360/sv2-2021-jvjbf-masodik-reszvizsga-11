package algorithms;

import java.util.ArrayList;
import java.util.List;


public class Words {
    private List<String> words = new ArrayList<>();
    private static final String HUNGARIAN_ALPHABET = "aábcdeéfghiíjklmnoóöőpqrstuúüűvwxyz";


    private boolean hasSpace(String word) {
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == ' ') {
                throw new IllegalArgumentException("It should be one word!");
            }
        }
        return false;
    }

    private boolean hasSmallCaseLetters(String word) {
        for (int i = 0; i < word.length(); i++) {
            String s = String.valueOf(word.charAt(i));
            if (!HUNGARIAN_ALPHABET.contains(s)) {
                throw new IllegalArgumentException("Word should be lower case!");
            }
        }
        return false;
    }


    public void addWord(String word) {

            if (!hasSpace(word) && !hasSmallCaseLetters(word)) {
                words.add(word);
            }
        }

    public boolean isThereAWordTwice() {
        for (int i = 0; i < words.size() - 1; i++) {
            for (int j = i + 2; j < words.size(); j++) {
                if (words.get(i).equals(words.get(j))) {
                    return true;
                }
            }
        }
        return false;
    }

    public List<String> getWords() {
        return words;
    }
}



