package com.example.poultrysalesapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Vibrator;
import android.util.SparseArray;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.vision.CameraSource;
import com.google.android.gms.vision.Detector;
import com.google.android.gms.vision.barcode.Barcode;
import com.google.android.gms.vision.barcode.BarcodeDetector;
import com.google.zxing.Result;

import java.io.IOException;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class QRScannerKori extends AppCompatActivity {


//    private ZXingScannerView scannerView;


    ObjectAnimator animator;
    SurfaceView surfaceView;
    CameraSource cameraSource;
    TextView textViewqr;
    BarcodeDetector barcodeDetector;
    View scannerBar;
    private static final int REQUEST_CAMERA_PERMISSION = 201;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qrscanner_kori);


//        surfaceView = (SurfaceView)findViewById(R.id.camerapreview);

        surfaceView = (SurfaceView)findViewById(R.id.camerapreview);
        textViewqr = (TextView)findViewById(R.id.textViewqr);
        scannerBar = findViewById(R.id.scannerBar);

        barcodeDetector = new BarcodeDetector.Builder(this)
                .setBarcodeFormats(Barcode.QR_CODE).build();


        cameraSource = new CameraSource.Builder(this, barcodeDetector)
                .setRequestedPreviewSize(640, 480).build();





        animator = null;

        ViewTreeObserver vto = surfaceView.getViewTreeObserver();
        vto.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {

                surfaceView.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                if (Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN) {
                    surfaceView.getViewTreeObserver().
                            removeGlobalOnLayoutListener(this);

                } else {
                    surfaceView.getViewTreeObserver().
                            removeOnGlobalLayoutListener(this);
                }

                float destination = (float) (surfaceView.getY() +
                        surfaceView.getHeight())- (float)40.0;
//                float destination = (float) (surfaceView.getHeight());

//                animator = ObjectAnimator.ofFloat(scannerBar, "translationY",
//                        surfaceView.getY(),
//                        destination);
                animator = ObjectAnimator.ofFloat(scannerBar, "translationY",
                        surfaceView.getY(),
                        destination);

                animator.setRepeatMode(ValueAnimator.REVERSE);
                animator.setRepeatCount(ValueAnimator.INFINITE);
                animator.setInterpolator(new AccelerateDecelerateInterpolator());
                animator.setDuration(3360);
                animator.start();

            }
        });







        surfaceView.getHolder().addCallback(new SurfaceHolder.Callback() {
            @Override
            public void surfaceCreated(SurfaceHolder holder) {
                try {
                    if (ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED) {
                        cameraSource.start(surfaceView.getHolder());
                    } else {
                        ActivityCompat.requestPermissions(QRScannerKori.this, new
                                String[]{Manifest.permission.CAMERA}, REQUEST_CAMERA_PERMISSION);
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }


            }

            @Override
            public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
            }

            @Override
            public void surfaceDestroyed(SurfaceHolder holder) {
                cameraSource.stop();
            }
        });


        barcodeDetector.setProcessor(new Detector.Processor<Barcode>() {
            @Override
            public void release() {

            }

            @Override
            public void receiveDetections(Detector.Detections<Barcode> detections) {
                final SparseArray<Barcode> qrCodes = detections.getDetectedItems();

                if (qrCodes.size()!=0)
                {
                    textViewqr.post(new Runnable() {
                        @Override
                        public void run() {
                            Vibrator vibrator = (Vibrator)getApplicationContext().getSystemService(Context.VIBRATOR_SERVICE);
                            vibrator.vibrate(1000);
                            textViewqr.setText(qrCodes.valueAt(0).displayValue);
                        }
                    });
                }
            }
        });


//        scannerView = new ZXingScannerView(this);
//        scannerView.setResultHandler(new ZXingScannerResultHandler());
//
//        setContentView(scannerView);
//        scannerView.startCamera();
    }


//    public void scanCode(View view)
//    {
//        scannerView = new ZXingScannerView(this);
//        scannerView.setResultHandler(new ZXingScannerResultHandler());
//
//        setContentView(scannerView);
//        scannerView.startCamera();
//    }


//    @Override
//    protected void onPause() {
//        super.onPause();
//        scannerView.stopCamera();
//    }

//    class ZXingScannerResultHandler implements ZXingScannerView.ResultHandler
//    {
//        @Override
//        public void handleResult(Result result)
//        {
//
//            String resultCode = result.getText();
//            Toast.makeText(QRScannerKori.this,resultCode,Toast.LENGTH_SHORT).show();
//
//            setContentView(R.layout.activity_qrscanner_kori);
//            scannerView.stopCamera();
//        }
//    }
}
