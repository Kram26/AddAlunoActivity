package br.com.unipac.alunosapp.infra;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import br.com.unipac.alunosapp.model.domain.Aluno;
import br.com.unipac.alunosapp.model.repository.AlunoDAO;
import br.com.unipac.alunosapp.util.DateRoomConvert;

@Database(entities = {Aluno.class}, version = 1, exportSchema = false)
@TypeConverters({DateRoomConvert.class})
public abstract class AlunoDatabase extends RoomDatabase {

    public abstract AlunoDAO getAlunoDao();

    private static AlunoDatabase alunoDatabase;

    public static AlunoDatabase getInstance(Context context) {
        if (null == alunoDatabase) {
            alunoDatabase = buildDatabaseInstance(context);
        }
        return alunoDatabase;
    }

    private static AlunoDatabase buildDatabaseInstance(Context context) {
        return Room.databaseBuilder(context, AlunoDatabase.class, "alunos.db" ).allowMainThreadQueries().build();
    }

    public void cleanUp() {
        alunoDatabase = null;
    }
}
