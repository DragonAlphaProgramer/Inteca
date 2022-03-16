/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.zadanieInteca;

import com.example.zadanieInteca.resources.czlonkowie_rodzin.FamilyMember;
import com.example.zadanieInteca.resources.czlonkowie_rodzin.FamilyMemberService;
import com.example.zadanieInteca.resources.rodzina.Family;
import com.example.zadanieInteca.resources.rodzina.FamilyService;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author PatrykK
 */
@RestController
@RequestMapping(path="/zlot")
public class Kontrolawyswietl {
   
    @Autowired
    private FamilyService rodzinnyService;
    @Autowired
    private FamilyMemberService krewnyService;
    
     @GetMapping
     public String poyzskajRodzine(int kontrola,Model model) throws IOException{
         Family rodzinka = null;
         ArrayList<Family> rodzina = (ArrayList<Family>)rodzinnyService.getFamily(kontrola);
         for(Family familia : rodzina){
         if(familia.getId()==kontrola){
             rodzinka=familia;
             System.out.println(rodzinka.getName());
         }
         }
         String nazwa = rodzinka.getName();
         ArrayList<FamilyMember> krewni = (ArrayList<FamilyMember>)krewnyService.getFamilyMember(nazwa);
         ArrayList<FamilyMember> temp = new ArrayList<>();
         for(FamilyMember familia : krewni){
            temp.add(familia);
            System.out.println(familia.getName());
         }
         FullInfo fullInfo = new FullInfo(rodzinka,temp);
         model.addAttribute("nazwa", fullInfo.rodzina.getName());
         model.addAttribute("bobasy", fullInfo.rodzina.getInfants());
         model.addAttribute("dzieciaki", fullInfo.rodzina.getChildren());
         model.addAttribute("dorosli", fullInfo.rodzina.getAdults());
         model.addAttribute("krewni", fullInfo.krewni);
        return "zlot";
     }
     
}
