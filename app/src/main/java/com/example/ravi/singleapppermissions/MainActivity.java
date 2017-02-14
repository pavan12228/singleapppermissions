package com.example.ravi.singleapppermissions;

import android.Manifest;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
      Util mUtil;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mUtil = new Util(this);
        mUtil.checkExplainRequestPermission(Manifest.permission.ACCESS_FINE_LOCATION);
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        mUtil.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (mUtil.getStatusPermission()) {
            Toast.makeText(this, "Successfully granted", Toast.LENGTH_SHORT).show();
        }
    }
}
