/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.zadanieInteca.resources.rodzina;

import com.example.zadanieInteca.RESTService.MYException1;
import com.example.zadanieInteca.resources.czlonkowie_rodzin.FamilyMember_1;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author PatrykK
 */
@Service
public class FamilyService1 {

   int idr=1;
    
    
    private ArrayList<Family1> rodziny;

    //zwrot rodzin
    public ArrayList<Family1> getAllFamily(){
        return rodziny;
    }
    // zwrot rodziny o danym id
    Family1 getFamily(Integer id) {
    return rodziny.stream().filter(f ->f.getId().equals(id)).findFirst().get();
    }
//tworzenie rodziny
    public void createFamiy(String family,int bobas,int dzieciak,int dorosly,ArrayList<FamilyMember_1> lista_czlonkow) throws MYException1 {
        rodziny.add(new Family1(idr,family,bobas,dzieciak,dorosly,lista_czlonkow));
        idr = idr+1;
    }

    

    
   
}
