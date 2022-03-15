/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.zadanieInteca.resources.czlonkowie_rodzin;

import java.util.ArrayList;

/**
 *
 * @author PatrykK
 */
public class FamilyMemberService_1 {
    
    private static int idm=1;
    //zwrot wszystkich członków rodzin
     public static ArrayList<FamilyMember_1> r1 = new ArrayList<FamilyMember_1>();
    ArrayList<FamilyMember_1> getAllMember() {
    return r1;
    }
     //zwrot wszystkich członków danej rodziny
    public static  ArrayList<FamilyMember_1> getFamilyMember(String s) {
         ArrayList<FamilyMember_1> wynik = new ArrayList<>();
    for(FamilyMember_1 fm : r1){
        if(fm.getFamilyName().equals(s)){
            wynik.add(fm);
        }
    }
    return wynik;
    }

   
//tworzenie nowego członka danej rodziny
   public static  void createFamilyMember(String imie, String member, Integer wiek) {
        r1.add(new FamilyMember_1(idm,imie,member,wiek));
        idm = idm+1;}
       

}
