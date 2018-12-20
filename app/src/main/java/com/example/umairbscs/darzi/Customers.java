package com.example.umairbscs.darzi;

import android.text.Editable;

public class Customers {
    private String  Id, Name, Phone, Address, Chest, Waist, Hips, Arms, Kurta, Shalwar, Sleeve, Neck, Discp;

    public Customers() {
    }

    public Customers(String id, String name, String phone, String address, String chest, String waist, String hips, String arms, String kurta, String shalwar, String sleeve, String neck, String discp) {
        Id = id;
        Name = name;
        Phone = phone;
        Address = address;
        Chest = chest;
        Waist = waist;
        Hips = hips;
        Arms = arms;
        Kurta = kurta;
        Shalwar = shalwar;
        Sleeve = sleeve;
        Neck = neck;
        Discp = discp;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getChest() {
        return Chest;
    }

    public void setChest(String chest) {
        Chest = chest;
    }

    public String getWaist() {
        return Waist;
    }

    public void setWaist(String waist) {
        Waist = waist;
    }

    public String getHips() {
        return Hips;
    }

    public void setHips(String hips) {
        Hips = hips;
    }

    public String getArms() {
        return Arms;
    }

    public void setArms(String arms) {
        Arms = arms;
    }

    public String getKurta() {
        return Kurta;
    }

    public void setKurta(String kurta) {
        Kurta = kurta;
    }

    public String getShalwar() {
        return Shalwar;
    }

    public void setShalwar(String shalwar) {
        Shalwar = shalwar;
    }

    public String getSleeve() {
        return Sleeve;
    }

    public void setSleeve(String sleeve) {
        Sleeve = sleeve;
    }

    public String getNeck() {
        return Neck;
    }

    public void setNeck(String neck) {
        Neck = neck;
    }

    public String getDiscp() {
        return Discp;
    }

    public void setDiscp(String discp) {
        Discp = discp;
    }
}
