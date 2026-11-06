package com.example.testmd;

import static android.view.View.INVISIBLE;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    protected static ArrayList<Pytanie> pytanieArrayList;
    private ImageView imageView;
    private Button buttonTak, buttonNie, buttonNastepny, buttonPodpowiedz;
    private TextView textViewPytanie;
    private int ktorepytanie = 0;
    private int punkty = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        wystawPytania();
        imageView = findViewById(R.id.imageView2);
        textViewPytanie = findViewById(R.id.textWiew);
        buttonTak = findViewById(R.id.buttonTak);
        buttonNie = findViewById(R.id.buttonNie);
        buttonNastepny = findViewById(R.id.buttonNastepne);
        buttonPodpowiedz = findViewById(R.id.buttonPodpowiedz);
        wyswietlPytanie(0);
        buttonPodpowiedz.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        //intencja jawna, wiemy za pomoca czego ja wykonamy
                        Intent intent = new Intent(MainActivity.this, PodpowiedzActivity.class);
                        intent.putExtra("NrPytania", ktorepytanie);
                        startActivity(intent);
                    }
                }
        );
        buttonNastepny.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        ktorepytanie++;

                        if (ktorepytanie<pytanieArrayList.size()){
                            wyswietlPytanie(ktorepytanie);
                        }
                        else {
                            buttonNastepny.setVisibility(INVISIBLE);

                            for (Pytanie pytanie:pytanieArrayList) {
                                if (pytanie.isPoprawnaOdpowiedz()){
                                    punkty++;
                                }
                            }
                            textViewPytanie.setText("Koniec testu, otrzymano "+punkty+" punkty");
                        }
                    }
                }
        );
        buttonTak.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        ustawOdpowiedz(true);
                    }
                }
        );

        buttonNie.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        ustawOdpowiedz(false);
                    }
                }
        );

    }
    private void ustawOdpowiedz(boolean odp){
        if (odp == pytanieArrayList.get(ktorepytanie).isOdpowiedz()){
            pytanieArrayList.get(ktorepytanie).setCzyPoprawnaOdpowiedz(true);
        }
        else {
            pytanieArrayList.get(ktorepytanie).setCzyPoprawnaOdpowiedz(false);
        }
    }

    private void wyswietlPytanie(int ktore){
        Pytanie pytanie = pytanieArrayList.get(ktore);
        imageView.setImageResource(pytanie.getIdZdjecia());
        textViewPytanie.setText(pytanie.getTrescPytania());
    }
    private void wystawPytania(){
        pytanieArrayList = new ArrayList<>();
        pytanieArrayList.add(new Pytanie(R.drawable.auto, "Czy te auto to Audi", false, "Spojrz na znaczek"));
        pytanieArrayList.add(new Pytanie(R.drawable.jabko, "Czy jablko jest popularne w Polsce", true, "Sprawdz w sklepach"));
        pytanieArrayList.add(new Pytanie(R.drawable.flaga, "Czy to jest flaga Niemiec", false, "Zobacz na mapie"));
    }
}