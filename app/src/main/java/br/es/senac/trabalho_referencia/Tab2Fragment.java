package br.es.senac.trabalho_referencia;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.List;

import br.es.senac.trabalho_referencia.model.Mensagem;
import br.es.senac.trabalho_referencia.model.Status;

public class Tab2Fragment extends Fragment {

    ListView listViewMensagensNaoEnviadas;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_two, container, false);

        listViewMensagensNaoEnviadas = (ListView) view.findViewById(R.id.lista_mensagens_nao_enviadas);

        List<Mensagem> mensagens = new ArrayList<Mensagem>();

        for(int i=99; i < 150; i++)
            mensagens.add(new Mensagem(1L, "Mensagem " + i, Status.NAOENVIADA));

        ArrayAdapter<Mensagem> adapter = new ArrayAdapter<Mensagem>(getActivity(),
                android.R.layout.simple_list_item_1, mensagens);

        listViewMensagensNaoEnviadas.setAdapter(adapter);

        return view;
    }
}
