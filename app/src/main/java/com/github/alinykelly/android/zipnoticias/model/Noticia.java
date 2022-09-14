package com.github.alinykelly.android.zipnoticias.model;

public class Noticia {
    private final String titulo;
    private final String data;
    private final String conteudo;
    private final String autor;

    public Noticia(String titulo, String data, String conteudo, String autor) {
        this.titulo = titulo;
        this.data = data;
        this.conteudo = conteudo;
        this.autor = autor;
    }

    @Override
    public String toString() {
        return titulo;
    }
}
