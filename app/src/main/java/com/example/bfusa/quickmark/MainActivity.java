package com.example.bfusa.quickmark;

import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.bfusa.quickmark.fragments.CameraPreview;
import com.example.bfusa.quickmark.fragments.MainButtons;
import com.example.bfusa.quickmark.fragments.QuizzesButtons;

public class MainActivity extends AppCompatActivity {

    //holders for the buttons of different views
    static MainButtons mainButtons;
    static QuizzesButtons quizzesButtons;

    //holder for camera logic
    CameraPreview cameraPreview;

    private static boolean BACK_FLAG;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BACK_FLAG = false;

        quizzesButtons = new QuizzesButtons(this, BACK_FLAG);
        mainButtons = new MainButtons(this, BACK_FLAG, quizzesButtons);
        cameraPreview = new CameraPreview(this);


    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == cameraPreview.REQUEST_CAMERA_PERMISSION) {
            if (grantResults[0] == PackageManager.PERMISSION_DENIED) {
                // close the app
                Toast.makeText(MainActivity.this, "Sorry!!!, you can't use this app without granting permission", Toast.LENGTH_LONG).show();
                finish();
            }
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e(cameraPreview.TAG, "onResume");
        cameraPreview.startBackgroundThread();
        if (cameraPreview.textureView.isAvailable()) {
            cameraPreview.openCamera();
        } else {
            cameraPreview.textureView.setSurfaceTextureListener(cameraPreview.textureListener);
        }
    }

    @Override
    protected void onPause() {
        Log.e(cameraPreview.TAG, "onPause");
        cameraPreview.closeCamera();
        cameraPreview.stopBackgroundThread();
        super.onPause();
    }


    @Override
    public void onBackPressed() {
        if(mainButtons.BACK_FLAG == true || quizzesButtons.BACK_FLAG == true){
            mainButtons.BACK_FLAG = false;
            quizzesButtons.BACK_FLAG = false;

            mainButtons.quizzesButton.setVisibility(View.VISIBLE);
            mainButtons.studentsButton.setVisibility(View.VISIBLE);
            mainButtons.classesButton.setVisibility(View.VISIBLE);

            quizzesButtons.twentyButton.setVisibility(View.GONE);
            quizzesButtons.fiftyButton.setVisibility(View.GONE);
            quizzesButtons.hundredButton.setVisibility(View.GONE);

        }else{
            finish();
        }
        return;
    }

}
