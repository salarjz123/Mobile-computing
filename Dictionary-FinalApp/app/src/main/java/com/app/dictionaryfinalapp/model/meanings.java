package com.app.dictionaryfinalapp.model;

import java.util.List;

public class meanings {
    String partOfSpeech = "";
    List<com.app.dictionaryfinalapp.model.definitions> definitions = null;
    List<String> synonyms = null;

    public List<String> getSynonyms() {
        return synonyms;
    }

    public void setSynonyms(List<String> synonyms) {
        this.synonyms = synonyms;
    }

    public String getPartOfSpeech() {
        return partOfSpeech;
    }

    public void setPartOfSpeech(String partOfSpeech) {
        this.partOfSpeech = partOfSpeech;
    }

    public List<com.app.dictionaryfinalapp.model.definitions> getDefinitions() {
        return definitions;
    }

    public void setDefinitions(List<com.app.dictionaryfinalapp.model.definitions> definitions) {
        this.definitions = definitions;
    }
}
