package com.fauzanpramulia.sisteminformasiunand.angkatan;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import com.airbnb.lottie.LottieAnimationView;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;
import com.fauzanpramulia.sisteminformasiunand.ListViewAdapter;
import com.fauzanpramulia.sisteminformasiunand.db.AppDatabase;
import com.fauzanpramulia.sisteminformasiunand.db.NoteDB;
import com.fauzanpramulia.sisteminformasiunand.model.MahasiswaItem;
import com.fauzanpramulia.sisteminformasiunand.R;
import com.fauzanpramulia.sisteminformasiunand.model.Note;
import com.fauzanpramulia.sisteminformasiunand.shared.Session;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Console;
import java.util.ArrayList;
import java.util.List;

public class SatuActivity extends AppCompatActivity implements ListViewAdapter.OnItemClicked {

    private static final String JSON_URL = "https://sistem-informasi-ab2f0.firebaseapp.com/data.json";
    Session session;
    //    ProgressDialog progressDialog;
    private DatabaseReference database;
    LottieAnimationView loader;
    private RecyclerView recyclerView;
    public ArrayList<MahasiswaItem> mahasiswaItemList;
    ListViewAdapter listViewAdapter;
    AppDatabase db;
    EditText cari;
    Button btnCari;
    RelativeLayout linearCari;
    TextView emptyView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);
        session = session = new Session(this);
        setTitle(session.getNama());
        recyclerView = findViewById(R.id.recyclerView);
        mahasiswaItemList = new ArrayList<MahasiswaItem>();

        db = Room.databaseBuilder(this, AppDatabase.class, "dbsi.db")
                .allowMainThreadQueries()
                .build();
        loader = findViewById(R.id.loader);
        loader.setVisibility(View.VISIBLE);
//        progressDialog = new ProgressDialog(this);
//        progressDialog.setMessage("Loading Data...");
//        progressDialog.show();
        FirebaseApp.initializeApp(getApplicationContext());
        database = FirebaseDatabase.getInstance().getReference();

        cari = (EditText) findViewById(R.id.cari);
        cari.setFilters(new InputFilter[]{new InputFilter.AllCaps()});
        btnCari = (Button) findViewById(R.id.btnCari);
        btnCari.setAllCaps(true);
        linearCari = (RelativeLayout) findViewById(R.id.linear_cari);
        emptyView = (TextView) findViewById(R.id.empty_view);

        if (session.getAngkatan().equals("cari")) {
            linearCari.setVisibility(View.VISIBLE);
            btnCari.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mahasiswaItemList.clear();
                    cari(cari.getText().toString().toUpperCase());
                    InputMethodManager imm = (InputMethodManager)getBaseContext().getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(cari.getWindowToken(), 0);
                }
            });
        } else {
            linearCari.setVisibility(View.GONE);
            loadMahasiswa();
        }
    }

    private void cari(String s) {
        loader.setVisibility(View.VISIBLE);
        for (int i = 10; i < 20; i++) {
            database.child("mahasiswa" + i).orderByChild("nama")
                    .startAt(s)
                    .endAt(s + "\uf8ff").addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    for (DataSnapshot userSnapshot : dataSnapshot.getChildren()) {
                        MahasiswaItem mahasiswaItem = userSnapshot.getValue(MahasiswaItem.class);
                        mahasiswaItemList.add(mahasiswaItem);
                    }
                    setupRecyclerView(mahasiswaItemList);
                }
                @Override
                public void onCancelled(DatabaseError databaseError) {
                    Toast.makeText(SatuActivity.this, "Data tidak ada", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    private void loadMahasiswa() {
        database.child(session.getAngkatan()).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot noteDataSnapshot : dataSnapshot.getChildren()) {
                    loader.setVisibility(View.INVISIBLE);
                    MahasiswaItem mahasiswaItem = noteDataSnapshot.getValue(MahasiswaItem.class);
                    //barang.setKey(noteDataSnapshot.getKey());
                    mahasiswaItemList.add(mahasiswaItem);
                }
                setupRecyclerView(mahasiswaItemList);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
//                System.out.println(databaseError.getDetails()+" "+databaseError.getMessage());
                loader.setVisibility(View.INVISIBLE);
                Toast.makeText(getApplicationContext(), "Tolong Periksa Kembali Jaringan Internet Anda!", Toast.LENGTH_LONG).show();
            }
        });
    }

    private void setupRecyclerView(List<MahasiswaItem> listMahasiswa) {
        ListViewAdapter myAdapter = new ListViewAdapter(listMahasiswa, this, session.getWarna());

        myAdapter.setHandler(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(myAdapter);
        if (myAdapter.getItemCount() == 0) {
            emptyView.setVisibility(View.VISIBLE);
        } else {
            emptyView.setVisibility(View.GONE);
        }
        myAdapter.notifyDataSetChanged();
        loader.setVisibility(View.INVISIBLE);
    }

    @Override
    public void clik(MahasiswaItem m) {
        LayoutInflater factory = LayoutInflater.from(this);
        final View view = factory.inflate(R.layout.image_view, null);

        ImageView dialogImage = view.findViewById(R.id.dialog_imageview);

        if (m.getFoto().equalsIgnoreCase("null")) {
            if (m.getJk().equals("p")) {
                dialogImage.setImageResource(R.drawable.avatar_cewek);

            } else {
                dialogImage.setImageResource(R.drawable.avatar_cowok);
            }
        } else {
            Glide.with(this).load(m.getFoto()).into(dialogImage);
        }

        NoteDB noteDb = db.noteDbDao().getByBp(m.getBp());
        Note note = null;
        if (noteDb != null) {
            note = new Note(
                    noteDb.id,
                    noteDb.bp,
                    noteDb.deskripsi,
                    noteDb.date
            );
            if (!note.getDescription().trim().equals("") || note.getDescription() != null) {
                universalDialog(view, m.getBp(), note.getDescription(), note, m);
            } else {
                universalDialog(view, m.getBp(), "Belum Ada Catatan !", note, m);
            }
            session.setDeskripsi(note.getDescription());
            session.setDate(note.getDate());
        } else {
            universalDialog(view, m.getBp(), "Belum Ada Catatan !", note, m);
        }
    }

    private void universalDialog(View view, String title, String message, final Note note, final MahasiswaItem m) {
        final AlertDialog.Builder myAlertDialog = new AlertDialog.Builder(
                this);
        myAlertDialog.setTitle(title + " (" + session.getNama() + ")");
        myAlertDialog.setMessage(message);

        myAlertDialog.setPositiveButton("Ok",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface arg0, int arg1) {
                        session.setDeskripsi("");
                        session.setDate("");
                    }
                });
        myAlertDialog.setNeutralButton("Edit",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface arg0, int arg1) {
                        session.setBp(m.getBp());
                        Intent i = new Intent(SatuActivity.this, CustumeActivity.class);
                        startActivity(i);
                        finish();
                    }
                });
        myAlertDialog.setView(view);
        myAlertDialog.show();
    }
}
