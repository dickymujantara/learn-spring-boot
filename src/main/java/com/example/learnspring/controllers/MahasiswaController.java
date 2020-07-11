package com.example.learnspring.controllers;

import com.example.learnspring.models.Mahasiswa;
import com.example.learnspring.services.MahasiswaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MahasiswaController {

    private MahasiswaService mahasiswaService;

    @Autowired
    public void setMahasiswaService(MahasiswaService mahasiswaService) {
        this.mahasiswaService = mahasiswaService;
    }

    @RequestMapping("/mahasiswa")
    public String index(Model model){
        model.addAttribute("mahasiswa", mahasiswaService.listMahasiswa());
        model.addAttribute("key", "Hello");
        return "mahasiswa";
    }

    @RequestMapping(value = "/mahasiswa/create", method = RequestMethod.GET)
    public String form(Model model){
        model.addAttribute("mahasiswa",new Mahasiswa());
        return "formMahasiswa";
    }

    @RequestMapping(value = "/mahasiswa/create", method = RequestMethod.POST)
    public String store(Model model, Mahasiswa mahasiswa){
        model.addAttribute("mahasiswa", mahasiswaService.store(mahasiswa));
        return "redirect:/mahasiswa";
    }

    @RequestMapping(value = "/mahasiswa/{id}")
    public String editMahasiswa(@PathVariable Long id, Model model){
        model.addAttribute("mahasiswa", mahasiswaService.getMahasiswa(id));
        return "formMahasiswa";
    }

    @RequestMapping(value = "/mahasiswa/delete/{id}")
    public String deleteMahasiswa(@PathVariable Long id){
        mahasiswaService.deleteMahasiswa(id);
        return "redirect:/mahasiswa";
    }

}
