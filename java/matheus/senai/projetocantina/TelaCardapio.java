package matheus.senai.projetocantina;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Arrays;
import java.util.List;

public class TelaCardapio extends AppCompatActivity {

    private Button btSegunda,btTerca,btQuarta,btQuinta,btSexta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_cardapio);

        btSegunda = findViewById(R.id.btSegunda);
        btTerca = findViewById(R.id.btTerca);
        btQuarta = findViewById(R.id.btQuarta);
        btQuinta = findViewById(R.id.btQuinta);
        btSexta = findViewById(R.id.btSexta);

        btSegunda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(getApplicationContext(),MostraCardapio.class);
                i.putExtra("DiaSemana","Segunda-Feira");
                startActivity(i);
            }
        });

        btTerca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(getApplicationContext(),MostraCardapio.class);
                i.putExtra("DiaSemana","Terça-Feira");
                startActivity(i);
            }
        });

        btQuarta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(getApplicationContext(),MostraCardapio.class);
                i.putExtra("DiaSemana","Quarta-Feira");
                startActivity(i);
            }
        });

        btQuinta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(getApplicationContext(),MostraCardapio.class);
                i.putExtra("DiaSemana","Quinta-Feira");
                startActivity(i);
            }
        });

        btSexta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(getApplicationContext(),MostraCardapio.class);
                i.putExtra("DiaSemana","Sexta-Feira");
                startActivity(i);
            }
        });

    }
}
