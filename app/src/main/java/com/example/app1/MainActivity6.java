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

public class MainActivity6 extends AppCompatActivity {

    private EditText valor1;
    private TextView resultado;
    private View regresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main6);

        valor1 = findViewById(R.id.numero1);
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
    public void factorial(View view){
        String textoValor1 = valor1.getText().toString();

        if (textoValor1.isEmpty()) {
            // Mostrar una alerta de error indicando que algún campo está vacío
            mostrarAlertaError("El campo esta vacio");
            cerrarTeclado();
            return; // Salir del método ya que no se puede realizar
        }


        try {
            float factor= Factorial.calcularFactorial(Float.parseFloat(textoValor1));
            resultado.setText(factor+"");
            cerrarTeclado();
        } catch (NumberFormatException e) {
            // Mostrar una alerta de error indicando que uno de los valores no es válido
            mostrarAlertaError("El valor no es válido");
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