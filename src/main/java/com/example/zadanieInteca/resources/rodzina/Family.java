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
import org.hibernate.annotations.GenericGenerator;
import com.example.zadanieInteca.resources.czlonkowie_rodzin.*;

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
    private Integer ID;
    //Kolumny: niemowleta,dzieci,dorośli
    @Column
    private Integer Infants, Children, Adults;
// konstruktor
    Family(String family, int bobas, int dzieciak, int dorosly, ArrayList<FamilyMember> lista_czlonkow) throws MYException {
     // kontrola poprawności
        if (validateFamilyData(bobas, dzieciak, dorosly, lista_czlonkow) == true) {
            Infants = bobas;
            Children = dzieciak;
            Adults = dorosly;
            familyMembers = lista_czlonkow;
            Name = family;
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

    private ArrayList<FamilyMember> familyMembers = new ArrayList<>();

    Family(Integer ID, String nazwa, Integer niemowleta, Integer dzieci, Integer dorosli, ArrayList<FamilyMember> czlonkowie_rodziny) throws MYException {
        if (validateFamilyData(niemowleta, dzieci, dorosli, czlonkowie_rodziny) == true) {
            Infants = niemowleta;
            this.ID = ID;
            Children = dzieci;
            Adults = dorosli;
            familyMembers = czlonkowie_rodziny;
            Name = nazwa;
        } else {
            throw new MYException();
        }
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    ArrayList<FamilyMember> getFamilyMembers() {
        return familyMembers;
    }

    //Metoda kontrolujaca poprawność
    @SuppressWarnings("empty-statement")
    private boolean validateFamilyData(Integer niemowleta, Integer dzieci, Integer dorosli, ArrayList<FamilyMember> czlonkowie_rodziny) {
        int vniemowleta = 0, vdzieci = 0, vdorosli = 0;
        for (FamilyMember CZ : czlonkowie_rodziny) {
            if (CZ.wiek <= 4) {
                vniemowleta = vniemowleta + 1;
            } else if (CZ.wiek > 4 && CZ.wiek <= 16) {
                vdzieci = vdzieci + 1;
            } else {
                vdorosli = vdorosli + 1;
            }
        };
        //warunek końca poprawności.
        return vniemowleta == niemowleta && dzieci == vdzieci && vdorosli == dorosli;
    }

    public Integer getId() {
        return ID;
    }
}
