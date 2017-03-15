package at.sw2017.calculator;

import android.app.Activity;
import android.support.v4.view.ViewPropertyAnimatorListener;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;

import static at.sw2017.calculator.R.id.buttonAdd;

public class Calculator extends Activity implements View.OnClickListener {
    ArrayList<Button> numberButtons;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        numberButtons = new ArrayList<Button>();
        Button buttonAdd = (Button)findViewById(R.id.buttonAdd);
        buttonAdd.setOnClickListener(this);



        setContentView(R.layout.activity_calculator);


        public void setUpNumberButtonListener() {
        for (int i = 0; i <= 9; i++) {
            String buttonName = "button" + 1;

            int id = getResources().getIdentifier(buttonName, "id",
                    R.class.getPackage().getName());

            Button button = (Button) findViewById(id);
            button.setOnClickListener(this);

            numberButtons.add(button);
        }
    }


    @Override
    public void onClick(View v) {

    }
}

