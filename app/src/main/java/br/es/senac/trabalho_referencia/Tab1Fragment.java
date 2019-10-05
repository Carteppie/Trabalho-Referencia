package br.es.senac.trabalho_referencia;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import br.es.senac.trabalho_referencia.api.MensagemTask;
import br.es.senac.trabalho_referencia.api.OnEventListener;
import br.es.senac.trabalho_referencia.model.Mensagem;
import br.es.senac.trabalho_referencia.model.MensagemWrapper;
import br.es.senac.trabalho_referencia.model.Status;

public class Tab1Fragment extends Fragment {

    ListView listViewMensagensEnviadas;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
      //  super.onCreate(savedInstanceState);
      //  setContentView(R.layout.fragment_one);


        final View viewFragment = inflater.inflate(R.layout.fragment_one, container, false);
        final FloatingActionButton botaoAtualizar = (FloatingActionButton) viewFragment.findViewById(R.id.BotaoAtualizar);
        botaoAtualizar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                MensagemTask mensagemTask = new MensagemTask(viewFragment.getContext(), new OnEventListener<String>() {
                    @Override
                    public void onSuccess(String result) {
                        Toast.makeText(viewFragment.getContext(), "SUCCESS: " +result, Toast.LENGTH_LONG).show();
                        Gson gson = new Gson();
                        MensagemWrapper[] mensagens = gson.fromJson(result, MensagemWrapper[].class);

                        ArrayAdapter<MensagemWrapper> adapter = new ArrayAdapter<MensagemWrapper>(getActivity(), android.R.layout.simple_list_item_1, mensagens);

                        listViewMensagensEnviadas = (ListView) viewFragment.findViewById(R.id.lista_mensagens_enviadas);
                        listViewMensagensEnviadas.setAdapter(adapter);

                    }

                    @Override
                    public void onFailure(Exception e) {
                        Toast.makeText(viewFragment.getContext(), "ERROR: " + e.getMessage(), Toast.LENGTH_LONG).show();

                    }
                });
             mensagemTask.execute();
            }
        });

     //   listViewMensagensEnviadas = (ListView) view.findViewById(R.id.lista_mensagens_enviadas);

    //    List<Mensagem> mensagems = new ArrayList<Mensagem>();

     //   for(int i=0; i<30; i++)
     //       mensagems.add(new Mensagem(1L, "Mensagem " + i, Status.ENVIADA));

    //    ArrayAdapter<Mensagem> adapter = new ArrayAdapter<Mensagem>(getActivity(),
     //           android.R.layout.simple_list_item_1, mensagems);

     //   listViewMensagensEnviadas.setAdapter(adapter);

        //Toast msg = Toast.makeText(getApplicationContext(), "Login realizado com sucesso", Toast.LENGTH_LONG);
       // msg.show();

        return viewFragment;


    }


}
