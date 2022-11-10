/*
Programmer: Veronica Olvera
Z-id: Z1845587
Due Date: 3/5/21
Class: CSCI 322
*/

package edu.niu.z1845587.BakingRecipes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.view.Menu;
import android.view.MenuItem;
import androidx.appcompat.widget.Toolbar;
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
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

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

        @Override
        public boolean onCreateOptionsMenu(Menu menu)
        {
            // Inflate the menu; this adds items to the action bar if it is present.
            getMenuInflater().inflate(R.menu.menu_main, menu);
            return true;
        }//end onCreateMenuOptions

        @Override
        public boolean onOptionsItemSelected(MenuItem item)
        {
            // Handle action bar item clicks here. The action bar will
            // automatically handle clicks on the Home/Up button, so long
            // as you specify a parent activity in AndroidManifest.xml.
            int id = item.getItemId();

            //noinspection SimplifiableIfStatement
            if (id == R.id.action_add)
            {
                //Toast.makeText(MainActivity.this, "ADD selection made", LENGTH_SHORT).show();
                Intent insertIntent = new Intent(MainActivity.this, InsertActivity.class);
                startActivity(insertIntent);
                return true;
            }
            else if (id == R.id.action_edit)
            {
                //Toast.makeText(MainActivity.this, "EDIT selection made", LENGTH_SHORT).show();
                Intent updateIntent= new Intent(MainActivity.this, UpdateActivity.class);
                startActivity(updateIntent);
                return true;
            }
            else if (id == R.id.action_delete)
            {
                //Toast.makeText(MainActivity.this, "DELETE selection made", LENGTH_SHORT).show();
                Intent deleteIntent = new Intent(MainActivity.this, DeleteActivity.class);
                startActivity(deleteIntent);
                return true;
            }

            return super.onOptionsItemSelected(item);
        }//end onOptionsItemSelected


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