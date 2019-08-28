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
import com.fauzanpramulia.sisteminformasiunand.shared.Session;

public class MainActivity extends AppCompatActivity {
    Session session;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        session = new Session(this);

        TextView satuView = (TextView)findViewById(R.id.angkatan_2010);
        satuView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent satuIntent = new Intent(MainActivity.this, SatuActivity.class);
                session.setAngkatan("mahasiswa10");
                session.setWarna(R.color.category_angkatan_10);
                session.setNama("EINSSITECH");
                startActivity(satuIntent);
            }
        });

        TextView duaView = (TextView)findViewById(R.id.angkatan_2011);
        duaView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent duaIntent = new Intent(MainActivity.this, SatuActivity.class);
                session.setAngkatan("mahasiswa11");
                session.setWarna(R.color.category_angkatan_11);
                session.setNama("GGSI");
                startActivity(duaIntent);
            }
        });

        TextView tigaView = (TextView)findViewById(R.id.angkatan_2012);
        tigaView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent tigaIntent = new Intent(MainActivity.this, SatuActivity.class);
                session.setAngkatan("mahasiswa12");
                session.setWarna(R.color.category_execution_12);
                session.setNama("EXECUTION");
                startActivity(tigaIntent);
            }
        });

        TextView empatView = (TextView)findViewById(R.id.angkatan_2013);
        empatView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent empatIntent = new Intent(MainActivity.this, SatuActivity.class);
                session.setAngkatan("mahasiswa13");
                session.setWarna(R.color.category_sintax_13);
                session.setNama("SYNTAX");
                startActivity(empatIntent);
            }
        });
        TextView limaView = (TextView)findViewById(R.id.angkatan_2014);
        limaView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent limaIntent = new Intent(MainActivity.this, SatuActivity.class);
                session.setAngkatan("mahasiswa14");
                session.setWarna(R.color.category_isofire_14);
                session.setNama("ISOFIRE");
                startActivity(limaIntent);
            }
        });

        TextView enamView = (TextView)findViewById(R.id.angkatan_2015);
        enamView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent enamIntent = new Intent(MainActivity.this, SatuActivity.class);
                session.setAngkatan("mahasiswa15");
                session.setWarna(R.color.category_asimetris_15);
                session.setNama("ASIMETRI5");
                startActivity(enamIntent);
            }
        });
        TextView tujuhView = (TextView)findViewById(R.id.angkatan_2016);
        tujuhView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent tujuhIntent = new Intent(MainActivity.this, SatuActivity.class);
                session.setAngkatan("mahasiswa16");
                session.setWarna(R.color.category_glorise_16);
                session.setNama("GLORISE");
                startActivity(tujuhIntent);
            }
        });
        TextView delView = (TextView)findViewById(R.id.angkatan_2017);
        delView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent delIntent = new Intent(MainActivity.this, SatuActivity.class);
                session.setAngkatan("mahasiswa17");
                session.setWarna(R.color.category_integer8_17);
                session.setNama("INTEGER8");
                startActivity(delIntent);
            }
        });
        TextView sembilanView = (TextView)findViewById(R.id.angkatan_2018);
        sembilanView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sembilanIntent = new Intent(MainActivity.this, SatuActivity.class);
                session.setAngkatan("mahasiswa18");
                session.setWarna(R.color.category_angkatan_18);
                session.setNama("ANGKATAN 18");
                startActivity(sembilanIntent);
            }
        });

        TextView sepuluhView = (TextView)findViewById(R.id.angkatan_2019);
        sepuluhView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sepuluhIntent = new Intent(MainActivity.this, SatuActivity.class);
                session.setAngkatan("mahasiswa19");
                session.setWarna(R.color.category_angkatan_19);
                session.setNama("ANGKATAN 19");
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
