package com.systematix;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText editUser, editPass;
    Button btnMasuk, btnKeluar;
    
    DBHelper dbHelper;
    SQLiteDatabase query;
    Cursor c;
    SharedPreferences.Editor editor;
    SharedPreferences prefs;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature( Window.FEATURE_NO_TITLE );
        getWindow().setFlags( WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN );
        setContentView(R.layout.activity_login);
        editor = getSharedPreferences("Login", MODE_PRIVATE).edit();
        prefs = getSharedPreferences("Login", MODE_PRIVATE);
        if (prefs.getString("username", null) != null) {
            startActivity(new Intent(LoginActivity.this, DashboardActivity.class));
            finish();
        }
        initViews();
    }

    private void initViews(){
        dbHelper = new DBHelper(this);
        query = dbHelper.getReadableDatabase();
        editUser = findViewById(R.id.editUser);
        editPass = findViewById(R.id.editPass);
        btnMasuk = findViewById(R.id.btnMasuk);
        btnKeluar = findViewById(R.id.btnKeluar);

        btnMasuk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                c = query.rawQuery("SELECT * FROM user WHERE username = '"+editUser.getText().toString().trim()+"'", null);
                if (c.getCount() ==  0){
                    Toast.makeText(LoginActivity.this, "Username tidak ditemukan", Toast.LENGTH_SHORT).show();
                    return;
                }
                c.moveToFirst();
                if (!c.getString(2).equals(editPass.getText().toString().trim())){
                    Toast.makeText(LoginActivity.this, "Password salah", Toast.LENGTH_SHORT).show();
                    return;
                }
                editor.putString("id", c.getString(0));
                editor.putString("username", c.getString(1));
                editor.putString("password", c.getString(2));
                editor.apply();
                startActivity(new Intent(LoginActivity.this, DashboardActivity.class));
                finish();
            }
        });

        btnKeluar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new AlertDialog.Builder(LoginActivity.this)
                        .setMessage("Keluar aplikasi?")
                        .setTitle("Systematix")
                        .setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                finish();
                            }
                        })
                        .setNegativeButton("Tidak", null)
                        .show();
            }
        });
    }
}
