package com.github.alinykelly.android.zipnoticias.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.github.alinykelly.android.zipnoticias.R;
import com.github.alinykelly.android.zipnoticias.dao.NoticiaDAO;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class ListaNoticiasActivity extends AppCompatActivity {

    private final NoticiaDAO dao = new NoticiaDAO();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_noticias);

        configuraFabNovaNoticia();
        configuraFabMenuVoltar();
    }

    //Configuracao do Botao para adicionar novas noticias
    private void configuraFabNovaNoticia(){
        FloatingActionButton botaoNovaNoticia = findViewById(R.id.activity_lista_noticias_fab_nova_noticia);
        botaoNovaNoticia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                abreFormularioNoticiaActivity();
            }
        });
    }

    private void abreFormularioNoticiaActivity(){
        startActivity(new Intent(this, FormularioNoticiaActivity.class));
    }

    //Configuracao do Botao para abrir o Menu de Voltar para pagina inicial
    private void configuraFabMenuVoltar(){
        FloatingActionButton botaoVoltar = findViewById(R.id.activity_lista_noticias_fab_menu_voltar);
        botaoVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                abrePaginaNoticiasActivity();
            }
        });
    }

    private void abrePaginaNoticiasActivity(){
        startActivity(new Intent(this, PaginaNoticias.class));
    }

    @Override
    protected void onResume(){
        super.onResume();
        configuraLista();
    }

    private void configuraLista(){
        ListView listaDeNoticias = findViewById(R.id.activity_lista_de_noticias_listview);
        listaDeNoticias.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, dao.todos()));
    }
}