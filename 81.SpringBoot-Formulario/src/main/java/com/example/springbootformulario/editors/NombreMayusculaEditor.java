package com.example.springbootformulario.editors;

import java.beans.PropertyEditorSupport;
import java.util.Locale;

public class NombreMayusculaEditor extends PropertyEditorSupport {
    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        setValue(text.toUpperCase().trim());
    }
}
