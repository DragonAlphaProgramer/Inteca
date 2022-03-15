/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.zadanieInteca.resources.czlonkowie_rodzin;

import java.util.ArrayList;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author PatrykK
 */
@Service
public class FamilyMemberService {

    @Autowired
    private FamilyMemberRepository repozytorium;
    
    private static int idm=1;
    //zwrot wszystkich członków rodzin
     
  ArrayList<FamilyMember> getAllMember() {
        ArrayList<FamilyMember> rodziny = new ArrayList<>();
        repozytorium.findAll().forEach(rodziny::add);
        return rodziny;
    }
     //zwrot wszystkich członków danej rodziny
    public  ArrayList<FamilyMember> getFamilyMember(String s) {
        ArrayList<FamilyMember> rodzinka = new ArrayList<>();
        for(FamilyMember krewniacy : repozytorium.findAll()){
         if(krewniacy.getFamilyName().equals(s))   {
             rodzinka.add(krewniacy);
         }
        }
        return (ArrayList<FamilyMember>) rodzinka;
    }

   
//tworzenie nowego członka danej rodziny
   public   void createFamilyMember(String imie, String member, Integer wiek) {
   repozytorium.save(new FamilyMember(idm,imie,member,wiek));
   idm=idm+1;
   }
       


   

}
