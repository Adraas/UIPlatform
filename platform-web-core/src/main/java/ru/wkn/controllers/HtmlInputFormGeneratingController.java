package ru.wkn.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HtmlInputFormGeneratingController {

    @GetMapping(path = {"/generated-input-fields-form"})
    public String getInputFieldsForm() {
        return null;
    }

    @PostMapping(path = {"/transmitted-input-fields-form"})
    public String sendUserInputData() {
        return null;
    }
}
