package br.com.digitalhouse.digital.comunicacaoactivityexercicio01.home;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import br.com.digitalhouse.digital.comunicacaoactivityexercicio01.R;

public class MainActivity extends AppCompatActivity {

    private TextView textViewTitle;
    private TextView textViewNome;
    private TextView textViewSobrenome;
    private TextView textViewIdade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewTitle = findViewById(R.id.textViewTitle);
        textViewNome= findViewById(R.id.textViewNome);
        textViewSobrenome = findViewById(R.id.textViewSobrenome);
        textViewIdade = findViewById(R.id.textViewIdade);

        Intent intent = getIntent();

        if (getIntent() != null && getIntent().getExtras() != null){

            Bundle bundle = getIntent().getExtras();

            if (bundle.getString("NOME") != null){
                textViewTitle.setText("Olá " + bundle.getString("NOME") + " seja bem-vindo!");

                textViewNome.setText("Nome: " + bundle.getString("NOME"));

            }

            if (bundle.getString("SOBRENOME") != null){
                textViewSobrenome.setText("Sobrenome: " + bundle.getString("SOBRENOME"));
            }

            if (bundle.getString("IDADE") != null){
                textViewIdade.setText("Idade: " + bundle.getString("IDADE"));
            }
        }
    }
}
