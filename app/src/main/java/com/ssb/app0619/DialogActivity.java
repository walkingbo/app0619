package com.ssb.app0619;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

public class DialogActivity extends AppCompatActivity {
    private Button loginbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);

        loginbtn =(Button)findViewById(R.id.loginbtn);
        loginbtn.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){
                //Log.e("tag","button click");
                //login.xml로 디자인 한  뷰 찾아오기
                final LinearLayout login =
                        (LinearLayout)View.inflate(DialogActivity.this,R.layout.login,null);
                new AlertDialog.Builder(DialogActivity.this)
                        .setTitle("Login")
                        .setView(login)
                        .setPositiveButton("confirm", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                               EditText id = (EditText)login.findViewById(R.id.id);
                               EditText password = (EditText)login.findViewById(R.id.password);
                               String inputId = id.getText().toString();
                               String inputPassword = password.getText().toString();
                                Toast.makeText(DialogActivity.this,inputId+":"+inputPassword,Toast.LENGTH_LONG).show();
                            }
                        })
                        .setNegativeButton("cancel",null)
                        .show();

            }
        });


    }
}
