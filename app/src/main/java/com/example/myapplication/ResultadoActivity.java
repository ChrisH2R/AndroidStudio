package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultadoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        // Obtén el resultado pasado desde MainActivity
        double resultado = getIntent().getDoubleExtra("resultado", 0.0);

        // Encuentra el TextView en el diseño de la actividad
        TextView textViewResultado = findViewById(R.id.getresult);

        // Muestra el resultado en el TextView
        textViewResultado.setText("Resultado: " + resultado);

        // Encuentra el botón "backbtn" en el diseño de la actividad
        Button btnVolver = findViewById(R.id.backbtn);

        // Configura la acción para volver a MainActivity al hacer clic en el botón
        btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Vuelve a la actividad principal (MainActivity)
                Intent intent = new Intent(ResultadoActivity.this, MainActivity.class);
                startActivity(intent);
                finish(); // Cierra la actividad actual
            }
        });
    }
}
