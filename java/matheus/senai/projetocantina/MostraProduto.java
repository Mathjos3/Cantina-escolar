package matheus.senai.projetocantina;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MostraProduto extends AppCompatActivity {

    private RecyclerView mList;

    private LinearLayoutManager linearLayoutManager;
    private DividerItemDecoration dividerItemDecoration;
    private List<Produto> produtoList;
    private RecyclerView.Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostra_produto);

        mList = findViewById(R.id.main_list);

        produtoList = new ArrayList<>();
        adapter = new ProdutoAdapter(getApplicationContext(),produtoList);

        linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        dividerItemDecoration = new DividerItemDecoration(mList.getContext(), linearLayoutManager.getOrientation());

        mList.setHasFixedSize(true);
        mList.setLayoutManager(linearLayoutManager);
        mList.addItemDecoration(dividerItemDecoration);
        mList.setAdapter(adapter);


        pegaDados(); //chama o metodo

    }

    //Método para pegar dados dos produtos no banco
    public void pegaDados(){

        final String Categoria  = getIntent().getStringExtra("Categoria");

        //Objeto que irá fazer a requisição na URL
        RequestQueue rq = Volley.newRequestQueue(MostraProduto.this);

        String urlWebService = "" + "http://10.87.104.9/webservicecantinamatheus/webservice.asmx/listaPersonalizadaProduto";

        //Chamada ao WebService
        StringRequest sr = new StringRequest(Request.Method.POST, urlWebService, new Response.Listener<String>() {
            @Override
            public void onResponse(String resposta) {

                try {

                    JSONArray lista = new JSONArray(resposta);

                    for (int i=0; i<lista.length(); i++){

                        JSONObject obj = lista.getJSONObject(i);

                        Produto produto = new Produto();

                        produto.setNome(obj.getString("Nome"));
                        produto.setVencimento(obj.getString("Vencimento"));
                        produto.setDescricao(obj.getString("Descricao"));
                        produto.setPreco(obj.getString("Preco"));

                        produtoList.add(produto);
                    }

                }catch (JSONException e){
                    e.printStackTrace();
                }

                adapter.notifyDataSetChanged();

                Log.d("TESTE_WS",resposta);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                //quando ocorrer algum erro na conexao
                Log.d("TESTE_WS", error.toString());
            }

        }) {
            protected Map<String,String> getParams(){
                //passagem de parâmetro para o método do webService
                Map<String, String> parametro = new HashMap<String, String>();

                parametro.put("Categoria",Categoria); //passando parametro
                return parametro;

            }
        };

        //executa o comando e envia os dados para webservice
        rq.add(sr);

    }


}
