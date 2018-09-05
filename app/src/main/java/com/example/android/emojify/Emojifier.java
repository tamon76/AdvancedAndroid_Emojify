package com.example.android.emojify;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.SparseArray;
import android.widget.Toast;

import com.google.android.gms.vision.Frame;
import com.google.android.gms.vision.face.Face;
import com.google.android.gms.vision.face.FaceDetector;

public class Emojifier {

    int numberOfFaces = 0;

    static void detectFaces(Context context, Bitmap bitmap) {

        Frame frame = new Frame.Builder().setBitmap(bitmap).build();

        FaceDetector detector = new FaceDetector.Builder(context)
                .setTrackingEnabled(false)
                .setLandmarkType(FaceDetector.ALL_CLASSIFICATIONS)
                .build();

        if (!detector.isOperational()) {
            Toast.makeText(context,"Face detection not currently available.", Toast.LENGTH_SHORT).show();
        } else {
            SparseArray<Face> faces = detector.detect(frame);
            Toast.makeText(context,"There were " + faces.size() + " faces detected.", Toast.LENGTH_SHORT).show();
        }



    }
}
