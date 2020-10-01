package matheus.senai.projetocantina;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class BancoInterno extends SQLiteOpenHelper {

    private final String tabelaCardapio =
        "CREATE TABLE Cardapio (" +
        "Codigo INTEGER PRIMARY KEY autoincrement," +
        "DiaSemana VARCHAR(20) NOT NULL," +
        "Nome VARCHAR(20) NOT NULL," +
        "Composicao VARCHAR(200)," +
        "Preco VARCHAR(10) NOT NULL);";

    private final String tabelaProduto =
            "CREATE TABLE produtos (" +
                    "Codigo INTEGER PRIMARY KEY autoincrement," +
                    "nome VARCHAR(90) NOT NULL," +
                    "descricao VARCHAR(50) NOT NULL," +
                    "vencimento VARCHAR(200)," +
                    "preco VARCHAR(18) NOT NULL);";

    public BancoInterno (Context context, int version){
        super(context, "BD_cantinaapp",null,version);
    }


    public boolean insereDados(){
        SQLiteDatabase banco = getWritableDatabase();
        ContentValues valor = new ContentValues();

        valor.put("nome","salgado frito");
        valor.put("descricao","Salgado");
        valor.put("vencimento","09-05-2019");
        valor.put("preco","9.33");

        if(banco.insert("produtos",null,valor) != -1){
            banco.close();
            return true;
        }else{
            banco.close();
            return false;
        }
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(tabelaProduto);
        db.execSQL(tabelaCardapio);
    }

    @Override
    public void onOpen(SQLiteDatabase db) {
        super.onOpen(db);
        db.execSQL("PRAGMA foreign_keys = ON");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
