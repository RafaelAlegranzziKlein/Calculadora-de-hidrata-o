package br.ulbra.calculadoradehidratao;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
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

    RadioGroup rgGrupo1;

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
        rgGrupo1 = findViewById(R.id.rgBotao);
        btCalcular = findViewById(R.id.btnCalcular);
        btCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 1. Verificação de campos vazios (incluindo a água consumida)
                if (edPeso.getText().toString().isEmpty() ||
                        edIdade.getText().toString().isEmpty() ||
                        edAguaConsumida.getText().toString().isEmpty()) {
                    Toast.makeText(MainActivity.this, "Preencha todos os campos!", Toast.LENGTH_LONG).show();
                    return;
                }

                // 2. Conversão de valores
                double peso = Double.parseDouble(edPeso.getText().toString());
                int idade = Integer.parseInt(edIdade.getText().toString());
                double jaConsumido = Double.parseDouble(edAguaConsumida.getText().toString());

                // 3. Validações de sanidade
                if (peso <= 0) {
                    Toast.makeText(MainActivity.this, "Tu é um papel? 🤨", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (idade <= 0) {
                    Toast.makeText(MainActivity.this, "Idade inválida!", Toast.LENGTH_SHORT).show();
                    return;
                }

                // 4. Lógica de Adicional por Atividade
                int adicionalAtividade = 0;
                if (rbSedentario.isChecked()) {
                    adicionalAtividade = 0;
                } else if (rbModerado.isChecked()) {
                    adicionalAtividade = 300;
                } else if (rbIntenso.isChecked()) {
                    adicionalAtividade = 600;
                } else {
                    Toast.makeText(MainActivity.this, "Selecione o nível de atividade!", Toast.LENGTH_SHORT).show();
                    return;
                }

                // 5. Cálculos (Meta base de 35ml por kg)
                double consumoTotal = (peso * 35) + adicionalAtividade;
                double faltaBeber = consumoTotal - jaConsumido;

                // Se o resultado for negativo, ele já bateu a meta
                String msgFalta = faltaBeber <= 0 ? "Meta atingida!" : "Faltam: " + new DecimalFormat("0").format(faltaBeber) + " ml";

                // 6. Exibição Única
                DecimalFormat df = new DecimalFormat("0.00");
                String resultadoFinal = "Idade: " + idade +
                        "\nMeta Diária: " + df.format(consumoTotal) + " ml" +
                        "\nJá consumido: " + df.format(jaConsumido) + " ml" +
                        "\n" + msgFalta;

                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("Resultado da Hidratação")
                        .setMessage(resultadoFinal)
                        .setNeutralButton("OK", null)
                        .show();
            }
        });
    }
}