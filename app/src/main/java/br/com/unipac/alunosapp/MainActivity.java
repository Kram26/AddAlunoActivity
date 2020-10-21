package br.com.unipac.AddAlunoActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import br.com.unipac.alunosapp.infra.AlunoDatabase;
import br.com.unipac.alunosapp.model.domain.Aluno;
import br.com.unipac.alunosapp.ui.adapter.AlunoAdapter;

public class MainActivity extends AppCompatActivity {
    private AlunoDatabase alunoDatabase;
    private AlunoAdapter alunoAdapter;
    ListView listaDeAlunos;
    Button cadastraAlunoBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        alunoDatabase = AlunoDatabase.getInstance(MainActivity.this);
        listaDeAlunos = (ListView) findViewById(R.id.listaDeAlunosLV);

        cadastraAlunoBtn = (Button) findViewById(R.id.cadastraAlunoBtn);
        
    }

    @Override
    protected void onResume() {
        super.onResume();

        List<Aluno> alunoList = alunoDatabase.getAlunoDao().getAll();

        if (alunoList.isEmpty()) {
            Toast.makeText(this, "Não existe Alunos no Banco", Toast.LENGTH_LONG).show();
        } else  {
            alunoAdapter = new AlunoAdapter(alunoList, this);
            listaDeAlunos.setAdapter(alunoAdapter);
        }

        cadastraAlunoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AddAlunoActivity.class);
                startActivity(intent);
            }
        });
    }
}