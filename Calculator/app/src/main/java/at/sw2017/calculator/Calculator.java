package at.sw2017.calculator;

import android.app.Activity;
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

public class Calculator extends Activity implements View.OnClickListener {
    ArrayList<Button> numberButtons;
    TextView numberView;
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
        Button buttonAdd = (Button) findViewById(R.id.buttonAdd());
        buttonAdd.setOnClickListener(this);
        Button buttonSub = (Button) findViewById(R.id.buttonSub());
        buttonSub.setOnClickListener(this);
        Button buttonDiv = (Button) findViewById(R.id.buttonDiv());
        buttonDiv.setOnClickListener(this);
        Button buttonEqual = (Button) findViewById(R.id.buttonEqual());
        buttonEqual.setOnClickListener(this);
        Button buttonClear = (Button) findViewById(R.id.buttonClear());
        buttonClear.setOnClickListener(this);

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
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


    @Override
    public void onClick(View v) {
        Button clickedButton = (Button) v;

        switch  (clickedButton.getId()){
            case R.id.buttonAdd:
                break;
            case R.id.butt
        }

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
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        AppIndex.AppIndexApi.start(client, getIndexApiAction());
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(client, getIndexApiAction());
        client.disconnect();
    }
}

