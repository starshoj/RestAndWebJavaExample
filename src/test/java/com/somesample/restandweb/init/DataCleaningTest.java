package com.somesample.restandweb.init;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
public class DataCleaningTest {

    @Test
    public void testNoChangesWithoutBrackets(){
        String str = "Abc";
        assertEquals(WikiLoader.cleanValue(str), str);
        String str2 = "Qwe[";
        assertEquals(WikiLoader.cleanValue(str2), str2);
    }

    @Test
    public void testBracketsContentRemoved(){
        String str = "Abc[8]";
        String str2 = "Abc";
        assertEquals(WikiLoader.cleanValue(str), str2);
    }
}
