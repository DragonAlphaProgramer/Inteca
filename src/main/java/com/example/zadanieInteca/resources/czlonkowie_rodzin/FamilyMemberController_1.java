/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.zadanieInteca.resources.czlonkowie_rodzin;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author PatrykK
 */
public class FamilyMemberController_1 {
    public FamilyMemberService_1 getRodzinny_czlonkowieService() {
        return rodzinny_czlonkowieService;
    }
 
    @Autowired
    private FamilyMemberService_1 rodzinny_czlonkowieService;
    
    @RequestMapping("/familiesMember")
    public ArrayList<FamilyMember_1> getAllMember(){
        return rodzinny_czlonkowieService.getAllMember();
    } 
   
// podgląd człoonków danej rodziny
    @RequestMapping("/familiesMember/{nazwa}")
    public ArrayList<FamilyMember_1> getFamilyMember(@PathVariable String nazwa) {
        return rodzinny_czlonkowieService.getFamilyMember(nazwa);
    }
// dodawanie członków rodziny
    
    @RequestMapping(method = RequestMethod.POST, value = "/familiesMember")
    public String  stworz_krewniaka(@RequestParam("imie") String imie,@RequestParam("member")  
            String member,@RequestParam("wiek")  Integer wiek,HttpServletResponse httpResponse) throws IOException {
        rodzinny_czlonkowieService.createFamilyMember(imie,member,wiek);
        httpResponse.sendRedirect("/");
        return null;
        
    }
    
    
}
