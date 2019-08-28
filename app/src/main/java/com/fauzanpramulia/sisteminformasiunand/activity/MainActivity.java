package com.fauzanpramulia.sisteminformasiunand.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.fauzanpramulia.sisteminformasiunand.R;
import com.fauzanpramulia.sisteminformasiunand.angkatan.SatuActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        TextView satuView = (TextView)findViewById(R.id.angkatan_2010);
        satuView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent satuIntent = new Intent(MainActivity.this, SatuActivity.class);
                satuIntent.putExtra("angkatan","mahasiswa10");
                satuIntent.putExtra("warna",R.color.category_angkatan_10);
                satuIntent.putExtra("nama","EINSSITECH");
                startActivity(satuIntent);
            }
        });

        TextView duaView = (TextView)findViewById(R.id.angkatan_2011);
        duaView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent duaIntent = new Intent(MainActivity.this, SatuActivity.class);
                duaIntent.putExtra("angkatan","mahasiswa11");
                duaIntent.putExtra("warna",R.color.category_angkatan_11);
                duaIntent.putExtra("nama","GGSI");
                startActivity(duaIntent);
            }
        });

        TextView tigaView = (TextView)findViewById(R.id.angkatan_2012);
        tigaView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent tigaIntent = new Intent(MainActivity.this, SatuActivity.class);
                tigaIntent.putExtra("angkatan","mahasiswa12");
                tigaIntent.putExtra("warna",R.color.category_execution_12);
                tigaIntent.putExtra("nama","EXECUTION");
                startActivity(tigaIntent);
            }
        });

        TextView empatView = (TextView)findViewById(R.id.angkatan_2013);
        empatView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent empatIntent = new Intent(MainActivity.this, SatuActivity.class);
                empatIntent.putExtra("angkatan","mahasiswa13");
                empatIntent.putExtra("warna",R.color.category_sintax_13);
                empatIntent.putExtra("nama","SYNTAX");
                startActivity(empatIntent);
            }
        });
        TextView limaView = (TextView)findViewById(R.id.angkatan_2014);
        limaView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent limaIntent = new Intent(MainActivity.this, SatuActivity.class);
                limaIntent.putExtra("angkatan","mahasiswa14");
                limaIntent.putExtra("warna",R.color.category_isofire_14);
                limaIntent.putExtra("nama","ISOFIRE");
                startActivity(limaIntent);
            }
        });

        TextView enamView = (TextView)findViewById(R.id.angkatan_2015);
        enamView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent enamIntent = new Intent(MainActivity.this, SatuActivity.class);
                enamIntent.putExtra("angkatan","mahasiswa15");
                enamIntent.putExtra("warna",R.color.category_asimetris_15);
                enamIntent.putExtra("nama","ASIMETRI5");
                startActivity(enamIntent);
            }
        });
        TextView tujuhView = (TextView)findViewById(R.id.angkatan_2016);
        tujuhView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent tujuhIntent = new Intent(MainActivity.this, SatuActivity.class);
                tujuhIntent.putExtra("angkatan","mahasiswa16");
                tujuhIntent.putExtra("warna",R.color.category_glorise_16);
                tujuhIntent.putExtra("nama","GLORISE");
                startActivity(tujuhIntent);
            }
        });
        TextView delView = (TextView)findViewById(R.id.angkatan_2017);
        delView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent delIntent = new Intent(MainActivity.this, SatuActivity.class);
                delIntent.putExtra("angkatan","mahasiswa17");
                delIntent.putExtra("warna",R.color.category_integer8_17);
                delIntent.putExtra("nama","INTEGER8");
                startActivity(delIntent);
            }
        });
        TextView sembilanView = (TextView)findViewById(R.id.angkatan_2018);
        sembilanView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sembilanIntent = new Intent(MainActivity.this, SatuActivity.class);
                sembilanIntent.putExtra("angkatan","mahasiswa18");
                sembilanIntent.putExtra("warna",R.color.category_angkatan_18);
                sembilanIntent.putExtra("nama","ANGKATAN 18");
                startActivity(sembilanIntent);
            }
        });

        TextView sepuluhView = (TextView)findViewById(R.id.angkatan_2019);
        sepuluhView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sepuluhIntent = new Intent(MainActivity.this, SatuActivity.class);
                sepuluhIntent.putExtra("angkatan","mahasiswa19");
                sepuluhIntent.putExtra("warna",R.color.category_angkatan_19);
                sepuluhIntent.putExtra("nama","ANGKATAN 19");
                startActivity(sepuluhIntent);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.about:
                Intent i = new Intent(this, SettingsActivity.class);
                startActivity(i);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
