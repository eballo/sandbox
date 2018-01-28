package com.bluecodex.java.service;

/**
 *
 * Interface for Cipher Implementations
 *
 */
public interface ICipher {

    /**
     * Encrypt a plain message
     * @param message the plain message to be encrypted
     * @return return an encrypted message
     */
    public String encrypt(String message);

    /**
     * Decrypt an encrypted message
     * @param message the encrypted message to be decrypted
     * @return a plain message
     */
    public String decrypt(String message);

}
