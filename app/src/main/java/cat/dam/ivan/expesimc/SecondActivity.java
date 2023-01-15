package cat.dam.ivan.expesimc;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity
{
    private TextView tv_pes, tv_alcada, tv_imc, tv_grup;
    private ImageView iv_imc;

    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultats);

        iv_imc = (ImageView) findViewById(R.id.iv_grups);
        tv_pes = (TextView) findViewById(R.id.tv_pes);
        tv_alcada = (TextView) findViewById(R.id.tv_alcada);
        tv_imc = (TextView) findViewById(R.id.tv_imc);
        tv_grup = (TextView) findViewById(R.id.tv_grups);

        //intent per agafar les dades de la primera activitat
        Intent intent = new Intent(this, MainActivity.class);

        //agafem les dades del bundle amb un valor per defecte
        double pes = getIntent().getDoubleExtra("pes", 0);
        double alsada = getIntent().getDoubleExtra("alsada", 0);
        double imc = getIntent().getDoubleExtra("imc", 0);

        //posem els valors rebuts dels edit texts als textViews:
        tv_pes.setText(Double.toString(pes));
        tv_alcada.setText(Double.toString(alsada));
        //posem el resultat de l'imc amb un maxim de 2 decimals
        tv_imc.setText(String.format("%.2f",imc));

        //calculem el grup al que pertany l'usuari segons el imc
        classificacioIMC(imc);
    }

    /**
     * Funcio que calcula el grup al que pertany l'usuari segons el seu imc
     * @param imc imc de l'usuari
     * @return grup al que pertany l'usuari
     */
    public double classificacioIMC(double imc)
    {
        //calculem el grup al que pertany l'usuari segons el imc amb aquestes condicions
        if(imc < 18.5)
        {
            tv_grup.setText(R.string.pes_1);
            iv_imc.setImageResource(R.drawable.nivell1);
        }
        else if(imc >= 18.5 && imc <= 24.9)
        {
            tv_grup.setText(R.string.pes_2);
            iv_imc.setImageResource(R.drawable.nivell2);
        }
        else if(imc >= 25 && imc <= 26.9)
        {
            tv_grup.setText(R.string.pes_3);
            iv_imc.setImageResource(R.drawable.nivell3);
        }
        else if(imc >= 27 && imc <= 29.9)
        {
            tv_grup.setText(R.string.pes_4);
            iv_imc.setImageResource(R.drawable.nivell4);
        }
        else if(imc >= 30 && imc <= 34.9)
        {
            tv_grup.setText(R.string.pes_5);
            iv_imc.setImageResource(R.drawable.nivell5);
        }
        else if(imc >= 35 && imc <= 39.9)
        {
            tv_grup.setText(R.string.pes_6);
            iv_imc.setImageResource(R.drawable.nivell6);
        }
        else if(imc >= 40 && imc <= 49.9)
        {
            tv_grup.setText(R.string.pes_7);
            iv_imc.setImageResource(R.drawable.nivell7);
        }
        else if(imc > 50)
        {
            tv_grup.setText(R.string.pes_8);
            iv_imc.setImageResource(R.drawable.nivell8);
        }

        return imc;
    }

    public void backButton(View v) {
        // intent per tornar a l'activitat anterior
        Intent intent = new Intent(SecondActivity.this, MainActivity.class);
        // iniciem lintent
        startActivity(intent);
    }

}
