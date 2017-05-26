package com.example.pushpak.interactivitythroughconstraint;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatEditText;
import android.view.View;
import android.widget.EditText;



public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btnLogin).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String userName = ((EditText) findViewById(R.id.edtUsername)).getText().toString();
                String password = ((EditText) findViewById(R.id.edtPassword)).getText().toString();

                if (userName.equalsIgnoreCase("codekul")
                        && password.equalsIgnoreCase("codekul")) {

                    Bundle bundle = new Bundle();
                    bundle.putString("keyStr", userName);
                    bundle.putInt("keyInt", 1234);

                    Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
                    intent.putExtras(bundle);

                    startActivity(intent);

                    startActivityForResult(intent, 2468);
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


        if (requestCode == 2468) {
            // you r coming back from Profile Activity
            if (resultCode == RESULT_OK) {

                if (data != null) {
                    Bundle bundle = data.getExtras();
                    String res = bundle.getString("keyResult");
                    ((EditText) findViewById(R.id.edtUsername)).setText(res);
                }
            }
        }

    }
}