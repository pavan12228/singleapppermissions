package com.example.ravi.singleapppermissions;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.widget.Toast;

/**
 * Created by Ravi on 12-02-2017.
 */

public class Util {
    Context context;
    boolean mAccess_fine_location,mReadContacts;

    public Util(Context context) {
        this.context = context;
    }

    public boolean getStatusPermission() {
        return mAccess_fine_location;
    }

    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            mAccess_fine_location = true;
        } else {
            mAccess_fine_location = false;
        }

        if (grantResults.length > 1 && grantResults[1] == PackageManager.PERMISSION_GRANTED) {
            mReadContacts = true;
        } else {
            mReadContacts = false;
        }


    }



    public void checkExplainRequestPermission(final String mPermission) {
        if (ContextCompat.checkSelfPermission(context, mPermission) == PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(context, "Permission granted!", Toast.LENGTH_SHORT).show();
        } else if (ActivityCompat.shouldShowRequestPermissionRationale((Activity) context, mPermission)) {
            AlertDialog.Builder explantDilaog = new AlertDialog.Builder(context);
            explantDilaog.setMessage("Access fine location is for getting ur current latlang");
            explantDilaog.setTitle("Please click ok to continue");
            explantDilaog.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    ActivityCompat.requestPermissions((Activity) context, new String[]{mPermission}, 151);
                    Toast.makeText(context, "You understood the permission!", Toast.LENGTH_SHORT).show();
                }
            });
            explantDilaog.setNegativeButton("canecl", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                }
            });
            explantDilaog.show();


        } else {
            ActivityCompat.requestPermissions((Activity) context, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 151);
            Toast.makeText(context, "No permission", Toast.LENGTH_SHORT).show();
        }
    }



}
