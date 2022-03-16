/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.zadanieInteca;

import com.example.zadanieInteca.resources.czlonkowie_rodzin.FamilyMember;
import com.example.zadanieInteca.resources.rodzina.Family;
import java.util.ArrayList;

/**
 *
 * @author PatrykK
 */
public class FullInfo {
    Family rodzina;
    ArrayList<FamilyMember> krewni = new ArrayList<>();

    public FullInfo(Family rodzina, ArrayList<FamilyMember> krewni) {
        this.rodzina = rodzina;
        for(FamilyMember k :krewni){
        this.krewni.add(k);
        }
    }

    FullInfo() {
       
    }
 
    
}
