package com.example.regladetres;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {

    private TextInputLayout tilNum1;
    private TextInputLayout tilNum3;
    private TextInputLayout tilNum2;

    private TextInputEditText tieNum1;
    private TextInputEditText tieNum2;
    private TextInputEditText tieNum3;
    private TextInputEditText tieNum4;

    private TextView tvResultado;

    private Button btnCalcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tieNum1 = findViewById(R.id.tie_num1);
        tieNum2 = findViewById(R.id.tie_num2);
        tieNum3 = findViewById(R.id.tie_num3);
        tieNum4 = findViewById(R.id.tie_num4);

        tieNum4.setEnabled(false);
        tieNum4.setInputType(InputType.TYPE_NULL);

        tvResultado = findViewById(R.id.tv_resultado);
        btnCalcular = findViewById(R.id.btn_calcular);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calcular();
            }
        });
    } //close oncreate

    private void calcular() {
        double num1 = Double.parseDouble(String.valueOf(tieNum1.getText()));
        double num2 = Double.parseDouble(String.valueOf(tieNum2.getText()));
        double num3 = Double.parseDouble(String.valueOf(tieNum3.getText()));

        double resultado = (num3 * num2) / num1;

        tvResultado.setText("El valor de X es: " + resultado);
    } //close method
} //close class