package damiano.flashcards;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

public class AddNewFlashcard extends AppCompatActivity {

    private static final String TAG = "AddNewFlashcard";
    private Context context;
    private String filename;
    private String path;
    private HashMap<String, String> englishFlashcards;
    private HashMap<String, String> polishFlashCards;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_flashcard);
        Log.d(TAG, "onCreate: create activity");
        Intent intent = getIntent();
        filename = (String) intent.getSerializableExtra("filename");
        path = (String) intent.getSerializableExtra("path");
        englishFlashcards = (HashMap<String, String>)intent.getSerializableExtra("englishMap");
        polishFlashCards = (HashMap<String, String>)intent.getSerializableExtra("polishMap");
    }

    public void clickAddNewFlashcard(View view) {
        Log.d(TAG, "clickAddNewFlashcard: click SAVE");
        addNewFlashcard();
    }

    private void addNewFlashcard() {
        Log.d(TAG, "addNewFlashcard: add new flashcard");

        context = this;
        String englishWord = "";
        String polishWord = "";
        englishWord = getEnglishWord(englishWord);
        polishWord = getPolishWord(polishWord);
        Log.d(TAG, "addNewFlashcard: " + englishWord);
        Log.d(TAG, "addNewFlashcard: " + polishWord);
        Log.d(TAG, "addNewFlashcard: " + englishFlashcards);
        englishFlashcards.put(englishWord + " - ", polishWord);
        polishFlashCards.put(polishWord + " - ", englishWord);
        writeToFile(context);
        EditText englishWordET = findViewById(R.id.englishWordET);
        EditText polishWordET = findViewById(R.id.polishWordET);
        englishWordET.setText("");
        polishWordET.setText("");
    }

    private String getEnglishWord(String englishWord) {
        Log.d(TAG, "getEnglishWord: get english word");
        EditText englishWordET = (EditText) findViewById(R.id.englishWordET);
        englishWord = englishWordET.getText().toString();

        return englishWord;
    }

    private String getPolishWord(String polishWord) {
        Log.d(TAG, "getPolishWord: get polish word");
        EditText polishWordET = (EditText) findViewById(R.id.polishWordET);
        polishWord = polishWordET.getText().toString();

        return polishWord;
    }

    private void writeToFile(Context context) {
        Log.d(TAG, "writeToFile: write to file");

        File file = new File(path);
        try {
            FileOutputStream fos = new FileOutputStream(file);
            for (Map.Entry<String, String> entry : englishFlashcards.entrySet()){
                String key = entry.getKey();
                String value = entry.getValue();
//                fos.write(key + value + "\n");
                fos.write("".getBytes());
                Toast.makeText(context, "New word saved", Toast.LENGTH_LONG).show();
            }
            fos.close();
        } catch (IOException e) {
            Log.e("Exception", "File write failed: " + e.toString());
        }
    }
}
