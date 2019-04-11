package com.example.carlos.apploja;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.carlos.apploja.model.Cliente;
import com.example.carlos.apploja.model.Pedido;
import com.example.carlos.apploja.model.Usuario;

public class CadastroActivity extends AppCompatActivity {

    private EditText txtCpf;
    private EditText txtNome;
    private EditText txtSenha;
    private EditText txtRedigite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        txtCpf = (EditText) findViewById(R.id.txtCpf);
        txtNome = (EditText) findViewById(R.id.txtNome);
        txtSenha = (EditText) findViewById(R.id.txtSenha);
        txtRedigite = (EditText) findViewById(R.id.txtRedigite);

        Button btnGravar = (Button)findViewById(R.id.btnGravar);
        btnGravar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if(txtCpf.getText().length() == 0 || txtSenha.getText().length()==0) {
                    Toast.makeText(getApplicationContext(), "Os campos Login e Senha sao obrigatorios !",Toast.LENGTH_SHORT).show();
                }
                else {
                    // valida foto (desenvolver)
                    Cliente cliente = new Cliente();
                    cliente.setCpf(txtCpf.getText().toString());
                    cliente.setNome(txtNome.getText().toString());

                    gravaCliente(cliente);

                    Usuario usuario = new Usuario();
                    usuario.setCpf(txtCpf.getText().toString());
                    usuario.setSenha(txtSenha.getText().toString());
                    usuario.setPerfil(1);

                    gravaUsuario(usuario);

                    Intent intent = new Intent(getBaseContext(), ProdutoActivity.class);
                    //intent.putExtra("Pedido", pedido);
                    startActivity(intent);
                }
            }
        });

    }

    public void gravaCliente(Cliente cliente){
        Toast.makeText(getApplicationContext(), "Gravando dados dos Cliente  !",Toast.LENGTH_SHORT).show();
    }

    public void gravaUsuario(Usuario usuario){
        Toast.makeText(getApplicationContext(), "Gravando dados dos Usuarios !",Toast.LENGTH_SHORT).show();
    }
}
