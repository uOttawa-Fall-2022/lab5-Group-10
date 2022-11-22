package com.example.profilemanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void OnOpenInGoogleMaps (View view) {

        EditText teamAddres = (EditText) findViewById(R.id.teamAddressField);

        // Create a Uri from an intent string. Use the result to create an Intent.
        Uri gmmIntentUri = Uri.parse("http://maps.google.co.in/maps?q="+teamAddres.getText());

        // Create an Intent from gmmIntentUri. Set the action to ACTION_VIEW
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);

        // Make the Intent explicit by setting the Google Maps package
        mapIntent.setPackage("com.google.android.apps.maps");

        // Attempt to start an activity that can handle the Intent
        startActivity(mapIntent);
    }

    public void OnSetAvatarButton(View view) {
        //Application Context and Activity
        Intent intent = new Intent(getApplicationContext(), ProfileActivity.class);
        startActivityForResult (intent,0);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_CANCELED) return;

        //Getting the Avatar Image we show to our users
        ImageView avatarImage = (ImageView) findViewById(R.id.avatarImage);

        //Figuring out the correct image
        String drawableName = "ic_logo_00";
        switch (data.getIntExtra("imageID", R.id.teamid00)) {
            case R.id.teamid00:
                drawableName = "flag_ca";
                break;
            case R.id.teamid01:
                drawableName = "flag_eg";
                break;
            case R.id.teamid02:
                drawableName = "flag_fr";
                break;
            case R.id.teamid03:
                drawableName = "flag_jp";
                break;
            case R.id.teamid04:
                drawableName = "flag_kr";
                break;
            case R.id.teamid05:
                drawableName = "flag_sp";
                break;
            case R.id.teamid06:
                drawableName = "flag_tr";
                break;
            case R.id.teamid07:
                drawableName = "flag_uk";
                break;
            case R.id.teamid08:
                drawableName = "flag_us";
                break;
            default:
                drawableName = "flag_ca";
                break;
        }
        int resID = getResources().getIdentifier(drawableName, "drawable", getPackageName());
        avatarImage.setImageResource(resID);
    }

}