package matheus.senai.projetocantina;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private ImageButton btCardapio,btSalgado,btLanche,btBebida;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btCardapio = findViewById(R.id.btCardapio);
        btSalgado = findViewById(R.id.btSalgado);
        btLanche = findViewById(R.id.btLanche);
        btBebida = findViewById(R.id.btBebida);

        //Ação do botão Cardápio
        btCardapio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),TelaCardapio.class);
                startActivity(i);
            }
        });

        //Ação do botão mostra Salgado
        btSalgado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),MostraProduto.class);
                i.putExtra("Categoria","Salgado");
                startActivity(i);
            }
        });

        //Ação do botão mostra Lanche
        btLanche.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),MostraProduto.class);
                i.putExtra("Categoria","Lanche");
                startActivity(i);
            }
        });

        //Ação do botão mostra Bebida
        btBebida.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),MostraProduto.class);
                i.putExtra("Categoria","Bebida");
                startActivity(i);
            }
        });

    }

}
