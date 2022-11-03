/*
Programmer: Veronica Olvera
Z-id: Z1845587
Due Date: 3/5/21
Class: CSCI 322
*/

package edu.niu.z1845587.app3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class RecipeActivity extends AppCompatActivity
    {
    private TextView titleTV, recipeTV;

    @Override
    protected void onCreate(Bundle savedInstanceState)
        {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recipe_view);

        titleTV = findViewById(R.id.titleTextView);
        recipeTV = findViewById(R.id.recipeTextView);

        if (this.getIntent().getStringExtra(MainActivity.INTENTKEY_TITLETV) != null)
            titleTV.setText(this.getIntent().getStringExtra(MainActivity.INTENTKEY_TITLETV));

        if (this.getIntent().getStringExtra(MainActivity.INTENTKEY_RECIPETV) != null)
            recipeTV.setText(this.getIntent().getStringExtra(MainActivity.INTENTKEY_RECIPETV));
        }//end onCreate

    //method to handle the button click
    public void goBack(View view)
        {
        //return to the main activity
        finish();
        }//end goBack

    }//end RecipeActivity

