package com.github.alinykelly.android.zipnoticias.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.github.alinykelly.android.zipnoticias.R;
import com.github.alinykelly.android.zipnoticias.dao.NoticiaDAO;
import com.github.alinykelly.android.zipnoticias.model.Noticia;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class PaginaNoticias extends AppCompatActivity {
    private final NoticiaDAO dao = new NoticiaDAO();
    private ListView listView;
    TextView tv_titulo;
    TextView tv_data;
    TextView tv_conteudo;
    TextView tv_autor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagina_noticias);

        tv_titulo = findViewById(R.id.tv_TituloNoticia);
        tv_data = findViewById(R.id.tv_DataNoticia);
        tv_conteudo = findViewById(R.id.tv_ConteudoNoticia);
        tv_autor = findViewById(R.id.tv_AutorNoticia);

        configuraFabMenuCadastro();

        configuraBotaoProximaNoticia();
    }

    //Configuracao do Botao para Lista de  cadastro
    private void configuraFabMenuCadastro(){
        FloatingActionButton botaoMenuCadastro = findViewById(R.id.activity_pagina_noticias_fab_menu_cadastro);
        botaoMenuCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                abreListaNoticiasActivity();
            }
        });
    }

    private void abreListaNoticiasActivity(){
        startActivity(new Intent(this, ListaNoticiasActivity.class));
    }

    //Configuracao do Botao Proximo
    private void configuraBotaoProximaNoticia(){
        Button botaoProximaNoticia = findViewById(R.id.activity_pagina_noticias_btn_proximo);
        botaoProximaNoticia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recuperaNoticias();
            }
        });
    }

    private void recuperaNoticias(){
        listView = findViewById(R.id.activity_lista_de_noticias_listview);

        tv_titulo.setText((Integer) listView.getItemAtPosition(0));

    }

}