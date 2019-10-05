package br.es.senac.trabalho_referencia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText edtLogin = (EditText) findViewById(R.id.edtLogin);
        final EditText edtSenha = (EditText) findViewById(R.id.edtSenha);
        final Button button2 = (Button) findViewById(R.id.button2);

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String login = edtLogin.getText().toString();
                String chave = edtSenha.getText().toString();

                if (login.equals("admin") && chave.equals("1234")) {
                    Toast msg = Toast.makeText(getApplicationContext(), "Login realizado com sucesso", Toast.LENGTH_LONG);
                    msg.show();

                    Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                    intent.putExtra("teste", "Olá " + login);
                    startActivity(intent);

                } else{
                    Toast msg1 = Toast.makeText(getApplicationContext(),"Login ou Senha incorretos", Toast.LENGTH_LONG);
                    msg1.show();
                }
            }
        });
    }
}

