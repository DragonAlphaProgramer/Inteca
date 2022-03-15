package com.example.zadanieInteca.resources.rodzina;

import com.example.zadanieInteca.RESTService.MYException;
import com.example.zadanieInteca.resources.czlonkowie_rodzin.FamilyMember;
import java.io.Serializable;
import java.util.ArrayList;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 *
 * @author PatrykK
 */
@Entity
@Table(name = "rodziny")
public class Family implements Serializable {

    public Family() {
    }
    //kolumna ID
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE
    )
    private Integer IDR;
    //Kolumny: niemowleta,dzieci,dorośli
    @Column
    private Integer Adults;
    @Column
    private Integer Children;
    @Column
    private Integer Infants;
// konstruktor
    Family(int id, String family, int bobas, int dzieciak, int dorosly, ArrayList<FamilyMember> lista_czlonkow) throws MYException {
     // kontrola poprawności
        if (validateFamilyData(bobas, dzieciak, dorosly, lista_czlonkow) == true) {
            Infants = bobas;
            Children = dzieciak;
            Adults = dorosly;
            Name = family;
            this.IDR=id;
        } else {
            // przypadku niepoprawności
            throw new MYException();
        }
    }

    public Integer getInfants() {
        return Infants;
    }

    public void setInfants(Integer Infants) {
        this.Infants = Infants;
    }

    public Integer getChildren() {
        return Children;
    }

    public void setChildren(Integer Children) {
        this.Children = Children;
    }

    public Integer getAdults() {
        return Adults;
    }

    public void setAdults(Integer Adults) {
        this.Adults = Adults;
    }

    private String Name;


    Family(Integer ID, String nazwa, Integer niemowleta, Integer dzieci, Integer dorosli, ArrayList<FamilyMember> czlonkowie_rodziny) throws MYException {
        if (validateFamilyData(niemowleta, dzieci, dorosli, czlonkowie_rodziny) == true) {
            Infants = niemowleta;
            this.IDR = ID;
            Children = dzieci;
            Adults = dorosli;
            Name = nazwa;
        } else {
            throw new MYException();
        }
    }

    public void setID(Integer ID) {
        this.IDR = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }


    //Metoda kontrolujaca poprawność
    @SuppressWarnings("empty-statement")
    private boolean validateFamilyData(Integer niemowleta, Integer dzieci, Integer dorosli, ArrayList<FamilyMember> czlonkowie_rodziny) {
        int vniemowleta = 0, vdzieci = 0, vdorosli = 0;
        for (FamilyMember CZ : czlonkowie_rodziny) {
            if (CZ.getAge() <= 4) {
                vniemowleta = vniemowleta + 1;
            } else if (CZ.getAge() > 4 && CZ.getAge() <= 16) {
                vdzieci = vdzieci + 1;
            } else {
                vdorosli = vdorosli + 1;
            }
        };
        //warunek końca poprawności.
        return vniemowleta == niemowleta && dzieci == vdzieci && vdorosli == dorosli;
    }

    public Integer getId() {
        return IDR;
    }
}
