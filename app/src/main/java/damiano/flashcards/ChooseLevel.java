package damiano.flashcards;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Scanner;

public class ChooseLevel extends AppCompatActivity {

    private static final String TAG = "ChooseLevel";
    private String pathDMB2;
    private String pathDMB3;
    private String pathA1;
    private String pathA2;
    private String pathB1;
    private String pathB2;
    private String pathC1;
    private String pathC2;
    private String pathAll;
    private Context context = this;
    private Button dmb2Btn, dmb3Btn,
            a1Btn, a2Btn, b1Btn, b2Btn, c1Btn, c2Btn, allWordsBtn;
    private String version;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_level);
        Log.d(TAG, "onCreate: on Create");
        Intent intent = getIntent();
        pathDMB2 = (String) intent.getSerializableExtra("pathDMB2");
        pathDMB3 = (String) intent.getSerializableExtra("pathDMB3");
        pathA1 = (String) intent.getSerializableExtra("pathA1");
        pathA2 = (String) intent.getSerializableExtra("pathA2");
        pathB1 = (String) intent.getSerializableExtra("pathB1");
        pathB2 = (String) intent.getSerializableExtra("pathB2");
        pathC1 = (String) intent.getSerializableExtra("pathC1");
        pathC2 = (String) intent.getSerializableExtra("pathC2");
        pathAll = (String) intent.getSerializableExtra("pathAll");
        version = (String) intent.getSerializableExtra("Version");
        dmb2Btn = findViewById(R.id.dmb2Btn);
        dmb3Btn = findViewById(R.id.dmb3Btn);
        a1Btn = findViewById(R.id.a1Btn);
        a2Btn = findViewById(R.id.a2Btn);
        b1Btn = findViewById(R.id.b1Btn);
        b2Btn = findViewById(R.id.b2Btn);
        c1Btn = findViewById(R.id.c1Btn);
        c2Btn = findViewById(R.id.c2Btn);
        allWordsBtn = findViewById(R.id.allWordsBtn);
        TextView chooseLevelTitleTV = findViewById(R.id.chooseLevelTitleTV);
        dmb2Btn.setText((String) intent.getSerializableExtra("DMB2"));
        dmb3Btn.setText((String) intent.getSerializableExtra("DMB3"));
        a1Btn.setText((String) intent.getSerializableExtra("A1"));
        a2Btn.setText((String) intent.getSerializableExtra("A2"));
        b1Btn.setText((String) intent.getSerializableExtra("B1"));
        b2Btn.setText((String) intent.getSerializableExtra("B2"));
        c1Btn.setText((String) intent.getSerializableExtra("C1"));
        c2Btn.setText((String) intent.getSerializableExtra("C2"));
        allWordsBtn.setText((String) intent.getSerializableExtra("All"));
        chooseLevelTitleTV.setText((String) intent.getSerializableExtra("Title"));
    }

    public void clickGame(View view) {
        Log.d(TAG, "clickGame: click button");

        Intent intent;
        switch (view.getId()) {
            case R.id.dmb2Btn:
                intent = new Intent(this, Game.class);
                intent.putExtra("path", pathDMB2);
                intent.putExtra("Version", version);
                intent.putExtra("Level", "DMB2");
                startActivity(intent);
                break;
            case R.id.dmb3Btn:
                intent = new Intent(this, Game.class);
                intent.putExtra("path", pathDMB3);
                intent.putExtra("Version", version);
                intent.putExtra("Level", "BMB3");
                startActivity(intent);
                break;
            case R.id.a1Btn:
                intent = new Intent(this, Game.class);
                intent.putExtra("path", pathA1);
                intent.putExtra("Version", version);
                intent.putExtra("Level", "A1");
                startActivity(intent);
                break;
            case R.id.a2Btn:
                intent = new Intent(this, Game.class);
                intent.putExtra("path", pathA2);
                intent.putExtra("Version", version);
                intent.putExtra("Level", "A2");
                startActivity(intent);
                break;
            case R.id.b1Btn:
                intent = new Intent(this, Game.class);
                intent.putExtra("path", pathB1);
                intent.putExtra("Version", version);
                intent.putExtra("Level", "B1");
                startActivity(intent);
                break;
            case R.id.b2Btn:
                intent = new Intent(this, Game.class);
                intent.putExtra("path", pathB2);
                intent.putExtra("Version", version);
                intent.putExtra("Level", "B2");
                startActivity(intent);
                break;
            case R.id.c1Btn:
                intent = new Intent(this, Game.class);
                intent.putExtra("path", pathC1);
                intent.putExtra("Version", version);
                intent.putExtra("Level", "C1");
                startActivity(intent);
                break;
            case R.id.c2Btn:
                intent = new Intent(this, Game.class);
                intent.putExtra("path", pathC2);
                intent.putExtra("Version", version);
                intent.putExtra("Level", "C2");
                startActivity(intent);
                break;
            case R.id.allWordsBtn:
                intent = new Intent(this, Game.class);
                intent.putExtra("path", pathAll);
                intent.putExtra("Version", version);
                intent.putExtra("Level", "All");
                startActivity(intent);
                break;
        }
    }
}
