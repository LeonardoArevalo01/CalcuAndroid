package com.example.app1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void cambiar_suma(View view){
        Intent c = new Intent(this, MainActivity2.class);
        startActivity(c);
    }

    public void cambiar_resta(View view){
        Intent c = new Intent(this, MainActivity3.class);
        startActivity(c);
    }

    public void cambiar_multiplicacion(View view){
        Intent c = new Intent(this, MainActivity4.class);
        startActivity(c);
    }

    public void cambiar_division(View view){
        Intent c = new Intent(this, MainActivity5.class);
        startActivity(c);
    }

    public void cambiar_factorial(View view){
        Intent c = new Intent(this, MainActivity6.class);
        startActivity(c);
    }

    public void cambiar_potencia(View view){
        Intent c = new Intent(this, MainActivity7.class);
        startActivity(c);
    }

    public void cambiar_fibonacci(View view){
        Intent c = new Intent(this, MainActivity8.class);
        startActivity(c);
    }
}

