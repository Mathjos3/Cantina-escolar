package matheus.senai.projetocantina;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class ProdutoAdapter extends RecyclerView.Adapter<ProdutoAdapter.ViewHolder> {

    private Context context;
    private List<Produto> list;

    public ProdutoAdapter (Context context, List<Produto> list){
        this.context = context;
        this.list = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item_produto, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Produto p = list.get(position);

        holder.txtTitulo.setText(p.getNome());
        holder.txtDescricao.setText(p.getDescricao());
        holder.txtValidade.setText("Vence em : " + p.getVencimento());
        holder.txtPreco.setText("R$" + p.getPreco());


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView txtTitulo, txtDescricao, txtValidade, txtPreco;

        public ViewHolder(View itemView) {
            super(itemView);

            txtTitulo = itemView.findViewById(R.id.txtTitulo);
            txtDescricao = itemView.findViewById(R.id.txtDescricao);
            txtValidade = itemView.findViewById(R.id.txtValidade);
            txtPreco = itemView.findViewById(R.id.txtPreco);

        }
    }


}
