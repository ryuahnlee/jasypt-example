package com.study.jasypt_example.test;


import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.SimpleStringPBEConfig;

// JasyptDecryptTest.java - 복호화 테스트
public class JasyptDecryptTest {

    public static void main(String[] args) {
        SimpleStringPBEConfig config = new SimpleStringPBEConfig();

        // yml 세팅과 동일하게
        config.setPassword("tmakxmtpxmfajsxm");
        config.setAlgorithm("PBEWithHMACSHA512AndAES_256");
        config.setKeyObtentionIterations("1000");
        config.setPoolSize("1");
        config.setProviderName("SunJCE");
        config.setSaltGeneratorClassName("org.jasypt.salt.RandomSaltGenerator");
        config.setIvGeneratorClassName("org.jasypt.iv.RandomIvGenerator");
        config.setStringOutputType("base64");

        StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
        encryptor.setConfig(config);

        String encryptedUsername = "Kz/iUwGzDOX9mcujADTuO1GhsMH8kC2aFxriEzHGLj6wwIR1us6G/5/AymrKWpaq";
        String encryptedPassword = "SkkkrGr+to5qm9fDGQPjm1AHe+F3aF2nmH360Zcun4vYs9I2yFnNjYX2wPcQmWj5";

        try {
            String decryptedUsername  = encryptor.decrypt(encryptedUsername);
            String decryptedPassword  = encryptor.decrypt(encryptedPassword);

            System.out.println("✅ 복호화된 사용자명: " + decryptedUsername);
            System.out.println("✅ 복호화된 비밀번호: " + decryptedPassword);
        } catch (Exception e) {
            System.err.println("❌ 복호화 실패: " + e.getMessage());
        }
    }
}
