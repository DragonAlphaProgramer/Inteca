/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.zadanieInteca.resources.rodzina;

import com.example.zadanieInteca.RESTService.MYException;
import com.example.zadanieInteca.resources.czlonkowie_rodzin.*;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
/**
 *
 * @author PatrykK
 */
@RestController
public class FamilyController {

    @Autowired
    private FamilyService rodzinnyService;
// zwrot wszystich rodzin
    @RequestMapping("/families")
    public ArrayList<Family> getAllFamily() {
        return rodzinnyService.getAllFamily();
    }
// zwrot rodziny o danym ID
    @RequestMapping("/families/{id}")
    public Family getFamily(@PathVariable Integer id) {
        return rodzinnyService.getFamily(id);
    }
// tworzenie nowej rodziny
    @RequestMapping(method = RequestMethod.POST, value = "/families")
    public String stworz_rodzine(@RequestParam("nazwa")String nazwa, @RequestParam("niemowleta")Integer niemowleta
    , @RequestParam("dzieci")Integer dzieci, @RequestParam("dorosly")Integer dorosli,HttpServletResponse httpResponse) throws IOException, MYException {
        try{ArrayList<FamilyMember> czlonkowie = FamilyMemberService.getFamilyMember(nazwa);
        rodzinnyService.createFamiy(nazwa,niemowleta,dzieci,dorosli,czlonkowie);
        }catch (MYException ex){
            System.out.println("złe ilości składu rodziny");
        }
         httpResponse.sendRedirect("/");
        return null;
    }
    
}
