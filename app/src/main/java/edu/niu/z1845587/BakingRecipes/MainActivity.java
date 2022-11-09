/*
Programmer: Veronica Olvera
Z-id: Z1845587
Due Date: 3/5/21
Class: CSCI 322
*/

package edu.niu.z1845587.BakingRecipes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
    {
    private Spinner arraySpin;
    private ImageView recipeIV;
    String selection;
    public static final String INTENTKEY_TITLETV = "titleTextView";
    public static final String INTENTKEY_RECIPETV = "recipeTextView";

    @Override
    protected void onCreate(Bundle savedInstanceState)
        {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recipeIV = findViewById(R.id.recipeImageView);

        //Spinner with info from array of Strings
        arraySpin = findViewById(R.id.arraySpinner);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.spinner_view, SpinnerData.values);

        arraySpin.setAdapter(adapter);

        arraySpin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
            {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
                {
                //get the selection from the spinner
                selection = parent.getItemAtPosition(position).toString();

                //add image based on user's selection
                if (selection == "Chocolate Cake")
                    recipeIV.setImageResource(R.drawable.chocolate_cake);

                if (selection == "Strawberry Cheesecake")
                    recipeIV.setImageResource(R.drawable.strawberry_cheesecake);

                if (selection == "Birthday Cake")
                    recipeIV.setImageResource(R.drawable.birthday_cake);

                if (selection == "Key Lime Pie")
                    recipeIV.setImageResource(R.drawable.key_lime_pie);

                if (selection == "Apple Pie")
                    recipeIV.setImageResource(R.drawable.apple_pie);
                }

            @Override
            public void onNothingSelected(AdapterView<?> parent)
                {

                }
            });//end arraySpin listener
        }//end onCreate

    public void getRecipe(View view) {
        //create intent that will go to the recipe activity
        Intent recipeIntent = new Intent(MainActivity.this, RecipeActivity.class);

        recipeIntent.putExtra(INTENTKEY_TITLETV, selection);

        if (selection == "Chocolate Cake")
            recipeIntent.putExtra(INTENTKEY_RECIPETV, getResources().getString(R.string.chocolate));

        if (selection == "Strawberry Cheesecake")
            recipeIntent.putExtra(INTENTKEY_RECIPETV, getResources().getString(R.string.cheesecake));

        if (selection == "Birthday Cake")
            recipeIntent.putExtra(INTENTKEY_RECIPETV, getResources().getString(R.string.birthday));

        if (selection == "Key Lime Pie")
            recipeIntent.putExtra(INTENTKEY_RECIPETV, getResources().getString(R.string.key_lime));

        if (selection == "Apple Pie")
            recipeIntent.putExtra(INTENTKEY_RECIPETV, getResources().getString(R.string.apple));

        startActivity(recipeIntent);
        }//end get Recipe

    }//end MainActivity