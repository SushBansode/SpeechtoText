package tatastrive.application.speechtotext;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.speech.RecognizerIntent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    TextView voiceInput,sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
        voiceInput=findViewById( R.id.voiceInput );
        sp=findViewById( R.id.btnspeck );
        sp.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText( MainActivity.this, "Clicked", Toast.LENGTH_SHORT ).show();
                boolhalkehalke();
            }
        } );
    }

    private void boolhalkehalke() {
        Intent intent= new Intent( RecognizerIntent.ACTION_RECOGNIZE_SPEECH );
        intent.putExtra( RecognizerIntent.EXTRA_LANGUAGE_MODEL,RecognizerIntent.LANGUAGE_MODEL_FREE_FORM );
        intent.putExtra( RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
        intent.putExtra( RecognizerIntent.EXTRA_PROMPT,"Hi Speck something");
        try {
            startActivityForResult( intent, 20 );
        }catch (ActivityNotFoundException a)
        {

        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult( requestCode, resultCode, data );
        switch (requestCode) {
            case 20:
                if (resultCode == RESULT_OK && null != data) {
                    ArrayList <String> result=data.getStringArrayListExtra( RecognizerIntent.EXTRA_RESULTS );
                    voiceInput.setText(result.get(0));
                }
                break;
        }
    }
}
