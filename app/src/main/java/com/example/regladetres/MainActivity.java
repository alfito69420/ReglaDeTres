package com.example.regladetres;

import android.content.DialogInterface;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //  Vistas
    private EditText tieNum1;
    private EditText tieNum2;
    private EditText tieNum3;
    private EditText tieNum4;

    private TextView tvResultado;

    private MaterialButton btnCalcular;
    private MaterialButton btnReset;

    private View calcularLayout;

    //  Variables
    private double resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calcularLayout = findViewById(R.id.calculo_layout);

        tieNum1 = calcularLayout.findViewById(R.id.til_num_1);
        tieNum2 = calcularLayout.findViewById(R.id.til_num_2);
        tieNum3 = calcularLayout.findViewById(R.id.til_num_3);
        tieNum4 = calcularLayout.findViewById(R.id.til_num_4);

        tieNum4.setEnabled(false);
        tieNum4.setInputType(InputType.TYPE_NULL);

        tvResultado = calcularLayout.findViewById(R.id.tv_resultado);
        btnCalcular = calcularLayout.findViewById(R.id.btn_calcular);
        btnReset = calcularLayout.findViewById(R.id.btn_reset);

        btnCalcular.setOnClickListener(this);
        btnReset.setOnClickListener(this);
    } //close oncreate

    private void calcular() {
        if (isEmpty(tieNum1) || isEmpty(tieNum2) || isEmpty(tieNum3)) {
            Toast.makeText(this, "No debe dejar ningún campo vacío."
                    , Toast.LENGTH_SHORT).show();
        } else {

            double num1 = Double.parseDouble(String.valueOf(tieNum1.getText()));
            double num2 = Double.parseDouble(String.valueOf(tieNum2.getText()));
            double num3 = Double.parseDouble(String.valueOf(tieNum3.getText()));

            if (num1 == 0 && num3 == 0) {
                Toast.makeText(this, "División incorrecta. No se puede dividir 0 entre 0."
                        , Toast.LENGTH_SHORT).show();
                //return;
            } else if (num1 == 0) {
                Toast.makeText(this, "No se puede dividir entre 0."
                        , Toast.LENGTH_SHORT).show();
                // return;
            }
            resultado = (num3 * num2) / num1;
        }

        tvResultado.setText("El valor de X es: \n" + resultado);
    } //close method

    private boolean isEmpty(final EditText myeditText) {
        return myeditText.getText().toString().trim().length() == 0;
    } //close method

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_calcular:
                calcular();
                break;
            case R.id.btn_reset:
                reset();
                break;
        }
    }

    private void reset() {

        if (tieNum1.length() == 0 && tieNum2.length() == 0 && tieNum3.length() == 0) {
            Toast.makeText(this, "No hay valores que resetear.", Toast.LENGTH_SHORT).show();
        } else {
            new MaterialAlertDialogBuilder(MainActivity.this,
                    com.google.android.material.R.style.MaterialAlertDialog_MaterialComponents_Title_Icon)
                    .setTitle("Resetear")
                    .setMessage("¿Está seguro que desea resetear los valores?")
                    .setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            tieNum1.setText("");
                            tieNum2.setText("");
                            tieNum3.setText("");


                        }
                    })
                    .setNegativeButton("Cancelar", null)
                    .show();

            Toast.makeText(this, "Valores reseteados exitosamente.", Toast.LENGTH_SHORT).show();
        }
    } //close method
} //close class