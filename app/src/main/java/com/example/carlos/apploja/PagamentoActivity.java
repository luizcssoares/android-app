package com.example.carlos.apploja;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.carlos.apploja.model.Cliente;
import com.example.carlos.apploja.model.Endereco;
import com.example.carlos.apploja.model.ItemPedido;
import com.example.carlos.apploja.model.Pagamento;
import com.example.carlos.apploja.model.Pedido;

import java.util.List;

public class PagamentoActivity extends AppCompatActivity {

    Pedido pedido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagamento);

        pedido = (Pedido) getIntent().getSerializableExtra("Pedido");
        Cliente cliente = pedido.getCliente();
        Pagamento pagamento = pedido.getPagamento();
        Endereco endereco = pedido.getEndereco();

        // Dados do Cliente
        TextView txtCpf = (TextView) findViewById(R.id.txtCpf);
        TextView txtNome = (TextView) findViewById(R.id.txtNome);

        // Dados do Endereco
        TextView txtLogradouro = (TextView) findViewById(R.id.txtLogradouro);
        TextView txtNumero = (TextView) findViewById(R.id.txtNumero);
        TextView txtBairro = (TextView) findViewById(R.id.txtBairro);
        TextView txtCidade = (TextView) findViewById(R.id.txtCidade);
        TextView txtUf = (TextView) findViewById(R.id.txtUf);

        // Valores do Pedido
        TextView txtCompra = (TextView) findViewById(R.id.txtCompra);
        TextView txtFrete  = (TextView) findViewById(R.id.txtFrete);
        TextView txtPedido = (TextView) findViewById(R.id.txtPedido);

        RadioButton opBoleto = (RadioButton) findViewById(R.id.opBoleto);
        RadioButton opCartao = (RadioButton) findViewById(R.id.opCartao);
        RadioButton opPayPal = (RadioButton) findViewById(R.id.opPayPal);

        txtCpf.setText(cliente.getCpf().toString());
        txtNome.setText(cliente.getNome().toString());

        txtLogradouro.setText(endereco.getLogradouro().toString());
        txtNumero.setText(endereco.getComplemento().toString());
        txtBairro.setText(endereco.getBairro().toString());
        txtCidade.setText(endereco.getLocalidade().toString());
        txtUf.setText(endereco.getUf().toString());

        txtFrete.setText(txtFrete.getText().toString());
        txtCompra.setText(txtCompra.getText().toString());
        txtPedido.setText(txtPedido.getText().toString());

        if (opBoleto.isChecked()){
            pagamento.setIdpgto(1);
            pagamento.setNompgto("Boleto");
        }
        if (opCartao.isChecked()){
            pagamento.setIdpgto(2);
            pagamento.setNompgto("Cartao");
        }
        if (opPayPal.isChecked()){
            pagamento.setIdpgto(3);
            pagamento.setNompgto("PayPal");
        }
        pedido.setPagamento(pagamento);

        Button btnGravar = (Button)findViewById(R.id.btnGravar);
        btnGravar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), ResultadoActivity.class);
                pedido = new Pedido();                     // Limpando dados do Pedido
                intent.putExtra("Pedido", pedido);
                startActivity(intent);
            }
        });
    }
}
