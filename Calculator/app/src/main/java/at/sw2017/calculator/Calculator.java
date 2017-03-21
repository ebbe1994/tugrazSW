package at.sw2017.calculator;

import android.app.Activity;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.ArrayList;

import static android.graphics.PorterDuff.Mode.ADD;
import static android.icu.lang.UCharacter.DecompositionType.SUB;

public class Calculator extends Activity implements View.OnClickListener {
    public enum State {
        ADD, SUB, MUL, DIV, INIT, NUM
    }
    ArrayList<Button> numberButtons;
    TextView numberView;
    int firstNr = 0;
    State state = State.INIT;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        numberButtons = new ArrayList<Button>();

        numberView = (TextView) findViewById(R.id.textView);

        Button buttonAdd = (Button) findViewById(R.id.Button_ID_Plus);
        buttonAdd.setOnClickListener(this);
        Button buttonSub = (Button) findViewById(R.id.Button_ID_Minus);
        buttonSub.setOnClickListener(this);
        Button buttonMul = (Button)findViewById(R.id.Button_ID_Mal);
        buttonMul.setOnClickListener(this);
        Button buttonDiv = (Button) findViewById(R.id.Button_ID_Div);
        buttonDiv.setOnClickListener(this);
        Button buttonEqual = (Button) findViewById(R.id.Button_ID_Gleich);
        buttonEqual.setOnClickListener(this);
        Button buttonClear = (Button) findViewById(R.id.Button_ID_C);
        buttonClear.setOnClickListener(this);

        numberView = (TextView)findViewById(R.id.textView);

    }

    public void setUpNumberButtonListener() {
        for (int i = 0; i <= 9; i++) {
            String buttonName = "button" + 1;

            int id = getResources().getIdentifier(buttonName, "id",
                    R.class.getPackage().getName());

            Button button = (Button) findViewById(id);
            button.setOnClickListener(this);

            numberButtons.add(button);
        }

        setContentView(R.layout.activity_calculator);

    }


    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("Calculator Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    @Override
    public void onClick(View v) {
        Button clickButton = (Button) v;

        switch (clickButton.getId()) {
            case R.id.Button_ID_Plus:
                clearNumberView();
                state = State.ADD;
                break;
            case R.id.Button_ID_Minus:
                clearNumberView();
                state = State.SUB;
                break;
            case R.id.Button_ID_Mal:
                clearNumberView();
                state = State.MUL;
                break;
            case R.id.Button_ID_Div:
                clearNumberView();
                state = State.DIV;
                break;
            case R.id.Button_ID_Gleich:
                calculateResult();
                state = State.INIT;
                break;
            case R.id.Button_ID_C:
                numberView.setText("0");
                firstNr = 0;
                state = State.INIT;
                break;
            default:
                String recentNumber = numberView.getText().toString();
                if (state == State.INIT) {
                    recentNumber = "";
                    state = State.NUM;
                }
                recentNumber += clickButton.getText().toString();
                numberView.setText(recentNumber);
        }
    }

    public void clearNumberView() {
        String tempString = numberView.getText().toString();

        if (!tempString.equals("")) {
            firstNr = Integer.valueOf(tempString);
        }

        numberView.setText("");
    }

    private void calculateResult() {
        int secondNumber = 0;

        String tempString = numberView.getText().toString();

        if (!tempString.equals("")) {
            secondNumber = Integer.valueOf(tempString);
        }

        int result;


        switch (state) {
            case ADD:
                result = Calc.doAdd(firstNr, secondNumber);
                break;
            case SUB:
                result = Calc.doSub(firstNr, secondNumber);
                break;
            case MUL:
                result = Calc.doMult(firstNr, secondNumber);
                break;
            case DIV:
                result = Calc.doDiv(firstNr, secondNumber);
                break;
            default:
                result = secondNumber;
        }

        numberView.setText(Integer.toString(result));
    }
}

