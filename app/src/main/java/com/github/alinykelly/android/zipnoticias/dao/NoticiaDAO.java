package com.github.alinykelly.android.zipnoticias.dao;

import com.github.alinykelly.android.zipnoticias.model.Noticia;

import java.util.ArrayList;
import java.util.List;

public class NoticiaDAO {
    private final static List<Noticia> noticias = new ArrayList<>();

    public void salva(Noticia noticia) {
        noticias.add(noticia);
    }

    public List<Noticia> todos() {
        return new ArrayList<>(noticias);
    }
}
