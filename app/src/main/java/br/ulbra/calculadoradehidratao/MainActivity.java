package br.ulbra.calculadoradehidratao;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    EditText edPeso, edIdade, edAguaConsumida;

    Button btCalcular;

    RadioButton rbSedentario, rbModerado, rbIntenso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        edPeso = findViewById(R.id.edtPeso);
        edIdade = findViewById(R.id.edtIdade);
        edAguaConsumida = findViewById(R.id.edtAguaCon);
        rbSedentario = findViewById(R.id.rbtSedentario);
        rbModerado = findViewById(R.id.rbtModerado);
        rbIntenso = findViewById(R.id.rbtIntenso);
        btCalcular = findViewById(R.id.btnCalcular);
        btCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double peso, consumoBase, consumoTotal, consumoRes;

                int aguaConsumida, sedentario, moderado, inteso;

                sedentario = 0;
                moderado = 300;
                inteso = 600;


                if (edPeso.getText().toString().isEmpty() || edIdade.getText().toString().isEmpty()) {
                    Toast.makeText(MainActivity.this, "Os capos de peso e idade devem conter algo", Toast.LENGTH_LONG).show();
                } else if (Double.parseDouble(edPeso.getText().toString()) <= 0) {
                    Toast.makeText(MainActivity.this, "Tu é um papel ? 🤨", Toast.LENGTH_SHORT).show();
                } else if (!(Integer.parseInt(edIdade.getText().toString()) > 0)) {
                    Toast.makeText(MainActivity.this, "Tabom ser de outro plano que consegue mexer no celular sem um cerebro minimamente desenvolvido", Toast.LENGTH_SHORT).show();
                } else if (rbSedentario.isSelected()) {

                    aguaConsumida = Integer.parseInt(edIdade.getText().toString());
                    peso = Double.parseDouble(edPeso.getText().toString());

                    String res1;

                    consumoBase = peso * 35;
                    consumoTotal = consumoBase + sedentario;
                    consumoRes = consumoTotal - aguaConsumida;

                    DecimalFormat df = new DecimalFormat("0.00");

                    res1 = "\nIdade:" + edIdade.getText() +
                            "\nMeta Diária:" + df.format(consumoTotal) + " ml" +
                            "\nCusto Estimado: R$" + df.format(consumoRes);

                    AlertDialog.Builder dialogo = new AlertDialog.Builder(MainActivity.this);
                    dialogo.setTitle("Resultado");
                    dialogo.setMessage(res1);
                    dialogo.setNeutralButton("OK", null);
                    dialogo.show();

                } else if (rbModerado.isSelected()) {


                    aguaConsumida = Integer.parseInt(edIdade.getText().toString());
                    peso = Double.parseDouble(edPeso.getText().toString());

                    String res1;

                    consumoBase = peso * 35;
                    consumoTotal = consumoBase + moderado;
                    consumoRes = consumoTotal - aguaConsumida;

                    DecimalFormat df = new DecimalFormat("0.00");

                    res1 = "\nIdade:" + edIdade.getText() +
                            "\nMeta Diária:" + df.format(consumoTotal) + " ml" +
                            "\nCusto Estimado: R$" + df.format(consumoRes);

                    AlertDialog.Builder dialogo1 = new AlertDialog.Builder(MainActivity.this);
                    dialogo1.setTitle("Resultado");
                    dialogo1.setMessage(res1);
                    dialogo1.setNeutralButton("OK", null);
                    dialogo1.show();
                } else {


                    aguaConsumida = Integer.parseInt(edIdade.getText().toString());
                    peso = Double.parseDouble(edPeso.getText().toString());

                    String res1;

                    consumoBase = peso * 35;
                    consumoTotal = consumoBase + inteso;
                    consumoRes = consumoTotal - aguaConsumida;

                    DecimalFormat df = new DecimalFormat("0.00");

                    res1 = "\nIdade:" + edIdade.getText() +
                            "\nMeta Diária:" + df.format(consumoTotal) + " ml" +
                            "\nCusto Estimado: R$" + df.format(consumoRes);

                    AlertDialog.Builder dialogo2 = new AlertDialog.Builder(MainActivity.this);
                    dialogo2.setTitle("Resultado");
                    dialogo2.setMessage(res1);
                    dialogo2.setNeutralButton("OK", null);
                    dialogo2.show();
                }
            }
        });
    }
}