package com.zcy.codec_crypto_cipher.aes;

//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;

/**
 * 加密工具测试
 *
 * @author Allen.C.Y.Zhang
 */
class CipherUtilsTest {

    public static final String KEY = "123456";
    public static final String plaintext = "This is 测试 123.";
    public static final String ciphertext = "153376F1C20B473A21E11D5FC26D286E99A7001B2EA248366A988CE814E516DF";
    public static final String plaintext2 = "This-is-长度测试/abc~!@#$%^&*()_+[]{};':<?>/\\|`!!!!!!!aksjdnfjksnadkfnaskjngjkdfaglkjndafjklngabgkjhdbaghjbfaklghjbashjgbhadjfbgjhkbsfagkasbfgljbahfgbuiqewsdafasdgsgfdgdfgsadfsdfsadgsgfdsadgsadgsagdsafgdfagsdgasfdgsdgsdafsdfsadfsadfasdgsadgasdgw234234asdfasdf";
    public static final String ciphertext2 = "5DFD9BDFB805CEC60961EF04F39D14B2AF4633B484E7036CC7B138C71CF7AEF4ED75AF401E9D5A0B200EF7ECA9CFA741FA11A722969356CBCB00E6C7BCA009913B62B0C9152EFC3DED94A73DA3EC69E74D889BADFBD3335F9D658F86CCF8B440CCE39DF12D89394988DFA8529B01968022BD62459C92624AACD8E3F74B7BE2115954190FB609059008FFF8B1AA5C6942C99BDCADA0061F46F262BB0E27F46185F496123291DF4AC17B0E85A33FF574328DEAE362549D9E39E2574CC60D4E31FBB83F98E5CD3D7F1E7A10283C6CB8FF46D54FAA779DAF1F0CDE994D9969C4F18DC65CC4817E0E4530C42F4B6EAA2B0873C9F2A274C75FC6F5B604EB7777C265BFDB4391DC56A8BD25E62D55FB33BB7DF9";


//    @Test
    void aesEncrypt() {
        // 准确性验证1
        String result = CipherUtils.aesEncrypt(KEY, plaintext);
        System.out.println(result);
//        Assertions.assertEquals(ciphertext, result);

        // 准确性验证2
        String result2 = CipherUtils.aesEncrypt(KEY, plaintext2);
        System.out.println(result2);
//        Assertions.assertEquals(ciphertext2, result2);

        // 准确性验证2
        String result10 = CipherUtils.aesEncrypt("", plaintext);
        System.out.println(result10);
//        Assertions.assertEquals("63573C8FC0DB94342B493D5C0E0AC342192223ACEC915BC620DFC5A36E296349", result10);

        // 长度验证
        String result3 = CipherUtils.aesEncrypt("1234567891012345", "tR78_148%$%uyYcwasd"); //seed:16, 待加密文本:19
        System.out.println(result3);
        System.out.println(result3.length());
//        Assertions.assertEquals(64, result3.length());

        // 长度验证2
        String result4 = CipherUtils.aesEncrypt("1234567891012345", "tR78_148%$%uyYcwasdadasdasdasd@2"); //seed:16, 待加密文本:32
        System.out.println(result4);
        System.out.println(result4.length());
//        Assertions.assertEquals(96, result4.length());

        // 长度验证3
        String result5 = CipherUtils.aesEncrypt("1234562345!!!@asdUdasdY!^%_*~#~2", "tR78_148%$%uyYcwasdadasdasdasd@2"); //seed:32, 待加密文本:32
        System.out.println(result5);
        System.out.println(result5.length());
//        Assertions.assertEquals(96, result5.length());

        // 长度验证4
        String result6 = CipherUtils.aesEncrypt("1234562345!!!@asdUdasdY!^%_*~#~2", "tR78_148%$%uyYcwasdadasdasdasd@24536456383778638"); //seed:32, 待加密文本:48
        System.out.println(result6);
        System.out.println(result6.length());
//        Assertions.assertEquals(128, result6.length());

        // 长度验证7
        String result9 = CipherUtils.aesEncrypt("1234562345!!!@asdUdasdY!^%_*~#~2", "tR78_148%$%uyYcwastR78_148%$%uyYcwasdadasdasdasd@2dadasdasdasd@2"); //seed:32, 待加密文本:64
        System.out.println(result9);
        System.out.println(result9.length());
//        Assertions.assertEquals(160, result9.length());

        // 长度验证5
        String result7 = CipherUtils.aesEncrypt("1234562345!!!@asdUdasdY!^%_*~#~2sadasfasd1123asd", "tR78_148%$%uyYcwasdadasdasdasd@2"); //seed:48, 待加密文本:32
        System.out.println(result7);
        System.out.println(result7.length());
//        Assertions.assertEquals(96, result7.length());

        // 长度验证6
        String result8 = CipherUtils.aesEncrypt("1234562345!!!@asdUdadY!^%_*~#~2sadasfasd112asd12423w3454`136521356221!&^#T12asdasd78576767864565", "tR78_148%$%uyYcwasdadasdasdasd@2"); //seed:96, 待加密文本:32
        System.out.println(result8);
        System.out.println(result8.length());
//        Assertions.assertEquals(96, result8.length());


        // 加密后密文长度，主要是跟被加密文本相关。与seed关系不大。
        // 故数据库存储密码长度256 varchar即可满足 (一般密码不会超过32位)
    }

//    @Test
    void aesDecrypt() {
        // 准确性验证1
        String plaintextActual = CipherUtils.aesDecrypt(KEY, ciphertext);
        System.out.println(plaintext);
//        Assertions.assertEquals(plaintext, plaintextActual);

        // 准确性验证2
        String plaintextActual2 = CipherUtils.aesDecrypt(KEY, ciphertext2);
        System.out.println(plaintextActual2);
//        Assertions.assertEquals(plaintext2, plaintextActual2);
    }

//    @Test
    void generateAesKey() {
        String key = CipherUtils.generateAesKey();
        System.out.println(key);
//        Assertions.assertNotNull(key);
    }

//    @Test
    void generateAesKeyBySeed() {
        // 准确性及长度验证
        String keyBySeed = CipherUtils.generateAesKeyBySeed("123456");
        System.out.println(keyBySeed);
        String finalKey = "6BB4837EB74329105EE4568DDA7DC67E";
//        Assertions.assertEquals(finalKey, keyBySeed);
//        Assertions.assertEquals(32, keyBySeed.length());

        // 准确性及长度验证2
        String keyBySeed2 = CipherUtils.generateAesKeyBySeed("@!#$%c5zxTqvJOW13()3cQqAQ3ug-;/=");
        System.out.println(keyBySeed2);
        String finalKey2 = "D8109D49A0C2F89BAB399FCB92FE305B";
//        Assertions.assertEquals(finalKey2, keyBySeed2);
//        Assertions.assertEquals(32, keyBySeed2.length());

        // 生成的key在seed一定范围内，总是为32
    }

}