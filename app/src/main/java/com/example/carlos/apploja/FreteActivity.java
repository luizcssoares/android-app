package com.example.carlos.apploja;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.carlos.apploja.model.Endereco;
import com.example.carlos.apploja.model.Pedido;
import com.example.carlos.apploja.retrofit.ServiceGenerator;
import com.example.carlos.apploja.service.CepService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FreteActivity extends AppCompatActivity {

    Endereco endereco = new Endereco();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frete);

        final TextView logradouro = (TextView) findViewById(R.id.txtLogradouro);
        final TextView complemento = (TextView) findViewById(R.id.txtComplemento);
        final TextView bairro = (TextView) findViewById(R.id.txtBairro);
        final TextView cidade = (TextView) findViewById(R.id.txtCidade);
        final TextView uf = (TextView) findViewById(R.id.txtUf);
        final TextView frete = (TextView) findViewById(R.id.txtFrete);

        Button btnCep = (Button)findViewById(R.id.btnCep);
        btnCep.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                EditText txtCep = (EditText) findViewById(R.id.txtCep);

                final String API_BASE_URL = "https://viacep.com.br/";

                CepService service = ServiceGenerator.createService(CepService.class, API_BASE_URL);

                Call<Endereco> apiCall = service.buscarCep(txtCep.getText().toString());

                //Toast.makeText(getApplicationContext(),"LENDO O SERVICO", Toast.LENGTH_LONG).show();

                apiCall.enqueue(new Callback<Endereco>() {
                    @Override  // Em caso de sucesso
                    public void onResponse(Call<Endereco> call, Response<Endereco> response) {
                        endereco = response.body();

                        logradouro.setText(endereco.getLogradouro());
                        complemento.setText(endereco.getComplemento());
                        bairro.setText(endereco.getBairro());
                        cidade.setText(endereco.getLocalidade());
                        uf.setText(endereco.getUf());
                        frete.setText("5.0"); // Valor fixo
                    }

                    @Override  // Em caso de falha
                    public void onFailure(Call<Endereco> call, Throwable t) {
                        Toast.makeText(getApplicationContext(),"ERROR CHAMADA SERVIDOR", Toast.LENGTH_LONG).show();
                        t.printStackTrace();
                    }
                });
            }
        });

        Button btnAdicionar = (Button)findViewById(R.id.btnAdicionar);
        btnAdicionar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Pedido pedido = (Pedido) getIntent().getSerializableExtra("Pedido");
                if (pedido != null) {
                    pedido.setEndereco(endereco);
                    pedido.setFrete(Double.parseDouble(frete.getText().toString()));
                }

                Intent intent = new Intent(getBaseContext(), ProdutoActivity.class);
                intent.putExtra("Pedido", pedido);
                startActivity(intent);
            }
        });

        Button btnPgto = (Button)findViewById(R.id.btnPgto);
        btnPgto.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Pedido pedido = (Pedido) getIntent().getSerializableExtra("Pedido");
                if (pedido != null) {
                    pedido.setEndereco(endereco);
                }

                Intent intent = new Intent(getBaseContext(), LoginActivity.class);
                intent.putExtra("Pedido", pedido);
                startActivity(intent);
            }
        });

    }
}
