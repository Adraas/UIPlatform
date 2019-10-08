package ru.wkn.htmlutil;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum HtmlButtonType {

    SUBMIT("let inputFields = document.getElementsByTagName(\"input\");\n" +
            "let selectFields = document.getElementsByTagName(\"select\");\n" +
            "let textareaFields = document.getElementsByTagName(\"textarea\");\n" +
            "let userInputDataDelimiter = \" \";\n" +
            "let userInputData = \"\" + userInputDataDelimiter;\n" +
            "for (let i = 0; i < inputFields.length; i++) {\n" +
            "  userInputData += inputFields[i].value;\n" +
            "}\n" +
            "for (let i = 0; i < selectFields.length; i++) {\n" +
            "  userInputData += selectFields[i].value;\n" +
            "}\n" +
            "for (let i = 0; i < textareaFields.length; i++) {\n" +
            "  userInputData += textareaFields[i].value;\n" +
            "}\n" +
            "let xmlHttpRequest = new XMLHttpRequest();\n" +
            "xmlHttpRequest.onload = function () {\n" +
            "  let response = xmlHttpRequest.responseText;\n" +
            "  document.write(response);\n" +
            "};\n" +
            "xmlHttpRequest.open(\"GET\", \"/transmitted-user-input-data\", true);\n" +
            "xmlHttpRequest.overrideMimeType(\"text/html\");\n" +
            "xmlHttpRequest.send(userInputData);"),

    CLEAR("let inputFields = document.getElementsByTagName(\"input\");\n" +
            "let selectFields = document.getElementsByTagName(\"select\");\n" +
            "let textareaFields = document.getElementsByTagName(\"textarea\");\n" +
            "for (let i = 0; i < inputFields.length; i++) {\n" +
            "  inputFields[i].value = \"\";\n" +
            "}\n" +
            "for (let i = 0; i < selectFields.length; i++) {\n" +
            "  selectFields[i].value = \"\";\n" +
            "}\n" +
            "for (let i = 0; i < textareaFields.length; i++) {\n" +
            "  textareaFields[i].value = \"\";\n" +
            "}");

    private String functionImplementation;
}
