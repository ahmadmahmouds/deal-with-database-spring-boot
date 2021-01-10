package com.languages.demo.controller;

import com.languages.demo.models.Language;
import com.languages.demo.service.LanguageService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;

@Controller
public class LanguageController {
    private final LanguageService languageService;

    public LanguageController(LanguageService languageService){

        this.languageService=languageService;
    }

    @RequestMapping("/languages")
    public String index(Model model, @ModelAttribute("language") Language language,BindingResult result){
        List<Language> languages= languageService.allLanguage();
        model.addAttribute("languages",languages);
        return "languages/index.jsp";

    }
    @RequestMapping(value="/languages/{id}" ,method = RequestMethod.DELETE)
    public String destroy(@PathVariable("id") Long id) {
        languageService.deleteLanguage(id);
        return "redirect:/languages";
    }


    @RequestMapping(value="/languages", method= RequestMethod.POST)
    public  String create(@Valid @ModelAttribute("language") Language language, BindingResult result) {
        if (result.hasErrors()) {
            return "languages/index.jsp";
        } else {
           languageService.createLanguage(language);
            return "redirect:/languages";
        }
    }

    @RequestMapping(value = "/languages/edit/{id}")
    public String show (@PathVariable("id") Long id,Model model){
        Language lang=languageService.findLanguage(id);
        model.addAttribute("language",lang);
        return "/languages/edit.jsp";

    }


    @RequestMapping(value = "/languages/{id}" ,method =RequestMethod.PUT)
    public String edit( @Valid @ModelAttribute("language") Language language,BindingResult result){
       System.out.println("");
        if(result.hasErrors()){
            return "languages/edit.jsp";
        }
        else{
            languageService.edit(language);
            return "redirect:/languages";
        }


    }


    @RequestMapping("languages/{id}")
    public String showDetail(@PathVariable("id") Long id ,Model model){
        Language lang = languageService.findLanguage(id);
        model.addAttribute("language",lang);
        return "languages/showDetail.jsp";


    }


}
