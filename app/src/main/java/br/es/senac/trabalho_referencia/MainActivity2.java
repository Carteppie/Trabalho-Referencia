package br.es.senac.trabalho_referencia;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import br.es.senac.trabalho_referencia.model.Mensagem;
import br.es.senac.trabalho_referencia.model.Status;

public class MainActivity2 extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        ListView listaChamadosTela = (ListView) findViewById(R.id.listaChamadosTela);
        List<Mensagem> mensagens = new ArrayList<Mensagem>(); //Criando a lista.

        Mensagem mensagem = new Mensagem(1L,"Qualquer coisa", Status.ENVIADA);
        mensagens.add(mensagem);

        ListView lista = (ListView) findViewById(R.id.listaChamadosTela);

        String retorno = getIntent().getExtras().getString("teste");

        Toast.makeText(getApplicationContext(),retorno, Toast.LENGTH_LONG).show();

        ArrayAdapter<Mensagem> adapter = new ArrayAdapter<Mensagem>(this,android.R.layout.select_dialog_item,mensagens);
        listaChamadosTela.setAdapter(adapter);

    }
}

