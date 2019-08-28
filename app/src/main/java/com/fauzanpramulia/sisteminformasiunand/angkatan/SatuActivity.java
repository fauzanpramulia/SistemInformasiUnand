package com.fauzanpramulia.sisteminformasiunand.angkatan;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.arch.persistence.room.Room;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.fauzanpramulia.sisteminformasiunand.ListViewAdapter;
import com.fauzanpramulia.sisteminformasiunand.db.AppDatabase;
import com.fauzanpramulia.sisteminformasiunand.db.NoteDB;
import com.fauzanpramulia.sisteminformasiunand.model.MahasiswaItem;
import com.fauzanpramulia.sisteminformasiunand.R;
import com.fauzanpramulia.sisteminformasiunand.model.Note;
import com.fauzanpramulia.sisteminformasiunand.shared.Session;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class SatuActivity extends AppCompatActivity implements ListViewAdapter.OnItemClicked{

    private static final String JSON_URL = "https://sistem-informasi-ab2f0.firebaseapp.com/data.json";
    Session session;
    ProgressDialog progressDialog;
    private RecyclerView recyclerView;
    public ArrayList<MahasiswaItem> mahasiswaItemList;
    ListViewAdapter listViewAdapter;
    AppDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);
        session = session = new Session(this);
        setTitle(session.getNama());
        recyclerView =  findViewById(R.id.recyclerView);
        mahasiswaItemList = new ArrayList<MahasiswaItem>();

        db = Room.databaseBuilder(this, AppDatabase.class, "dbsi.db")
                .allowMainThreadQueries()
                .build();

        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading Data...");
        progressDialog.show();

        loadMahasiswa();
    }
    private void loadMahasiswa() {
        StringRequest stringRequest = new StringRequest(Request.Method.GET, JSON_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        progressDialog.dismiss();
                        try {
                            JSONObject obj = new JSONObject(response);
                            JSONArray playerArray = obj.getJSONArray(session.getAngkatan());

                            for (int i = 0; i < playerArray.length(); i++) {

                                JSONObject playerObject = playerArray.getJSONObject(i);

                                MahasiswaItem mahasiswaItem = new MahasiswaItem(
                                        playerObject.getString("no"),
                                        playerObject.getString("nama"),
                                        playerObject.getString("bp"),
                                        playerObject.getString("fakultas"),
                                        playerObject.getString("foto"),
                                        playerObject.getString("jk"));

                                mahasiswaItemList.add(mahasiswaItem);
                            }

                           // ListViewAdapter adapter = new ListViewAdapter(mahasiswaItemList, getApplicationContext(),R.color.category_angkatan_10);
//                            ListViewAdapter  adapter =
//                                    new ListViewAdapter(mahasiswaItemList,this);
//
//                            ListView listNumber = (ListView)findViewById(R.id.list_number);
                       //     listView.setAdapter(adapter);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        setupRecyclerView(mahasiswaItemList);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        progressDialog.dismiss();
                        Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

    private void setupRecyclerView(List<MahasiswaItem> listMahasiswa){
        ListViewAdapter myAdapter = new ListViewAdapter(listMahasiswa,this,session.getWarna());
        myAdapter.setHandler(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(myAdapter);
    }

    @Override
    public void clik(MahasiswaItem m) {
        NoteDB noteDb = db.noteDbDao().getByBp(m.getBp());
        Note note = null;
        if (noteDb != null){
             note = new Note(
                    noteDb.id,
                    noteDb.bp,
                    noteDb.deskripsi,
                    noteDb.date
            );
             if (!note.getDescription().trim().equals("") || note.getDescription() != null){
                 universalDialog(m.getBp(),note.getDescription(),note, m);
             }else {
                 universalDialog(m.getBp(),"Belum Ada Catatan !",note, m);
             }
             session.setDeskripsi(note.getDescription());
             session.setDate(note.getDate());
        }else {
            universalDialog(m.getBp(),"Belum Ada Catatan !",note, m);
        }
    }

    private void universalDialog(String title, String message, final Note note, final MahasiswaItem m) {
        AlertDialog.Builder myAlertDialog = new AlertDialog.Builder(
                this);
        myAlertDialog.setTitle(title+" ("+session.getNama()+")");
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
                    }
                });

        myAlertDialog.show();
    }
}
