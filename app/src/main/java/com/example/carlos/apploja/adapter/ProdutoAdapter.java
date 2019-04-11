package com.example.carlos.apploja.adapter;

import android.app.Activity;
import android.content.Context;
import android.widget.BaseAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.carlos.apploja.R;
import com.example.carlos.apploja.model.Produto;

import java.util.List;

public class ProdutoAdapter extends BaseAdapter {

    private final List<Produto> lista;
    //private final Activity act;
    private Context context;

    //public ProdutoAdapter(List<Produto> lista, Activity act) {
    public ProdutoAdapter(List<Produto> lista, Context context) {
        this.lista = lista;
        this.context = context;
        //this.act = act;
    }

    @Override
    public int getCount() {
        return lista.size();    // total number of elements in the list
    }

    @Override
    public Object getItem(int i) {
        return lista.get(i);    // single item in the list
    }

    @Override
    public long getItemId(int i) {
        return i;                   // index number
    }

    @Override
    public View getView(int index, View view, final ViewGroup parent) {

        if (view == null) {
            //LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            view = inflater.inflate(R.layout.listview_produtos, parent, false);
        }

        //LayoutInflater inflater = act.getLayoutInflater();
        //view = inflater.inflate(R.layout.listview_produtos, parent, false);

        final Produto produto = lista.get(index);

        //TextView id = (TextView) view.findViewById(R.id.id);
        TextView nome = (TextView) view.findViewById(R.id.nome);
        TextView valor = (TextView) view.findViewById(R.id.valor);
        ImageView imagem = (ImageView) view.findViewById(R.id.imagem);

        //id.setText(String.valueOf(produto.getId()));
        nome.setText(produto.getNome());
        valor.setText(String.valueOf(produto.getValor()));
        String foto = produto.getImagem();
        imagem.setImageResource(R.drawable.produto);

        /*
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getBaseContext(), DetalheProdutoActivity.class);
                intent.putExtra("idProduto", produtoModel.getId());
                intent.putExtra("nomProduto", produtoModel.getNome());
                intent.putExtra("vlrProduto", produtoModel.getValor());
                intent.putExtra("imgProduto", produtoModel.getImagem());
                startActivity(intent);

                Toast.makeText(parent.getContext(), "view clicked: ", Toast.LENGTH_SHORT).show();
            }
        });
        */

        return view;
        //return layout;
    }
}
