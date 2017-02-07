package example.demodatasave;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;

// first activity class
public class MainActivity extends AppCompatActivity

{

    // check box da box
    CheckBox check_box ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // finding view of check box from linked xml file i.e actvity_main
        check_box = (CheckBox) findViewById(R.id.checkBox_id);

        // getting saved shared preferences and saving it in box sp
        SharedPreferences sp = getSharedPreferences("user_info" , MODE_PRIVATE);

        // getting saved value from remember key

        // return empty if remember has no value previously
        String saved_value = sp.getString("remember","");


        // checking saved value
        if(saved_value.equals("hanji"))
        {
            // if matched directly move to new activity and finish main activity
            Intent i = new Intent(MainActivity.this , Home_Activity.class);
            startActivity(i);
            finish();
        }


    }


    // on button click function
    public void login(View v)
    {
        // checking if check box is clicked or not which returns true or false i.e boolean value
        Boolean box_value =  check_box.isChecked();


        if(box_value)
        {
            // if check box is selected save some value in remember key
            SharedPreferences.Editor sp = getSharedPreferences("user_info" , MODE_PRIVATE).edit();

            sp.putString("remember","hanji");

            sp.commit();

        }

        // start home activity
        Intent i = new Intent(MainActivity.this , Home_Activity.class);

        startActivity(i);
    }
}
