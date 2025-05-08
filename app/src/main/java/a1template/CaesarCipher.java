// Do not change the line below. It lets Gradle find your 
// Classes to build the project
package a1template;

public class CaesarCipher {

    /** Character array to store the letters in the alphabet in order */
    Character[] alphabet = new Character[26];

    /** DynamicArray object providing ArrayList-like operations for Characters */
    DynamicArray<Character> cipher;

    /** Private offset that tracks how many positions to shift the index for
    * This cipher */
    private int offset;

    /** Constructor that should define the instance variables, including
     * populating the alphabet
     * @param offset Offset to use when creating `cipher` of DynamicArray type
     */
    CaesarCipher(int offset){
        this.offset = offset;
        cipher = new DynamicArray<>();

        for (int i = 0; i < 26; i++) {
            alphabet[i] = (char) ('a' + i);
            cipher.add(alphabet[i]);
        }
    }

    /** Implementation of linear search that looks through the alphabet
     * array to identify the position of the passed value
     * @param val character to search for
     * @return int indicating position of val in the alphabet array
     */
    public int findIndex(char val){
        for (int i = 0; i < 26; i++) {
            if (alphabet[i] == val) return i;
        }
        return -1; // Character not found
    }

    /** Encode a message using the cipher
     * @param T message to encode
     * @return encoded message */  
    public String encode(String message){
        StringBuilder encoded = new StringBuilder();

        for (char c : message.toLowerCase().toCharArray()) {
            if (Character.isLetter(c)) {
                int index = findIndex(c);
                encoded.append(cipher.get(index, offset)); // Shifted letter
            } else {
                encoded.append(c); // Non-letter characters remain unchanged
            }
        }

        return encoded.toString();
     }

    /** Decode a message using the cipher 
     * @param String message to decode
     * @param int key to use in decoding
     * @return decoded message
    */
    public String decode(String message){
        StringBuilder decoded = new StringBuilder();

        for (char c : message.toLowerCase().toCharArray()) {
            if (Character.isLetter(c)) {
                int index = findIndex(c);
                decoded.append(cipher.get(index, -offset)); // Reverse shift
            } else {
                decoded.append(c);
            }
        }

        return decoded.toString();
    }

    public static void main(String[] args) {
        CaesarCipher cipher = new CaesarCipher(3);
        String encoded = cipher.encode("hello world");
        String decoded = cipher.decode(encoded);

        System.out.println("Encoded: " + encoded);
        System.out.println("Decoded: " + decoded);

        cipher = new CaesarCipher(25);
        encoded = cipher.encode("Life is so totally crazy");
        decoded = cipher.decode(encoded);

        System.out.println("Encoded: " + encoded);
        System.out.println("Decoded: " + decoded);

    }
    
}
