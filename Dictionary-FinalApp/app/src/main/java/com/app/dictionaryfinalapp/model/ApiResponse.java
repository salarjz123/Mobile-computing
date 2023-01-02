package com.app.dictionaryfinalapp.model;

import java.util.List;

public class ApiResponse {
    String word = "";
    List<com.app.dictionaryfinalapp.model.meanings> meanings = null;

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public List<com.app.dictionaryfinalapp.model.meanings> getMeanings() {
        return meanings;
    }

    public void setMeanings(List<com.app.dictionaryfinalapp.model.meanings> meanings) {
        this.meanings = meanings;
    }
}
