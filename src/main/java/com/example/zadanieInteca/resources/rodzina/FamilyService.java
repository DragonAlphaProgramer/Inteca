/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.zadanieInteca.resources.rodzina;

import com.example.zadanieInteca.RESTService.MYException;
import com.example.zadanieInteca.resources.czlonkowie_rodzin.FamilyMember;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.zadanieInteca.resources.czlonkowie_rodzin.FamilyMemberRepository;

/**
 *
 * @author PatrykK
 */
@Service
public class FamilyService {

   int idr=1;
    @Autowired
    private FamilyRepository repozytorium;
    //zwrot wszystkich rodzin
     public  ArrayList<Family> r1 = new ArrayList<Family>();
    ArrayList<Family> getAllFamily() {
        ArrayList<Family> rodziny = new ArrayList<>();
        repozytorium.findAll().forEach(rodziny::add);
        return rodziny;
    }
    
     //zwrot danych rodziny
    public  ArrayList<Family> getFamily(Integer i) {
        ArrayList<Family> wynik = new ArrayList<>();
        for(Family rodzina :(ArrayList<Family>) repozytorium.findAll()){
            if(rodzina.getId()==i){
                wynik.add(rodzina);
            }
        }  
        return wynik;
    }
     public  int getid(String s) {
        Family wynik = null;
        for(Family rodzina :(ArrayList<Family>) repozytorium.findAll()){
            if(rodzina.getName().equals(s)){
                wynik=rodzina;
            }
        }  
        return wynik.getId();
    }
   public   String stworz_rodzine(String family,int bobas,int dzieciak,int dorosly,ArrayList<FamilyMember> lista_czlonkow) throws MYException {
   repozytorium.save(new Family(idr,family,bobas,dzieciak,dorosly,lista_czlonkow));
   return String.valueOf(idr);
   }
}
