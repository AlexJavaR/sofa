package com.prototype.sofa.web;

import com.prototype.sofa.model.Tip;
import com.prototype.sofa.service.tip.TipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(TipRestController.REST_URL)
public class TipRestController {
    static final String REST_URL = "/tip";

    @Autowired
    private TipService tipService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Tip> getAll() {
        return tipService.findAll();
    }

    @GetMapping(value = "/{language}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Tip> getByLanguage(@PathVariable("language") String language) {
        return tipService.getByLanguage(language);
    }
}
