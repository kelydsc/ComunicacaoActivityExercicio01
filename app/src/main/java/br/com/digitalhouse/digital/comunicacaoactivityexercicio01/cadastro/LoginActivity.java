package br.com.digitalhouse.digital.comunicacaoactivityexercicio01.cadastro;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import br.com.digitalhouse.digital.comunicacaoactivityexercicio01.R;
import br.com.digitalhouse.digital.comunicacaoactivityexercicio01.home.MainActivity;

public class LoginActivity extends AppCompatActivity {

    //Declaração de atributos
    private TextInputLayout textInputLayoutNome;
    private TextInputLayout textInputLayoutSobrenome;
    private TextInputLayout textInputLayoutIdade;
    private Button btnEnviar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        textInputLayoutNome = findViewById(R.id.textInputLayoutNome);
        textInputLayoutSobrenome = findViewById(R.id.textInputLayoutSobrenome);
        textInputLayoutIdade = findViewById(R.id.textInputLayoutIdade);
        btnEnviar = findViewById(R.id.btnEnviar);

        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                valiteAndGotoHome();

            }
        });
    }

    private void valiteAndGotoHome() {

        String nome = textInputLayoutNome.getEditText().getText().toString();
        String sobrenome = textInputLayoutSobrenome.getEditText().getText().toString();
        String idade = textInputLayoutIdade.getEditText().getText().toString();

        textInputLayoutNome.setError("");
        textInputLayoutSobrenome.setError("");
        textInputLayoutIdade.setError("");

        if (nome.isEmpty()) {
            textInputLayoutNome.setError("Digite seu nome");
            return;
        }

        if (sobrenome.isEmpty()) {
            textInputLayoutSobrenome.setError("Digite seu sobrenome");
            return;
        }

        if (idade.isEmpty()) {
            textInputLayoutIdade.setError("Digite sua idade");
            return;
        }

        if(!(nome.isEmpty()) && !(sobrenome.isEmpty()) && !(idade.isEmpty())){
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            Bundle bundle = new Bundle();

            bundle.putString("NOME", nome);
            bundle.putString("SOBRENOME", sobrenome);
            bundle.putString("IDADE", idade);

            intent.putExtras(bundle);

            startActivity(intent);
        }

    }
}
