/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.zadanieInteca.resources.czlonkowie_rodzin;

import java.util.ArrayList;
import java.util.Arrays;
import org.springframework.stereotype.Service;

/**
 *
 * @author PatrykK
 */
@Service
public class FamilyMemberService {
    //zwrot wszystkich członków rodzin
     public static ArrayList<FamilyMember> r1 = new ArrayList<FamilyMember>();
    ArrayList<FamilyMember> getAllMember() {
    return r1;
    }
     //zwrot wszystkich członków danej rodziny
    public static  ArrayList<FamilyMember> getFamilyMember(String s) {
         ArrayList<FamilyMember> wynik = new ArrayList<>();
    for(FamilyMember fm : r1){
        if(fm.getFamilyName().equals(s)){
            wynik.add(fm);
        }
    }
    return wynik;
    }

   
//tworzenie nowego członka danej rodziny
   public static  void createFamilyMember(String imie, String member, Integer wiek) {
        r1.add(new FamilyMember(imie,member,wiek));}



   

}
