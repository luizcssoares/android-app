package com.example.carlos.apploja;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import com.example.carlos.apploja.adapter.ProdutoAdapter;
import com.example.carlos.apploja.model.Pedido;
import com.example.carlos.apploja.model.Produto;
import com.example.carlos.apploja.retrofit.ServiceGenerator;
import com.example.carlos.apploja.service.ProdutoService;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProdutoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_produto);

        final Activity nova = this;
        final Context ctx = this;

        final ListView lista = (ListView) findViewById(R.id.listview_produtos);

        //final String API_BASE_URL = "https://luizcsoares.free.beeceptor.com/";
        //final String API_BASE_URL = "http://10.0.2.2:57780/";
        final String API_BASE_URL = "http://luizcssoares.gear.host/";

        ProdutoService service = ServiceGenerator.createService(ProdutoService.class, API_BASE_URL);

        Call<List<Produto>> apiCall = service.listarProduto();

        Toast.makeText(getApplicationContext(),"LENDO O SERVICO", Toast.LENGTH_LONG).show();

        apiCall.enqueue(new Callback<List<Produto>>() {
            @Override  // Em caso de sucesso
            public void onResponse(Call<List<Produto>> call, Response<List<Produto>> response) {
                List<Produto> listProduto = response.body();
                //ProdutoAdapter adapter = new ProdutoAdapter(listProduto, nova);
                ProdutoAdapter adapter = new ProdutoAdapter(listProduto,ctx);
                lista.setAdapter(adapter);
            }

            @Override  // Em caso de falha
            public void onFailure(Call<List<Produto>> call, Throwable t) {
                Toast.makeText(getApplicationContext(),"ERROR CHAMADA SERVIDOR", Toast.LENGTH_LONG).show();
                t.printStackTrace();
            }
        });
        // fim lista Produtos

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapter, View view,
                                    int posicao, long id) {

                final Pedido pedido = (Pedido) getIntent().getSerializableExtra("Pedido");

                //Cursor p = (Cursor) lista.getItemAtPosition(posicao);
                Produto p = (Produto) adapter.getItemAtPosition(posicao);

                Intent intent = new Intent(getBaseContext(), DetalheProdutoActivity.class);
                intent.putExtra("idProd", String.valueOf(p.getId()));
                intent.putExtra("nomProd", p.getNome().toString());
                intent.putExtra("vlrProd", String.valueOf(p.getValor()));
                intent.putExtra("imgProd", p.getImagem().toString());

                intent.putExtra("Pedido", pedido);
                startActivity(intent);

                //Toast.makeText(Lista.this, "Posição Selecionada:" + posicao, Toast.LENGTH_LONG).show();
            }
        });

    }
}
