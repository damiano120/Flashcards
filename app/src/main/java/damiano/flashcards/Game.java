package damiano.flashcards;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class Game extends AppCompatActivity {

    private static final String TAG = "Game";
    private HashMap<String, String> englishFlashcards;
    private HashMap<String, String> polishFlashcards;
    private TextView gameKeyWordTV, gameValueWordTv;
    private String randomKey, value;
    private String polishWord;
    private String englishWord;
    private Context context = this;
    private int counter;
    private EditText gameWordET;
    private String path;
    private String version;
    private Button checkBtn, nextBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        Log.d(TAG, "onCreate: on create");
        Intent intent = getIntent();
        path = (String) intent.getSerializableExtra("path");
        version = (String) intent.getSerializableExtra("Version");
        String level = (String) intent.getSerializableExtra("Level");
        TextView titleGameTV = findViewById(R.id.titleGameTV);
        checkBtn = findViewById(R.id.checkBtn);
        nextBtn = findViewById(R.id.nextBtn);
        gameWordET = findViewById(R.id.gameWordET);
        if (version.equals("EN")) {
            titleGameTV.setText("English Game " + level);
            checkBtn.setText("Check");
            nextBtn.setText("Next");
            gameWordET.setHint("Polish word");
        } else if (version.equals("PL")) {
            titleGameTV.setText("Polish Game " + level);
            checkBtn.setText("Sprawdź");
            nextBtn.setText("Dalej");
            gameWordET.setHint("English word");
        }
        getDataFromFile();
    }

    private void getDataFromFile() {
        Log.d(TAG, "getDataFromFile: get data from file");
        ReadFromFile readFromFile = new ReadFromFile(path);
        englishFlashcards = readFromFile.getEnglishFlashcards();
        polishFlashcards = readFromFile.getPolishFlashcards();
        if (version.equals("EN")) {
            randomEnglishWord();
        } else if (version.equals("PL")) {
            randomPolishWord();
        }
    }

    private void randomEnglishWord() {
        Log.d(TAG, "randomEnglishWord: random english word");
        Random random = new Random();
        List<String> keys = new ArrayList<>(englishFlashcards.keySet());
        randomKey = keys.get(random.nextInt(keys.size()));
        value = englishFlashcards.get(randomKey);
        gameKeyWordTV = findViewById(R.id.gameKeyWordTV);
        gameValueWordTv = findViewById(R.id.gameValueWordTv);
        gameKeyWordTV.setText(randomKey);
        gameValueWordTv.setText("");
        nextBtn.setText("Show answer");
    }

    private String getPolishWord() {
        Log.d(TAG, "getPolishWord: get polish word");
        polishWord = gameWordET.getText().toString();

        return polishWord;
    }

    private boolean comparePolishWord() {
        Log.d(TAG, "comparePolishWord: compare polish word");
        if (value.contains(polishWord)) {
            return true;
        } else {
            return false;
        }
    }

    private void randomPolishWord() {
        Log.d(TAG, "randomPolishWord: random polish word");
        Random random = new Random();
        List<String> keys = new ArrayList<>(polishFlashcards.keySet());
        randomKey = keys.get(random.nextInt(keys.size()));
        value = polishFlashcards.get(randomKey);
        gameKeyWordTV = findViewById(R.id.gameKeyWordTV);
        gameValueWordTv = findViewById(R.id.gameValueWordTv);
        gameKeyWordTV.setText(randomKey);
        gameValueWordTv.setText("");
        nextBtn.setText("Pokaż odpowiedź");
    }

    private String getEnglishWord() {
        Log.d(TAG, "getPolishWord: get polish word");
        englishWord = gameWordET.getText().toString();

        return englishWord;
    }

    private boolean compareEnglishWord() {
        Log.d(TAG, "compareEnglishWord: compare english word");

        if (value.contains(englishWord)) {
            return true;
        } else {
            return false;
        }
    }

    public void clickGame(View view) {
        Log.d(TAG, "clickGame: click button");
        switch (view.getId()) {
            case R.id.nextBtn:
                if (counter == 0) {
                    counter = 1;
                    gameValueWordTv.setText(value);
                    if (version.equals("EN")) {
                        nextBtn.setText("Next");
                    } else if (version.equals("PL")) {
                        nextBtn.setText("Dalej");
                    }
                } else {
                    counter = 0;
                    if (version.equals("EN")) {
                        randomEnglishWord();
                    } else if (version.equals("PL")) {
                        nextBtn.setText("Dalej");
                        randomPolishWord();
                    }
                }
                break;

            case R.id.checkBtn:
                boolean trueFalse = false;
                if (version.equals("EN")) {
                    getPolishWord();
                    if (polishWord.equals("")) {
                        Toast.makeText(context, "Enter a word", Toast.LENGTH_LONG).show();
                        break;
                    }
                    trueFalse = comparePolishWord();
                } else if (version.equals("PL")) {
                    getEnglishWord();
                    if (englishWord.equals("")) {
                        Toast.makeText(context, "Wprowadź słowo", Toast.LENGTH_LONG).show();
                        break;
                    }
                    trueFalse = compareEnglishWord();
                }
                if (!trueFalse) {
                    Toast.makeText(context, "Polish word is different", Toast.LENGTH_LONG).show();
                    gameWordET.setText("");
                } else {
                    Toast.makeText(context, "Good. Polish word is the same", Toast.LENGTH_LONG).show();
                    counter = 1;
                    gameValueWordTv.setText(value);
                    gameWordET.setText("");
                    if (version.equals("EN")) {
                        nextBtn.setText("Next");
                    } else if (version.equals("PL")) {
                        nextBtn.setText("Dalej");
                    }
                }
                break;
        }
    }
}
