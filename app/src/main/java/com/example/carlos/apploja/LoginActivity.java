package com.example.carlos.apploja;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.carlos.apploja.model.Cliente;
import com.example.carlos.apploja.model.Pedido;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Cliente ja Logado
        Pedido pedido = (Pedido) getIntent().getSerializableExtra("Pedido");
        if (pedido != null) {
            Cliente cliente = pedido.getCliente();
            if (cliente != null){
                Intent intent = new Intent(getBaseContext(), PagamentoActivity.class);
                intent.putExtra("Pedido", pedido);
                startActivity(intent);
            }
        }

        final TextView txtCpf = (TextView) findViewById(R.id.txtCpf);
        final TextView txtSenha = (TextView) findViewById(R.id.txtSenha);

        Button btnLogin = (Button)findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if(txtCpf.getText().length() == 0 || txtSenha.getText().length()==0) {
                    Toast.makeText(getApplicationContext(), "Os campos Login e Senha sao obrigatorios !",Toast.LENGTH_SHORT).show();
                }
                else {
                    // valida foto (desenvolver)
                    Cliente cliente = new Cliente();
                    cliente.setCpf(txtCpf.getText().toString());
                    cliente.setNome("Luiz Carlos Soares");

                    Pedido pedido = (Pedido) getIntent().getSerializableExtra("Pedido");
                    if (pedido != null) {
                        pedido.setCliente(cliente);
                    }

                    Intent intent = new Intent(getBaseContext(), PagamentoActivity.class);
                    intent.putExtra("Pedido", pedido);
                    startActivity(intent);
                }
            }
        });
    }
}
