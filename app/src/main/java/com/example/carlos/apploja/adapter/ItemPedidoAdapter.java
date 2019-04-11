package com.example.carlos.apploja.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.carlos.apploja.R;
import com.example.carlos.apploja.model.ItemPedido;

import java.util.List;

public class ItemPedidoAdapter extends BaseAdapter {

    private final List<ItemPedido> lista;
    //private final Activity act;
    private Context context;

    //public ProdutoAdapter(List<Produto> lista, Activity act) {
    public ItemPedidoAdapter(List<ItemPedido> lista, Context context) {
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
            view = inflater.inflate(R.layout.listview_itemproduto, parent, false);
        }

        final ItemPedido item = lista.get(index);

        //TextView id = (TextView) view.findViewById(R.id.id);
        TextView nome = (TextView) view.findViewById(R.id.nome);
        TextView valor = (TextView) view.findViewById(R.id.valor);
        TextView qtde = (TextView) view.findViewById(R.id.qtde);
        TextView valoritem = (TextView) view.findViewById(R.id.valoritem);
        ImageView imagem = (ImageView) view.findViewById(R.id.imagem);

        //id.setText(String.valueOf(produto.getId()));
        nome.setText(item.getNome());
        valor.setText(String.valueOf(item.getValor()));
        qtde.setText(String.valueOf(item.getQtde()));
        valoritem.setText(String.valueOf(item.getValor() * item.getQtde()));
        imagem.setImageResource(R.drawable.produto);

        return view;
    }
}
