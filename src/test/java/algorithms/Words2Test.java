package algorithms;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Words2Test {


    @Test
    void addWordTest(){
        Words2 words = new Words2();

        words.addWords("pear");
        words.addWords("pear","apple");
        words.addWords("pear","apple","pear","cherry");

        assertEquals(7, words.getWords().size());
    }


    @Test
    void findWordsOccursOnceTest(){
        Words2 words = new Words2();

        words.addWords("coconut");
        words.addWords("pear","apple");
        words.addWords("pear","apple","pear","cherry","apple","mango","banana","banana","mango");

        List<String> result = words.findWordsOccursOnes();

        assertEquals(List.of("coconut","cherry"),result);

    }

}