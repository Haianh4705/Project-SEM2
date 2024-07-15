/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hung.project;

import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

/**
 *
 * @author ADMIN
 */
public class Users {
    static Cipher cipher; 
    
    String id, name, email, phone_number, birth_place, date_birth, gender, pwd;

    public Users() {
    }

    public Users(String id, String name, String email, String phone_number, String birth_place, String date_birth, String gender, String pwd) throws Exception {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone_number = phone_number;
        this.birth_place = birth_place;
        this.date_birth = date_birth;
        this.gender = gender;
        this.pwd = encrypt(pwd);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getBirth_place() {
        return birth_place;
    }

    public void setBirth_place(String birth_place) {
        this.birth_place = birth_place;
    }

    public String getDate_birth() {
        return date_birth;
    }

    public void setDate_birth(String date_birth) {
        this.date_birth = date_birth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
    
    public static String encrypt(String pwd)
            throws Exception {
         KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        keyGenerator.init(128); // block size is 128bits
        SecretKey secretKey = keyGenerator.generateKey();
         cipher = Cipher.getInstance("AES");
        byte[] plainTextByte = pwd.getBytes();
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] encryptedByte = cipher.doFinal(plainTextByte);
        Base64.Encoder encoder = Base64.getEncoder();
        String encryptedText = encoder.encodeToString(encryptedByte);
        return encryptedText;
    }
}
