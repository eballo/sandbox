package com.bluecodex.java.service;

/**
 * CaesarCipher Class
 * <p>
 * In cryptography, a Caesar cipher, also known as Caesar's cipher, the shift cipher,
 * Caesar's code or Caesar shift, is one of the simplest and most widely known encryption techniques.
 * It is a type of substitution cipher in which each letter in the plaintext is replaced by a letter
 * some fixed number of positions down the alphabet. For example, with a left shift of 3, D would be
 * replaced by A, E would become B, and so on. The method is named after Julius Caesar, who used it
 * in his private correspondence.[1]
 *
 * @link https://en.wikipedia.org/wiki/Caesar_cipher
 * <p>
 * <p>
 * <p>
 * <p>
 * ASCII table:
 * <p>
 * Decimal  ASCII      Hex
 * 0        control    0
 * 1        control    1
 * 2        control    2
 * 3        control    3
 * 4        control    4
 * 5        control    5
 * 6        control    6
 * 7        control    7
 * 8        control    8
 * 9        \t         9
 * 10       \n         a
 * 11       whitespace b
 * 12       \f         c
 * 13       \r         d
 * 14       control    e
 * 15       control    f
 * 16       control    10
 * 17       control    11
 * 18       control    12
 * 19       control    13
 * 20       control    14
 * 21       control    15
 * 22       control    16
 * 23       control    17
 * 24       control    18
 * 25       control    19
 * 26       control    1a
 * 27       control    1b
 * 28       whitespace 1c
 * 29       whitespace 1d
 * 30       whitespace 1e
 * 31       whitespace 1f
 * 32       space      20
 * 33       !          21
 * 34       "          22
 * 35       #          23
 * 36       $          24
 * 37       %          25
 * 38       &          26
 * 39       '          27
 * 40       (          28
 * 41       )          29
 * 42       *          2a
 * 43       +          2b
 * 44       ,          2c
 * 45       -          2d
 * 46       .          2e
 * 47       /          2f
 * 48       0          30
 * 49       1          31
 * 50       2          32
 * 51       3          33
 * 52       4          34
 * 53       5          35
 * 54       6          36
 * 55       7          37
 * 56       8          38
 * 57       9          39
 * 58       :          3a
 * 59       ;          3b
 * 60       <          3c
 * 61       =          3d
 * 62       >          3e
 * 63       ?          3f
 * 64       @          40
 * 65       A          41
 * 66       B          42
 * 67       C          43
 * 68       D          44
 * 69       E          45
 * 70       F          46
 * 71       G          47
 * 72       H          48
 * 73       I          49
 * 74       J          4a
 * 75       K          4b
 * 76       L          4c
 * 77       M          4d
 * 78       N          4e
 * 79       O          4f
 * 80       P          50
 * 81       Q          51
 * 82       R          52
 * 83       .          53
 * 84       .          54
 * 85       .          55
 * 86       .          56
 * 87       .          57
 * 88       .          58
 * 89       .          59
 * 90       Z          5a
 * 91       [          5b
 * 92       \          5c
 * 93       ]          5d
 * 94       ^          5e
 * 95       _          5f
 * 96       `          60
 * 97       a          61
 * 98       b          62
 * 99       c          63
 * 100      d          64
 * 101      e          65
 * 102      f          66
 * 103      g          67
 * 104      h          68
 * 105      i          69
 * 106      j          6a
 * 107      k          6b
 * 108      l          6c
 * 109      m          6d
 * 110      n          6e
 * 111      o          6f
 * 112      p          70
 * 113      q          71
 * 114      r          72
 * 115      s          73
 * 116      t          74
 * 117      u          75
 * 118      v          76
 * 119      w          77
 * 120      x          78
 * 121      y          79
 * 122      z          7a
 * 123      {          7b
 * 124      |          7c
 * 125      }          7d
 * 126      ~          7e
 * 127      control    7f
 */
public class CaesarCipher implements ICipher {

    /**
     * Caesar Cipher Encryption
     * <p>
     * Change chars to ASCII numbers, then you can increase the value,
     * then revert it back to the new character.
     * <p>
     * Example: A B C D E F G H I
     * text: ABC, 3 -> DEF
     *
     * @param message text to encrypt
     * @param shift   the shift value
     * @return an encrypted text
     */
    protected String caesarEncryption(String message, int shift) {

        String encryptedString = "";
        int len = message.length();
        String lowerCaseMessage = message.toLowerCase();

        for (int x = 0; x < len; x++) {

            char c = (char) (lowerCaseMessage.charAt(x) + shift);
            System.out.println((lowerCaseMessage.charAt(x)));

            if (c > 'z') {
                encryptedString += (char) ((lowerCaseMessage.charAt(x) + (shift - 26)));
            } else if ( c < 'a') {
                encryptedString += (char) (lowerCaseMessage.charAt(x) + (shift + 26));
            }else{
                encryptedString += (char) (lowerCaseMessage.charAt(x) + shift);
            }

        }
        return encryptedString;
    }

    /**
     * Caesar Cipher Decription
     * <p>
     * Example: A B C D E F G H I
     * text: DEF, 3 -> ABC
     *
     * @param message text to encrypt
     * @param shift   the shift value used to encrypt
     * @return a decrypted text
     */
    protected String caesarDencryption(String message, int shift) {
        return caesarEncryption(message, -shift);
    }

    /**
     * Caesar encrypt Implementation
     *
     * @param message the plain message to be encrypted
     * @return
     */
    public String encrypt(String message) {
        return caesarEncryption(message, 3);
    }

    /**
     * Caesar decrypt Implementation
     *
     * @param message the encrypted message to be decrypted
     * @return
     */
    public String decrypt(String message) {
        return caesarDencryption(message, 3);
    }
}
