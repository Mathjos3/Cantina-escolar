package matheus.senai.projetocantina;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class MostraCardapio extends AppCompatActivity {

    private TextView CardapioTitulo,txtTitulo,txtComposicao,txtPreco;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostra_cardapio);

        CardapioTitulo = findViewById(R.id.CardapioTitulo);

        txtTitulo = findViewById(R.id.txtTitulo);
        txtComposicao = findViewById(R.id.txtComposicao);
        txtPreco = findViewById(R.id.txtPrecop);

        String titulo = getIntent().getStringExtra("DiaSemana");//pega valor do intent
        CardapioTitulo.setText(titulo);

        preencheCardapio();

    }

    public void preencheCardapio(){

        final String Dia  = getIntent().getStringExtra("DiaSemana");

        //Objeto que irá fazer a requisição na URL
        RequestQueue rq = Volley.newRequestQueue(MostraCardapio.this);

        String urlWebService = "" + "http://10.87.104.9/webservicecantinamatheus/webservice.asmx/listaCardapio";


        //Chamada ao WebService
        StringRequest sr = new StringRequest(Request.Method.POST, urlWebService, new Response.Listener<String>() {
            @Override
            public void onResponse(String resposta) {
                //Quando chamar o webservice e conectar corretamente

                //Convertendo JSON
                try {

                    JSONArray lista = new JSONArray(resposta);

                    for (int i=0; i<lista.length(); i++){
                        JSONObject obj = lista.getJSONObject(i);

                        Cardapio c = new Cardapio(obj.getString("DiaSemana"),obj.getString("Nome"),obj.getString("Composicao"),obj.getString("Preco"));

                        //Mostrando objeto JSON nos edittexts
                        txtTitulo.setText(c.getNome());
                        txtComposicao.setText(c.getComposicao());
                        txtPreco.setText(c.getPreco());
                    }

                }catch (JSONException e){
                    e.printStackTrace();
                }

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

                parametro.put("DiaSemana",Dia); //passando parametro
                return parametro;

            }
        };

        //executa o comando e envia os dados para webservice

        rq.add(sr);

    }

}
