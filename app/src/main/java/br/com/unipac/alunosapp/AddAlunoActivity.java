package br.com.unipac.AddAlunoActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import br.com.unipac.alunosapp.infra.AlunoDatabase;
import br.com.unipac.alunosapp.model.domain.Aluno;

public class AddAlunoActivity extends AppCompatActivity {
    private AlunoDatabase alunoDatabase;
    EditText nomeEdt, curriculoEdt;
    Button salvarBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_aluno);

        nomeEdt = (EditText) findViewById(R.id.nomeEdt);
        curriculoEdt = (EditText) findViewById(R.id.curriculoEdt);
        salvarBtn = (Button) findViewById(R.id.salvarBtn);

        alunoDatabase = AlunoDatabase.getInstance(AddAlunoActivity.this);

        salvarBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nome = nomeEdt.getText().toString();
                String curriculo = curriculoEdt.getText().toString();

                Aluno aluno = new , curriAluno(nomeculo);

                Toast.makeText(AddAlunoActivity.this, "Aluno: " + aluno.toString(), Toast.LENGTH_LONG).show();

              //  alunoDatabase.getAlunoDao().insert(aluno);
            }
        });

    }
}