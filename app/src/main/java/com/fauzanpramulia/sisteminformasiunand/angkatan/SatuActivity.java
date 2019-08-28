package com.fauzanpramulia.sisteminformasiunand.angkatan;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.fauzanpramulia.sisteminformasiunand.ListViewAdapter;
import com.fauzanpramulia.sisteminformasiunand.MahasiswaItem;
import com.fauzanpramulia.sisteminformasiunand.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class SatuActivity extends AppCompatActivity {

    private static final String JSON_URL = "https://sistem-informasi-ab2f0.firebaseapp.com/data.json";

    ProgressDialog progressDialog;
    ListView listView;
    private RecyclerView recyclerView;
    public ArrayList<MahasiswaItem> mahasiswaItemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        setTitle(getIntent().getExtras().getString("nama"));
        recyclerView =  findViewById(R.id.recyclerView);
        mahasiswaItemList = new ArrayList<MahasiswaItem>();

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
                            JSONArray playerArray = obj.getJSONArray(getIntent().getExtras().getString("angkatan"));

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
        ListViewAdapter myAdapter = new ListViewAdapter(listMahasiswa,this,getIntent().getExtras().getInt("warna"));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(myAdapter);
    }
}
