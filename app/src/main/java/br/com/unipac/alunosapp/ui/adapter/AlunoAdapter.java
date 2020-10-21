package br.com.unipac.alunosapp.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import br.com.unipac.alunosapp.R;
import br.com.unipac.alunosapp.model.domain.Aluno;

public class AlunoAdapter extends BaseAdapter {
    private List<Aluno> alunoList = new ArrayList<>();
    private Context context = null;

    public AlunoAdapter(List<Aluno> alunoList, Context context) {
        this.alunoList = alunoList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return !alunoList.isEmpty() ? alunoList.size() : 0;
    }

    @Override
    public Aluno getItem(int position) {
        return !alunoList.isEmpty() ? alunoList.get(position) : new Aluno();
    }

    @Override
    public long getItemId(int position) {
        return !alunoList.isEmpty() ? alunoList.get(position).getAlunoId() : 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        Aluno aluno = getItem(position);
        String nome = aluno.getNome();
        String curriculo = aluno.getCurriculo();

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View novoLayout = inflater.inflate(R.layout.aluno_item, null);

        TextView nameTv = (TextView) novoLayout.findViewById(R.id.name);
        TextView curriculoTv = (TextView) novoLayout.findViewById(R.id.curriculo);

        nameTv.setText(nome);
        curriculoTv.setText(curriculo);

        return novoLayout;
    }
}
