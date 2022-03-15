/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.zadanieInteca.resources.rodzina;

import com.example.zadanieInteca.RESTService.MYException1;
import com.example.zadanieInteca.resources.czlonkowie_rodzin.FamilyMember_1;
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
public class Family1 implements Serializable {

    public Family1() {
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
    Family1(int id, String family, int bobas, int dzieciak, int dorosly, ArrayList<FamilyMember_1> lista_czlonkow) throws MYException1 {
     // kontrola poprawności
        if (validateFamilyData(bobas, dzieciak, dorosly, lista_czlonkow) == true) {
            Infants = bobas;
            Children = dzieciak;
            Adults = dorosly;
            familyMembers = lista_czlonkow;
            Name = family;
            this.ID=id;
        } else {
            // przypadku niepoprawności
            throw new MYException1();
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

    private ArrayList<FamilyMember_1> familyMembers = new ArrayList<>();

    Family1(Integer ID, String nazwa, Integer niemowleta, Integer dzieci, Integer dorosli, ArrayList<FamilyMember_1> czlonkowie_rodziny) throws MYException1 {
        if (validateFamilyData(niemowleta, dzieci, dorosli, czlonkowie_rodziny) == true) {
            Infants = niemowleta;
            this.ID = ID;
            Children = dzieci;
            Adults = dorosli;
            familyMembers = czlonkowie_rodziny;
            Name = nazwa;
        } else {
            throw new MYException1();
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

    ArrayList<FamilyMember_1> getFamilyMembers() {
        return familyMembers;
    }

    //Metoda kontrolujaca poprawność
    @SuppressWarnings("empty-statement")
    private boolean validateFamilyData(Integer niemowleta, Integer dzieci, Integer dorosli, ArrayList<FamilyMember_1> czlonkowie_rodziny) {
        int vniemowleta = 0, vdzieci = 0, vdorosli = 0;
        for (FamilyMember_1 CZ : czlonkowie_rodziny) {
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

