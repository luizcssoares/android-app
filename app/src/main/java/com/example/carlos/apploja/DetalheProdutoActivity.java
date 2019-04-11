package com.example.carlos.apploja;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.carlos.apploja.model.ItemPedido;
import com.example.carlos.apploja.model.Pedido;

import java.util.ArrayList;
import java.util.List;

public class DetalheProdutoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe_produto);

        final String idProd  = getIntent().getStringExtra("idProd");
        String nomeProd      = getIntent().getStringExtra("nomProd");
        String valorProd     = getIntent().getStringExtra("vlrProd");
        String imagemProd    = getIntent().getStringExtra("imgProd");

        final TextView nome  = (TextView) findViewById(R.id.nome);
        final TextView valor = (TextView) findViewById(R.id.valor);
        final TextView qtde  = (TextView) findViewById(R.id.qtde);

        nome.setText(nomeProd);
        valor.setText(valorProd);
        qtde.setText("1");

        final Double  vlrProd_  = Double.parseDouble(valor.getText().toString());
        final Integer qtdProd_  = Integer.parseInt(qtde.getText().toString());

        Button btnAdiciona = (Button)findViewById(R.id.btnAdiciona);
        btnAdiciona.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                 ItemPedido item = new ItemPedido();
                 item.setNome(nome.getText().toString());
                 item.setIdprod(Long.parseLong(idProd));
                 item.setQtde(Integer.parseInt(qtde.getText().toString()));
                 item.setValor(Double.parseDouble(valor.getText().toString()));
                 item.setValoritem(qtdProd_ * vlrProd_);

                 // Checa se pedido ja criado
                 Pedido pedido = (Pedido) getIntent().getSerializableExtra("Pedido");
                 if (pedido == null) {
                    pedido = new Pedido();
                 }
                 // Cria item do pedido e insere no pedido
                 List<ItemPedido> itensPedido = pedido.getItens();
                 if (itensPedido == null) {
                     itensPedido = new ArrayList<ItemPedido>();
                 }
                 itensPedido.add(item);
                 pedido.setItens(itensPedido);

                 Intent intent = new Intent(getBaseContext(), ComprasActivity.class);
                 intent.putExtra("Pedido", pedido);
                 startActivity(intent);
            }
        });
    }
}
