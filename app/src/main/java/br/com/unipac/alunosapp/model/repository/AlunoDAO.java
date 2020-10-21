package br.com.unipac.alunosapp.model.repository;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import br.com.unipac.alunosapp.model.domain.Aluno;

@Dao
public interface AlunoDAO {

    @Insert
    void insert(Aluno aluno);

    @Update
    void update(Aluno aluno);

    @Delete
    void delete(Aluno aluno);

    @Query("SELECT * FROM aluno")
    List<Aluno> getAll();
}
