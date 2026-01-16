package com.study.jasypt_example.test;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.SimpleStringPBEConfig;

// JasyptEncryptUtil.java - 암호화
public class JasyptEncryptUtil {
    public static void main(String[] args) {
        SimpleStringPBEConfig config = new SimpleStringPBEConfig();

        // jasypt.properties의 password와 동일해야 함
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

        // 여기에 실제 DB 사용자명과 비밀번호를 입력하세요
        String originalUsername = encryptor.encrypt("22405006");
        String originalPassword = encryptor.encrypt("dlfbdks1!");


        String encryptedUsername = encryptor.encrypt(originalUsername);
        String encryptedPassword = encryptor.encrypt(originalPassword);

        System.out.println("===============================================");
        System.out.println("🔐 암호화된 사용자명: " + encryptedUsername);
        System.out.println("🔐 암호화된 비밀번호: " + encryptedPassword);

        System.out.println("===============================================");
        System.out.println("application-db.properties에 다음과 같이 설정하세요:");
        System.out.println("spring.datasource.username=ENC(" + encryptedUsername + ")");
        System.out.println("spring.datasource.password=ENC(" + encryptedPassword + ")");
    }
}