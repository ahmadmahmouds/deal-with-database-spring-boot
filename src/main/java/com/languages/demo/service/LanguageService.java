package com.languages.demo.service;

import com.languages.demo.LanguageRepository.LanguageRepository;
import com.languages.demo.models.Language;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LanguageService {
    private  final LanguageRepository languageRepository;

    public LanguageService(LanguageRepository languageRepository){
        this.languageRepository=languageRepository;
    }


    public List<Language> allLanguage() {

        return languageRepository.findAll();
    }

    public Language createLanguage(Language l) {

        return languageRepository.save(l);
    }

    public Language findLanguage(Long id) {
        Optional<Language> optionalLanguage = languageRepository.findById(id);
        if(optionalLanguage.isPresent()) {
            return optionalLanguage.get();
        } else {
            return null;
        }
    }
    public void deleteLanguage(Long id) {
        Optional<Language> optionalBook = languageRepository.findById(id);
        if(optionalBook.isPresent()) {
            languageRepository.deleteById(id);
        }
    }

    public Language edit(Language lang){

        Optional<Language> optionalLanguage=languageRepository.findById(lang.getId());

        if(optionalLanguage.isPresent()){
            Language orginalLang = optionalLanguage.get();
            orginalLang.setName(lang.getName());
            orginalLang.setCreater(lang.getCreater());
            orginalLang.setCurrentVersion(lang.getCurrentVersion());
            languageRepository.save(orginalLang);
            return orginalLang;
        }else{
            return  null;
        }
    }





}
