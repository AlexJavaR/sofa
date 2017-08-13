package com.prototype.sofa.web;

import com.prototype.sofa.model.Language;
import com.prototype.sofa.service.language.LanguageService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by AlexMeleh on 13.08.2017.
 */

@RunWith(MockitoJUnitRunner.class)
public class LanguageRestControllerTest {
    @Mock
    private LanguageService languageService;

    @InjectMocks
    private LanguageRestController languageRestController;

    @Test
    public void getAll() throws Exception {
        List<Language> languagesList = languageRestController.getAll();
        when(languageService.findAll()).thenReturn(languagesList);
        verify(languageService).findAll();
    }

    @Test
    public void addLanguage() throws Exception {
    }

}