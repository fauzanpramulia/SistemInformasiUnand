package com.fauzanpramulia.sisteminformasiunand.angkatan;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import com.fauzanpramulia.sisteminformasiunand.R;
import com.fauzanpramulia.sisteminformasiunand.db.AppDatabase;
import com.fauzanpramulia.sisteminformasiunand.db.NoteDB;
import com.fauzanpramulia.sisteminformasiunand.shared.Session;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CustumeActivity extends AppCompatActivity {
    AppDatabase db;
    Button simpan;
    EditText deskripsi;
    TextView txtView;
    Session session;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custume);
        db = Room.databaseBuilder(this, AppDatabase.class, "dbsi.db")
                .allowMainThreadQueries()
                .build();
        deskripsi = (EditText)findViewById(R.id.deskripsi);
        txtView = (TextView)findViewById(R.id.txtDeskripsi) ;
        simpan = (Button)findViewById(R.id.simpan);
        session = new Session(this);

        if (session.getDeskripsi()!=null || !session.getDeskripsi().trim().equals("")){
            deskripsi.setText(session.getDeskripsi());
            txtView.setText("Catatan! ("+session.getDate()+")");
        }
        simpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Date currentTime = Calendar.getInstance().getTime();
                DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm");
                final String strDate = dateFormat.format(currentTime);
                String message ="";
                NoteDB noteDb = db.noteDbDao().getByBp(session.getBp());
                if (noteDb != null){
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            db.noteDbDao().updateNote(deskripsi.getText().toString(), strDate, session.getBp());
                        }
                    }).start();
                    message="berhasil di Update!";

                }else{
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            NoteDB noteDB = new NoteDB();
                            noteDB.bp=session.getBp();
                            noteDB.deskripsi=deskripsi.getText().toString();
                            noteDB.date=strDate;

                            db.noteDbDao().insertNote(noteDB);
                        }
                    }).start();
                    message="berhasil di Simpan!";
                }
                Intent i = new Intent(CustumeActivity.this, SatuActivity.class);
                startActivity(i);
                finish();
                Toast.makeText(CustumeActivity.this, ""+message, Toast.LENGTH_SHORT).show();

            }
        });
    }
}
