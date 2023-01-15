package cat.dam.ivan.expesimc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity
{

    private EditText et_alsada, et_pes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void calculaImc(View v){

        //agafem les dades introduides en els 2 edit text
        et_alsada = (EditText) findViewById(R.id.et_alsada);
        et_pes = (EditText) findViewById(R.id.et_pes);

        //convertim les dades a double
        double alsada = Double.parseDouble(et_alsada.getText().toString());
        double pes = Double.parseDouble(et_pes.getText().toString());
        //calculem l'imc fent la operació
        //double alsadaElevada = Math.pow(alsada, 2);
        double alsadaElevada = alsada * alsada;
        double imc = pes/alsadaElevada;

        //intent per obrir la segona activitat
        Intent intent = new Intent(this, SecondActivity.class);
        Bundle bundle = new Bundle();
        // posem les dades a enviar en el bundle
        bundle.putDouble("alsada", alsada);
        bundle.putDouble("pes", pes);
        bundle.putDouble("imc", imc);
        intent.putExtras(bundle);
        // iniciem l’activitat
        startActivity(intent);
    }

}