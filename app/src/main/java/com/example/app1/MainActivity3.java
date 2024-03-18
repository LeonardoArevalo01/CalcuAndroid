package com.example.app1;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity3 extends AppCompatActivity {

    private EditText valor1;
    private EditText valor2;
    private TextView resultado;
    private View regresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main3);

        valor1 = findViewById(R.id.numero1);
        valor2 = findViewById(R.id.numero2);
        resultado = findViewById(R.id.respuesta);

        regresar = findViewById(R.id.regresarBtn);
        regresar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                finish();
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void restar(View view){
        String textoValor1 = valor1.getText().toString();
        String textoValor2 = valor2.getText().toString();

        if (textoValor1.isEmpty() || textoValor2.isEmpty()) {
            // Mostrar una alerta de error indicando que algún campo está vacío
            mostrarAlertaError("Uno de los campos está vacío");
            cerrarTeclado();
            return; // Salir del método ya que no se puede realizar
        }

        try {
            float resta= Float.parseFloat(textoValor1) - Float.parseFloat(textoValor2);
            resultado.setText(resta+"");
            cerrarTeclado();
        } catch (NumberFormatException e) {
            // Mostrar una alerta de error indicando que uno de los valores no es válido
            mostrarAlertaError("Uno de los valores no es válido");
            cerrarTeclado();
        }


    }

    private void mostrarAlertaError(String mensaje) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Error");
        builder.setMessage(mensaje);
        builder.setCancelable(true); // Permitir cerrar la alerta al tocar fuera de ella

        builder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss(); // Cerrar la alerta
            }
        });

        // Mostrar la alerta
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
    private void cerrarTeclado() {
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }
}