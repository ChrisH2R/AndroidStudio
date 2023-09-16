package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText campoValor;
    private EditText campoTotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        campoValor = findViewById(R.id.valor);
        campoTotal = findViewById(R.id.total);

        Button btnLimpiar = findViewById(R.id.clearbtn);
        btnLimpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                limpiarCampos();
            }
        });

        Button btnCalcular = findViewById(R.id.matchbtn);
        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcularCostoTotal();
            }
        });
    }

    private void limpiarCampos() {
        campoValor.setText("");
        campoTotal.setText("");
    }

    private void calcularCostoTotal() {
        String strValor = campoValor.getText().toString();
        String strTotal = campoTotal.getText().toString();

        if (strValor.isEmpty() || strTotal.isEmpty()) {
            Toast.makeText(this, "Por favor, ingresa ambos valores.", Toast.LENGTH_SHORT).show();
            return;
        }

        double valor = Double.parseDouble(strValor);
        double total = Double.parseDouble(strTotal);

        double costoTotal = valor * total;

        // Configura un Intent para abrir ResultadoActivity y pasa el resultado como extra
        Intent intent = new Intent(this, ResultadoActivity.class);
        intent.putExtra("resultado", costoTotal);
        startActivity(intent);
    }

}
