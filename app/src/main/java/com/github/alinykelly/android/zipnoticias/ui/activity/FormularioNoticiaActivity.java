package com.github.alinykelly.android.zipnoticias.ui.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.github.alinykelly.android.zipnoticias.R;
import com.github.alinykelly.android.zipnoticias.dao.NoticiaDAO;
import com.github.alinykelly.android.zipnoticias.model.Noticia;

public class FormularioNoticiaActivity extends AppCompatActivity {

    private EditText campoTitulo;
    private EditText campoDataNoticia;
    private EditText campoConteudo;
    private EditText campoAutor;
    private final NoticiaDAO dao = new NoticiaDAO();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_noticia);

        inicializacaoDosCampos();

        configuraBotaoSalvar();
    }

    private void configuraBotaoSalvar(){
        Button botaoSalvar = findViewById(R.id.activity_formulario_noticia_botao_salvar);
        botaoSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Noticia noticiaCriada = criaNoticia();
                salvar(noticiaCriada);
            }
        });
    }

    private void inicializacaoDosCampos(){
        campoTitulo = findViewById(R.id.activity_formulario_noticia_titulo);
        campoDataNoticia = findViewById(R.id.activity_formulario_noticia_data);
        campoConteudo = findViewById(R.id.activity_formulario_noticia_conteudo);
        campoAutor = findViewById(R.id.activity_formulario_noticia_autor);
    }

    private void salvar(Noticia noticia){
        dao.salva(noticia);
        finish();
    }

    @NonNull
    private Noticia criaNoticia(){
        String titulo = campoTitulo.getText().toString();
        String data = campoDataNoticia.getText().toString();
        String conteudo = campoConteudo.getText().toString();
        String autor = campoAutor.getText().toString();

        Noticia noticiaCriada = new Noticia(titulo, data, conteudo, autor);
        return noticiaCriada;
    }
}