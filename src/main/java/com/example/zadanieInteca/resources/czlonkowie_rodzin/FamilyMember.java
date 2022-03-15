
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

/**
 *
 * @author PatrykK
 */
// Klasa reprezentująca członków rodzin
@Entity
@Table(name = "czlonkowie_rodzin")
public class FamilyMember implements Serializable{
   //kolumny Imienia, przynależności do rodziny i wieku
    @Column
    private String imie;
    @Column
    private String nazwa;
    @Column
    private int wiek;
    //ID
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE
    )
    private Integer idM;

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
    public FamilyMember(int idM,String Name, String FamilyName, int age) {
        this.imie = Name;
        this.nazwa = FamilyName;
        this.wiek = age;
        this.idM=idM;
    }

    public Integer getIdM() {
        return idM;
    }

    public void setIdM(Integer idM) {
        this.idM = idM;
    }
    
}

