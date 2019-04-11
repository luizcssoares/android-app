package com.example.carlos.apploja;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.carlos.apploja.adapter.ItemPedidoAdapter;
import com.example.carlos.apploja.adapter.ProdutoAdapter;
import com.example.carlos.apploja.model.Cliente;
import com.example.carlos.apploja.model.ItemPedido;
import com.example.carlos.apploja.model.Pagamento;
import com.example.carlos.apploja.model.Pedido;
import com.example.carlos.apploja.model.Produto;
import com.example.carlos.apploja.retrofit.ServiceGenerator;
import com.example.carlos.apploja.service.ProdutoService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ComprasActivity extends AppCompatActivity {

    Pedido pedido;
    List<ItemPedido> itens;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compras);

        final Context ctx = this;

        pedido = (Pedido) getIntent().getSerializableExtra("Pedido");
        if (pedido == null){
            pedido = new Pedido();
        }

        itens = pedido.getItens();;
        if (itens == null){
            itens = new ArrayList<ItemPedido>();
        }

        final ListView lista = (ListView) findViewById(R.id.listview_itemproduto);

        ItemPedidoAdapter adapter = new ItemPedidoAdapter(itens,ctx);
        lista.setAdapter(adapter);

        /*
        // Cria Pedido
        Pedido pedido = (Pedido) getIntent().getSerializableExtra("Pedido");
        if (pedido == null) {
            pedido = new Pedido();
        }

        // insere Cliente no Pedido
        Cliente cliente = (Cliente) getIntent().getSerializableExtra("Cliente");
        if  ((cliente != null) && ( pedido != null)){
            pedido.setCliente(cliente);
        }

        // insere Pagamento no Pedido
        Pagamento pagamento = (Pagamento) getIntent().getSerializableExtra("Pagamento");
        if  ((pagamento != null) && (pedido != null)){
            pedido.setPagamento(pagamento);
        }
        */

        // Adiciona novo produto
        Button btnAdiciona = (Button)findViewById(R.id.btnAdiciona);
        btnAdiciona.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ComprasActivity.this, ProdutoActivity.class);
                intent.putExtra("Pedido", pedido);
                startActivity(intent);
            }
        });

        // Finaliza Pedido
        Button btnFinaliza = (Button)findViewById(R.id.btnFinaliza);
        btnFinaliza.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ComprasActivity.this, FreteActivity.class);
                intent.putExtra("Pedido", pedido);
                startActivity(intent);
            }
        });
    }
}
