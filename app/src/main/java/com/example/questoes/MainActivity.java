package com.example.questoes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;


import com.example.questoes.model.Questoes;

import java.io.BufferedReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.jar.JarException;

public class MainActivity extends AppCompatActivity {


    RadioGroup grupoBotesPerguntas;
    RadioButton btnOp1;
    RadioButton btnOp2;
    RadioButton btnOp3;
    TextView telaPergunta;
    ArrayList<RadioButton> listRadioButtons;
    ArrayList<Questoes>listaQuestoes;

    private static final int btnOp1_ID = 1;//primeiro radio button id
    private static final int btnOp2_ID = 2;//segundo radio button id
    private static final int btnOp3_ID = 3;//terceiro radio button id
    String url = "http://www.json-generator.com/api/json/get/coUPnGlShu?indent=2";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        grupoBotesPerguntas=findViewById(R.id.radioGroupPerguntas);
        btnOp1=findViewById(R.id.radio_resposta01);
        btnOp2=findViewById(R.id.radio_resposta02);
        btnOp3=findViewById(R.id.radio_resposta03);
        telaPergunta=findViewById(R.id.textViewPergunta);



        btnOp1.setId(btnOp1_ID);
        btnOp2.setId(btnOp2_ID);
        btnOp3.setId(btnOp3_ID);
        listRadioButtons= new ArrayList<>();
        listRadioButtons.add(btnOp1);
        listRadioButtons.add(btnOp2);
        listRadioButtons.add(btnOp3);
        checaBotaoSelecionado();
       listaQuestoes=new ArrayList<>();









        grupoBotesPerguntas.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {


                int btn = grupoBotesPerguntas.getCheckedRadioButtonId();
                int qtdRespostas=3;




                switch (btn) {
                    case btnOp1_ID:

                        Log.i("Radio", "Radio 1");
                        checaBotaoSelecionado();

                        Toast.makeText(getApplicationContext(),String.valueOf(btnOp1.getId()),Toast.LENGTH_SHORT).show();


                        break;

                    case btnOp2_ID:
                        Log.i("Radio", "Radio 2");
                        checaBotaoSelecionado();

                        Toast.makeText(getApplicationContext(),String.valueOf(btnOp2.getId()),Toast.LENGTH_SHORT).show();


                        break;

                    case btnOp3_ID:
                        Log.i("Radio", "Radio 3");
                        checaBotaoSelecionado();

                        Toast.makeText(getApplicationContext(),String.valueOf(btnOp3.getId()),Toast.LENGTH_SHORT).show();

                        break;


                    default:
                        //caso precise colocar um botao para validar
                        break;
                }


            }
        });








        }
    private void checaBotaoSelecionado () {
        for (RadioButton radio : listRadioButtons) {
            Log.i("Radio", radio.toString() + " " + radio.isChecked());
            if (radio.isChecked())
                radio.setBackgroundColor(getResources().getColor(R.color.colorFundoRadioSelecionado));

            else {
                radio.setBackgroundColor(getResources().getColor(R.color.colorFundoRadioNaoSelecionado));

            }
        }

    }



}






