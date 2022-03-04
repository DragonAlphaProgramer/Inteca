/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.zadanieInteca.resources.czlonkowie_rodzin;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.springframework.stereotype.Service;

/**
 *
 * @author PatrykK
 */
// Klasa reprezentująca członków rodzin
@Entity
@Table(name = "czlonkowie rodzin")
public class FamilyMember implements Serializable{
   //kolumny Imienia, przynależności do rodziny i wieku
    @Column
    public String imie,nazwa;
    @Column
    public int wiek;
    //ID
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    public FamilyMember() {
    }

    public String getName() {
        return imie;
    }

    public String getFamilyName() {
        return nazwa;
    }

    public int getAge() {
        return wiek;
    }

    
    //konstruktor
    public FamilyMember(String Name, String FamilyName, int age) {
        this.imie = Name;
        this.nazwa = FamilyName;
        this.wiek = age;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
}
