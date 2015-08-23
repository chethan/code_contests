package codewars;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class DnaStrandTest {
    @Test
    public void test01() {
        assertEquals("TTTT", new DnaStrand().makeComplement("AAAA"));
    }
    @Test
    public void test02() {
        assertEquals("TAACG", new DnaStrand().makeComplement("ATTGC"));
    }
    @Test
    public void test03() {
        assertEquals("CATA", new DnaStrand().makeComplement("GTAT"));
    }
}