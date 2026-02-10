package mcon364.las.touro.edu;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MainTest {

    @Test
    void testGetUserName(){
        assertFalse(Main.getUserName("USERNAME").isEmpty());
        assertEquals(System.getenv("USERNAME") , Main.getUserName("USERNAME").get());
        assertTrue(Main.getUserName("NULL").isEmpty());
    }


    @Test
    void testGetGreeting(){
        assertEquals("Hello, Guest!", Main.getGreeting("NOPE_XYZ"));

    }

//    @Test
//    void testProcessValues() {
//        assertEquals(8, Main.processValues(List.of(
//                List.of(5, 10, 15),     // Processes completely
//                List.of(20, 0, 25),     // Finds 0, skips to next list
//                List.of(30, 35, 40),    // Processes completely
//                List.of(45, 99, 50),    // Finds 99, terminates everything
//                List.of(55, 60, 65)     // Never reached
//                )
//        ));
//    }
    @Test
    void processValues_normal() {
        assertEquals(3, Main.processValues(List.of(List.of(1, 2), List.of(3, 4), List.of(5, 6))));
    }

    @Test
    void processValues_1() {
        assertEquals(2, Main.processValues(List.of(List.of(1, 2), List.of(0, 3), List.of(4, 5))));
    }

    @Test
    void processValues_2() {
        assertEquals(1, Main.processValues(List.of(List.of(1, 2), List.of(99, 3), List.of(4, 5))));
    }
}
