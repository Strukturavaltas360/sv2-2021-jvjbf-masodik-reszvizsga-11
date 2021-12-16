package algorithms;

import java.util.ArrayList;
import java.util.List;

public class Sentences {
    List<String> sentences = new ArrayList<>();

    public void addSentence(String sentence) {
        if (isFirstLetterCapital(sentence.charAt(0)) && isLastCharacterPunctuation(sentence.charAt(sentence.length() - 1))) {
            sentences.add(sentence);
        }
    }

    private boolean isLastCharacterPunctuation(Character c) {
        String punctuations = ".!?";
        if (punctuations.contains(String.valueOf(c))) {
            return true;
        } else {
            throw new IllegalArgumentException("Sentence must end with ending mark!");
        }
    }

    private boolean isFirstLetterCapital(Character c) {
        if (Character.toUpperCase(c) == c) {
            return true;
        } else {
            throw new IllegalArgumentException("Sentence must start with capital!");
        }
    }

    public String findLongestSentence() {
        isListempty();
        String longest = "";
        for (String actual : sentences) {
            if (actual.length() > longest.length()) {
                longest = actual;
            }
        }
        return longest;
    }

    private void isListempty() {
        if (sentences.size() == 0) {
            throw new IllegalStateException("List is empty!");
        }
    }

    public List<String> getSentences() {
        return sentences;
    }
}
