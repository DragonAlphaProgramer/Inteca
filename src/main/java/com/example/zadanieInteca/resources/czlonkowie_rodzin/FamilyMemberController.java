/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.zadanieInteca.resources.czlonkowie_rodzin;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author PatrykK
 */ 
@RestController
public class FamilyMemberController {
    
    
 
    @Autowired
    private FamilyMemberService rodzinny_czlonkowieService;
    
    @RequestMapping(path="/familiesMember")
    public @ResponseBody ArrayList<FamilyMember> getAllMember(){
        return rodzinny_czlonkowieService.getAllMember();
    } 
   
// podgląd człoonków danej rodziny
    @RequestMapping(path="/familiesMember/{nazwa}")
    public @ResponseBody ArrayList<FamilyMember> getFamilyMember(@PathVariable String nazwa) {
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
