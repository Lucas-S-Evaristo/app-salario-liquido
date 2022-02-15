package br.senai.sp.cotia.app_salario_liq;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btCalcular = (Button) findViewById(R.id.btCalcular);
        btCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double salario, novo_sal = 0;
                EditText cpSalario = (EditText) findViewById(R.id.cpSalario);
                salario = Double.parseDouble(cpSalario.getText().toString());
                RadioGroup rg = (RadioGroup) findViewById(R.id.rgSaude);

                int op = rg.getCheckedRadioButtonId();
                if (op == R.id.rdStandart && salario <= 3000){
                    novo_sal = salario - 60;
                } else if (op == R.id.rdStandart && salario > 3000) {
                    novo_sal = salario - 80;
                } else if (op == R.id.rdBasico && salario <= 3000) {
                    novo_sal = salario - 80;
                } else if (op == R.id.rdBasico && salario > 3000) {
                    novo_sal = salario - 110;
                } else if (op == R.id.rdSuper && salario <= 3000) {
                    novo_sal = salario - 95;
                } else if (op == R.id.rdSuper && salario > 3000) {
                    novo_sal = salario - 135;
                } else if (op == R.id.rdMaster && salario <= 3000) {
                    novo_sal = salario - 130;
                } else {
                    novo_sal = salario - 180;
                }

                RadioGroup rg2 = (RadioGroup) findViewById(R.id.rgVT);

                int op2 = rg2.getCheckedRadioButtonId();
                if (op2 == R.id.simVT) {
                    novo_sal = salario - 0.06;
                } else if (op2 == R.id.naoVT) {
                    novo_sal = salario;
                }

                RadioGroup rg3 = (RadioGroup) findViewById(R.id.rgVA);

                int op3 = rg3.getCheckedRadioButtonId();
                if (op3 == R.id.simVA && salario <=3000) {
                    novo_sal = salario - 15;
                } else if (op3 == R.id.simVA && salario <=5000) {
                    novo_sal = salario - 25;
                } else if (op3 == R.id.simVA && salario > 5000) {
                    novo_sal = salario - 35;
                }

            }
        });
    }

}