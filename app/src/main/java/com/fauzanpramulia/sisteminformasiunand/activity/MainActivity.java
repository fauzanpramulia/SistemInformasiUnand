package com.fauzanpramulia.sisteminformasiunand.activity;

import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.fauzanpramulia.sisteminformasiunand.R;
import com.fauzanpramulia.sisteminformasiunand.angkatan.CustumeActivity;
import com.fauzanpramulia.sisteminformasiunand.angkatan.SatuActivity;
import com.fauzanpramulia.sisteminformasiunand.model.MahasiswaItem;
import com.fauzanpramulia.sisteminformasiunand.model.Note;
import com.fauzanpramulia.sisteminformasiunand.shared.PrefManager;
import com.fauzanpramulia.sisteminformasiunand.shared.Session;

public class MainActivity extends AppCompatActivity {
    Session session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        session = new Session(this);
        //ini cuma contoh
//        PrefManager prefManager = new PrefManager(getApplicationContext());
//        prefManager.setFirstTimeLaunch(true);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle(getString(R.string.app_name));
        toolbar.setTitleTextColor(Resources.getSystem().getColor(android.R.color.white));

        // Menampilkan ikon di Toolbar
//        getSupportActionBar().setDisplayShowHomeEnabled(true);
//        getSupportActionBar().setLogo(R.mipmap.ic_launcher);
//        getSupportActionBar().setDisplayUseLogoEnabled(true);
        /* Di dalam Activity */
        // Mengatur Toolbar untuk sebagai ActionBar
        //        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //       setSupportActionBar(toolbar);
        // Menghapus title default
        //        getSupportActionBar().setDisplayShowTitleEnabled(false);
        // Mengambil akses TextView yang ada di dalam Toolbar
        //       TextView mTitle = (TextView) toolbar.findViewById(R.id.toolbar_title);

        TextView satuView = (TextView) findViewById(R.id.angkatan_2010);
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

        TextView duaView = (TextView) findViewById(R.id.angkatan_2011);
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

        TextView tigaView = (TextView) findViewById(R.id.angkatan_2012);
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

        TextView empatView = (TextView) findViewById(R.id.angkatan_2013);
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
        TextView limaView = (TextView) findViewById(R.id.angkatan_2014);
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

        TextView enamView = (TextView) findViewById(R.id.angkatan_2015);
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
        TextView tujuhView = (TextView) findViewById(R.id.angkatan_2016);
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
        TextView delView = (TextView) findViewById(R.id.angkatan_2017);
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
        TextView sembilanView = (TextView) findViewById(R.id.angkatan_2018);
        sembilanView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sembilanIntent = new Intent(MainActivity.this, SatuActivity.class);
                session.setAngkatan("mahasiswa18");
                session.setWarna(R.color.category_angkatan_18);
                session.setNama("INFINITE");
                startActivity(sembilanIntent);
            }
        });

        TextView sepuluhView = (TextView) findViewById(R.id.angkatan_2019);
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
            case R.id.cari_menu:
                Intent sepuluhIntent = new Intent(MainActivity.this, SatuActivity.class);
                session.setAngkatan("cari");
                session.setWarna(R.color.bg_screen2);
                session.setNama("nama");
                startActivity(sepuluhIntent);
                return true;
            case R.id.rating:
                universalDialog();
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void launchMarket() {
        Uri uri = Uri.parse("market://details?id=" + getPackageName());
        Intent myAppLinkToMarket = new Intent(Intent.ACTION_VIEW, uri);
        myAppLinkToMarket.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY |
                Intent.FLAG_ACTIVITY_NEW_DOCUMENT |
                Intent.FLAG_ACTIVITY_MULTIPLE_TASK);
        try {
            startActivity(myAppLinkToMarket);
        } catch (ActivityNotFoundException e) {
            Toast.makeText(this, " unable to find market app", Toast.LENGTH_LONG).show();
            startActivity(new Intent(Intent.ACTION_VIEW,
                    Uri.parse("http://play.google.com/store/apps/details?id=" + getApplicationContext().getPackageName())));
        }
    }
    private void universalDialog() {
        final AlertDialog.Builder myAlertDialog = new AlertDialog.Builder(
                this);
        LayoutInflater factory = LayoutInflater.from(this);
        final View view = factory.inflate(R.layout.rating, null);

       // myAlertDialog.setTitle("Berikan Rating Untuk Aplikasi ini ?");
       // myAlertDialog.setMessage("berikan!");

        myAlertDialog.setPositiveButton("Ayo!",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface arg0, int arg1) {
                        launchMarket();
                    }
                });
        myAlertDialog.setNeutralButton("Cancel",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface arg0, int arg1) {

                    }
                });
        myAlertDialog.setView(view);
        myAlertDialog.show();
    }

}
