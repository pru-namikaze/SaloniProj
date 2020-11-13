package com.nhce.saloni.saloniproj;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.nhce.saloni.saloniproj.data.model.Movie;
import com.nhce.saloni.saloniproj.data.table.Movies;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;
    EditText txtTitle,txtDescription, txtPrice;

    ArrayList<Movie> movies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.databaseReference  = FirebaseDatabase.getInstance().getReference();

        txtTitle = (EditText) findViewById(R.id.txtTitle);
        txtDescription = (EditText) findViewById(R.id.txtDescription);
        txtPrice = (EditText) findViewById(R.id.txtPrice);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case R.id.save_button:
                return createAndAddMovieToDatabase();
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private Boolean createAndAddMovieToDatabase() {
        //TODO:  Check for Empty  DataRow;
        Toast.makeText(
                this,
                Movies.getInstance().insertDataRow(new Movie(txtTitle.getText().toString(), txtDescription.getText().toString(), txtPrice.getText().toString(), ""))
                        ? "Deal Saved"
                        : "Deal couldn't be Saved",
                Toast.LENGTH_LONG).show();
        clean();
        return true;
    }

    private void clean() {
        txtTitle.setText("");
        txtDescription.setText("");
        txtPrice.setText("");
        txtTitle.requestFocus();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.save_menu, menu);
        return true;
    }
}