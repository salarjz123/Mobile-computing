package com.app.dictionaryfinalapp.model;

import java.util.List;

public class definitions {
    String definition = "";
    List<String> synonyms  = null;

    public List<String> getSynonyms() {
        return synonyms;
    }

    public void setSynonyms(List<String> synonyms) {
        this.synonyms = synonyms;
    }

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }

}
