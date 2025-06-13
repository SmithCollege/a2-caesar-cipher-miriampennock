/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package a1template;

import org.junit.Test;
import static org.junit.Assert.*;

public class CaesarCipherTests {
    @Test 
    public void findIndexTest() {
        // offset shouldn't affect the results here
        CaesarCipher classUnderTest = new CaesarCipher(0);
        assertEquals(0,classUnderTest.findIndex('a'));
        assertEquals(12,classUnderTest.findIndex('m'));
        assertEquals(25,classUnderTest.findIndex('z'));
    }

    @Test
    public void setupTest(){
        CaesarCipher classUnderTest = new CaesarCipher(3);
        assertEquals('o',classUnderTest.get(17));
        assertEquals('a',classUnderTest.get(3));
        assertEquals('w',classUnderTest.get(25));
        assertEquals('x',classUnderTest.get(0));

        classUnderTest = new CaesarCipher(13);
        assertEquals('w',classUnderTest.get(9));
        assertEquals('a',classUnderTest.get(13));
    }

    @Test
    public void encodeTest(){
        CaesarCipher classUnderTest = new CaesarCipher(8);
        assertEquals("lzak ak s kwujwl ewkksyw", classUnderTest.encode("this is a secret message"));
        
        classUnderTest = new CaesarCipher(3);
        assertEquals("qefp fpk'q sbov pbzobq.", classUnderTest.encode("this isn't very secret."));
    }

    @Test
    public void decodeTest(){
        CaesarCipher classUnderTest = new CaesarCipher(8);
        assertEquals("this is a secret message", classUnderTest.decode("lzak ak s kwujwl ewkksyw"));
        
        classUnderTest = new CaesarCipher(3);
        assertEquals("this isn't very secret.", classUnderTest.decode("qefp fpk'q sbov pbzobq."));

    }


}