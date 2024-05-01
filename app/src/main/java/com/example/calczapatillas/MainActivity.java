package com.example.calczapatillas;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.view.Menu;
import android.app.Activity;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import EMPRESA.ANDROID.DAO.*;
import EMPRESA.ANDROID.BEAN.*;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Spinner spnmarca, spntalla;
    EditText txtnumpares;
    Button btnCalcular;
    ProductBean objProductoBean;
    ProductDAO objProductoDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        spnmarca = findViewById(R.id.spnmarca);
        spntalla = findViewById(R.id.spntalla);
        txtnumpares = findViewById(R.id.txtnumpares);
        btnCalcular = findViewById(R.id.btnCalcular);
        btnCalcular.setOnClickListener(this);
    }

    public void Calcular(){
        int marca = spnmarca.getSelectedItemPosition();
        int talla = spntalla.getSelectedItemPosition();
        String numparescad = txtnumpares.getText().toString();
        int numpares = Integer.parseInt(numparescad);

        if (numpares <= 0 ) {
            Toast.makeText(this, "El número de pares debe ser mayor que cero", Toast.LENGTH_SHORT).show();
            return;
        }


        objProductoBean = new ProductBean();
        objProductoBean.setMarca(marca);
        objProductoBean.setTalla(talla);
        objProductoBean.setNumpares(numpares);

        objProductoDAO = new ProductDAO();
        String mensaje = objProductoDAO.CalcularOperacion(objProductoBean);
        // Establecer el resultado en txtFinalOperaciones en lugar de txtResultado
        Intent intent = new Intent(this, ResultadoFinal.class);
        intent.putExtra("MARCA", spnmarca.getSelectedItem().toString());
        intent.putExtra("TALLA", spntalla.getSelectedItem().toString());
        intent.putExtra("NUMPARES", numparescad);
        intent.putExtra("RESULTADO", mensaje);
        startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        Calcular();
    }


}