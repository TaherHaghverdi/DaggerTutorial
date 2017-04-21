package ir.coursio.daggertutorial;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import ir.coursio.daggertutorial.handler.PermissionHandler;

/**
 * Created by Taher on 08/04/2017.
 * Project: RetrofitTutorial
 */

public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getPermissions();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        Intent intent = new Intent("PERMISSION_RECEIVER");
        intent.putExtra("requestCode", requestCode);
        intent.putExtra("permissions", permissions);
        intent.putExtra("grantResults", grantResults);
        sendBroadcast(intent);
    }

    private void getPermissions(){
        String[] permissions = {Manifest.permission.INTERNET};
        new PermissionHandler().checkPermission(BaseActivity.this, permissions, new PermissionHandler.OnPermissionResponse() {
            @Override
            public void onPermissionGranted() {
            }

            @Override
            public void onPermissionDenied() {
            }
        });
    }
}
