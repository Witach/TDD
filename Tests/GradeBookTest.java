package Tests;

import GradeBook.GradeBook;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GradeBookTest {
    GradeBook marks = new GradeBook("Dawid","Witaszek",215920);
    @Test
    void create(){
        assertAll(()->assertEquals("Dawid",marks.getName()),
                ()->assertEquals("Witaszek",marks.getLastName()),
                        ()->assertEquals(215920,marks.getIndex()));
    }

}