package com.prototype.sofa.web;

import com.prototype.sofa.model.Language;
import com.prototype.sofa.service.language.LanguageService;
import com.prototype.sofa.to.ToLanguage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = LanguageRestController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class LanguageRestController {
    static final String REST_URL = "/language";

    @Autowired
    private LanguageService languageService;

    @GetMapping(value = "/all")
    public List<Language> getAll() {
        return languageService.findAll();
    }

    @PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Language> addLanguage(@RequestBody ToLanguage toLanguage) {
        Language language = languageService.addLanguage(toLanguage.getNameLanguage());
        if (language == null)
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        else
            return new ResponseEntity<>(language, HttpStatus.CREATED);
    }
}
