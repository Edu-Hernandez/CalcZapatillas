package com.example.calczapatillas;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import android.view.Menu;
import android.app.Activity;
import androidx.appcompat.app.AppCompatActivity;
import androidx.activity.EdgeToEdge;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import EMPRESA.ANDROID.DAO.*;
import EMPRESA.ANDROID.BEAN.*;
import android.content.Intent;


public class ResultadoFinal extends MainActivity implements View.OnClickListener{
    EditText txtFinalmarca, txtFinaltalla, txtFinalnum, txtFinalOperaciones;
    Button btnVolver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado_final);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        txtFinalmarca = findViewById(R.id.txtFinalmarca);
        txtFinaltalla = findViewById(R.id.txtFinaltalla);
        txtFinalnum = findViewById(R.id.txtFinalnum);
        txtFinalOperaciones = findViewById(R.id.txtFinalOperaciones);
        btnVolver = findViewById(R.id.btnVolver);

        // Establece el OnClickListener para el botón Volver
        btnVolver.setOnClickListener(this);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            String marca = bundle.getString("MARCA");
            String talla = bundle.getString("TALLA");
            String numpares = bundle.getString("NUMPARES");
            String resultado = bundle.getString("RESULTADO");
            txtFinalmarca.setText(marca);
            txtFinaltalla.setText(talla);
            txtFinalnum.setText(numpares);
            txtFinalOperaciones.setText(resultado);
        }
    }
    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnVolver) {
            // Aquí iniciamos la actividad MainActivity
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            // Finalizamos la actividad ResultadoFinal
            finish();
        }
    }


}