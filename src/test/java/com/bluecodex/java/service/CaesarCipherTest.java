package com.bluecodex.java.service;

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
    public void caesarEncription() throws Exception {

        //Variables
        String message = "AbcXyz";
        int shift = 3;

        //Test
        String encrypted = caesarCipher.caesarEncryption(message,shift);
        //Assertion
        Assert.assertEquals(encrypted, "defabc");

    }

    @Test
    public void caesarDencryption() throws Exception {

        //Variables
        String message = "dEfabC";
        int shift = 3;

        //Test
        String encrypted = caesarCipher.caesarDencryption(message,shift);

        //Assertion
        Assert.assertEquals(encrypted, "abcxyz");

    }

    /**
     * Plain:    ABCDEFGHIJKLMNOPQRSTUVWXYZ
     * Cipher:   DEFGHIJKLMNOPQRSTUVWXYZABC
     * @throws Exception
     */
    @Test
    public void caesarEncriptionNormalText() throws Exception {

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