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
import org.springframework.stereotype.Service;

/**
 *
 * @author PatrykK
 */
@Service
public class FamilyService {

   
    
    
    private ArrayList<Family> rodziny;

    //zwrot rodzin
    public ArrayList<Family> getAllFamily(){
        return rodziny;
    }
    // zwrot rodziny o danym id
    Family getFamily(Integer id) {
    return rodziny.stream().filter(f ->f.getId().equals(id)).findFirst().get();
    }
//tworzenie rodziny
    public void createFamiy(String family,int bobas,int dzieciak,int dorosly,ArrayList<FamilyMember> lista_czlonkow) throws MYException {
        rodziny.add(new Family(family,bobas,dzieciak,dorosly,lista_czlonkow));
    }

    

    
   
}
