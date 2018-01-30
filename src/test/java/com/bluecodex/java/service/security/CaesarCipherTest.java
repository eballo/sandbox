package com.bluecodex.java.service.security;

import com.bluecodex.java.service.security.CaesarCipher;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CaesarCipherTest {

    private CaesarCipher caesarCipher;

    @BeforeMethod
    public void setUp() throws Exception {
        caesarCipher = new CaesarCipher();
    }

    @Test
    public void caesarEncryption() throws Exception {

        //Variables
        String message = "AbcXyz";
        int shift = 3;

        //Test
        String encrypted = caesarCipher.encrypt(message,shift);
        //Assertion
        Assert.assertEquals(encrypted, "defabc");

    }

    @Test
    public void encryptionWith4Shifts() throws Exception {

        //Variables
        String message = "Abcd";
        int shift = 4;

        //Test
        String encrypted = caesarCipher.encrypt(message,shift);
        //Assertion
        Assert.assertEquals(encrypted, "efgh");

    }

    @Test
    public void caesarDencryption() throws Exception {

        //Variables
        String message = "dEfabC";
        int shift = 3;

        //Test
        String encrypted = caesarCipher.encrypt(message,shift);

        //Assertion
        Assert.assertEquals(encrypted, "abcxyz");

    }

    @Test
    public void decryptionWith4Shifts() throws Exception {

        //Variables
        String message = "efgh";
        int shift = 4;

        //Test
        String encrypted = caesarCipher.decrypt(message,shift);
        //Assertion
        Assert.assertEquals(encrypted, "abcd");

    }

    /**
     * Plain:    ABCDEFGHIJKLMNOPQRSTUVWXYZ
     * Cipher:   DEFGHIJKLMNOPQRSTUVWXYZABC
     * @throws Exception
     */
    @Test
    public void caesarEncryptionNormalText() throws Exception {

        //Variables
        String plaintext = "thequickbrownfoxjumpsoverthelazydog";
        String ciphertext = "wkhtxlfneurzqiramxpsvryhuwkhodcbgrj";

        //Test encryption
        String encrypted = caesarCipher.encrypt(plaintext);

        //Asset encryption
        Assert.assertEquals(encrypted,ciphertext);

        //Test decryption
        String decrypted = caesarCipher.decrypt(encrypted);

        //Assertion
        Assert.assertEquals(decrypted, plaintext);

    }
}