package com.example.profilemanager;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;

import java.io.File;
import java.util.Date;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }

    public void SetTeamIcon(View view) {
        //Creating a Return intent to pass to the Main Activity
        Intent returnIntent = new Intent();

        //Figuring out which image was clicked
        ImageView selectedImage = (ImageView) view;

        //Adding stuff to the return intent
        returnIntent.putExtra("imageID", selectedImage.getId());
        setResult(RESULT_OK, returnIntent);

        //Finishing Activity and return to main screen!
        finish();
    }

}