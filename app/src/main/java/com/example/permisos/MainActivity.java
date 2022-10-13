package com.example.permisos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Switch;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    private Switch storage;
    private Switch location;
    private Switch contacts;
    private Switch camera;
    private Switch phone;

    String[] perms = {"android.permission.ACCESS_FINE_LOCATION","android.permission.CAMERA",
            "android.permission.READ_EXTERNAL_STORAGE","android.permission.CALL_PHONE","android.permission.READ_CONTACTS"};

    int permsRequestCode = 200;

    private void checking(){
        Arrays.asList(perms).forEach(permsRequestCode -> {
            if (checkSelfPermission(permsRequestCode)== PackageManager.PERMISSION_GRANTED){
                switch (permsRequestCode){
                    case "android.permission.ACCESS_FINE_LOCATION":
                        location.setChecked(true);
                        break;
                    case "android.permission.CAMERA":
                        storage.setChecked(true);
                        break;
                    case "android.permission.READ_EXTERNAL_STORAGE":
                        contacts.setChecked(true);
                        break;
                    case "android.permission.CALL_PHONE":
                        camera.setChecked(true);
                        break;
                    case "android.permission.READ_CPMTACTS":
                        phone.setChecked(true);
                        break;


                }
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void checkedSwitches(View view){
        ArrayList<String> notchecked = new ArrayList<>();
        if(storage.isChecked()){
            notchecked.add("android.permission.READ_EXTERNAL_STORAGE");
        }
        if(location.isChecked()){
            notchecked.add("android.permission.ACCESS_FINE_LOCATION");
        }
        if(camera.isChecked()){
            notchecked.add("android.permission.CAMERA");
        }
        if(phone.isChecked()){
            notchecked.add("android.permission.CALL_PHONE");
        }
        if(contacts.isChecked()){
            notchecked.add("android.permission.READ_CONTACTS");
        }
    }
}