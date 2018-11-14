package damiano.flashcards;

import android.content.Context;
import android.content.Intent;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
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

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private String pathDMB2 = Environment.getExternalStorageDirectory() + "/Flashcards/DirectMethodBook2.txt";
    private String pathDMB3 = Environment.getExternalStorageDirectory() + "/Flashcards/DirectMethodBook3.txt";
    private String pathA1 = Environment.getExternalStorageDirectory() + "/Flashcards/FlashcardsA1.txt";
    private String pathA2 = Environment.getExternalStorageDirectory() + "/Flashcards/FlashcardsA2.txt";
    private String pathB1 = Environment.getExternalStorageDirectory() + "/Flashcards/FlashcardsB1.txt";
    private String pathB2 = Environment.getExternalStorageDirectory() + "/Flashcards/FlashcardsB2.txt";
    private String pathC1 = Environment.getExternalStorageDirectory() + "/Flashcards/FlashcardsC1.txt";
    private String pathC2 = Environment.getExternalStorageDirectory() + "/Flashcards/FlashcardsC2.txt";
    private String pathAll = Environment.getExternalStorageDirectory() + "/Flashcards/FlashcardsAll.txt";
    private String filename = "Flashcards";
    private HashMap<String, String> englishFlashcards;
    private HashMap<String, String> polishFlashcards;
//    private String data = "";
    private Context context = this;
    private final int MEMORY_ACCESS = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate: on create");
    }
//        if (ActivityCompat.shouldShowRequestPermissionRationale(MainActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
//        } else {
//            ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, MEMORY_ACCESS);
//        }
//        if (ActivityCompat.shouldShowRequestPermissionRationale(MainActivity.this, Manifest.permission.READ_EXTERNAL_STORAGE)) {
//        } else {
//            ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, MEMORY_ACCESS);
//        }
//
//        readFromFile();
//    }
//
//    @Override
//    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
//        switch (requestCode) {
//            case MEMORY_ACCESS:
//                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
//                } else {
//                    Toast.makeText(context, "Brak dostepu", Toast.LENGTH_SHORT).show();
//                }
//        }
//    }
//
//    private String readFromFile() {
//        Log.d(TAG, "readFromFile: read from file");
//
//        File file = new File(pathA1);
//        FileInputStream fileInputStream = null;
//
//        int codeRead = context.getPackageManager().checkPermission(
//                android.Manifest.permission.READ_EXTERNAL_STORAGE,
//                context.getPackageName());
//        if (codeRead == PackageManager.PERMISSION_GRANTED) {
//        if (file.exists()) {
//            Log.d(TAG, "readFromFile: file exist");
//            try {
//                fileInputStream = new FileInputStream(file);
//                if (fileInputStream != null) {
//                    InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
//                    BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
//                    String receiveString = "";
//                    StringBuilder stringBuilder = new StringBuilder();
//
//                    while ((receiveString = bufferedReader.readLine()) != null) {
//                        stringBuilder.append(receiveString + "\n");
//                    }
//
//                    fileInputStream.close();
//                    data = stringBuilder.toString();
//                    Toast.makeText(context, "File readed", Toast.LENGTH_SHORT).show();
//                }
//            } catch (FileNotFoundException e) {
//                Log.e("login activity", "File not found: " + e.toString());
//            } catch (IOException e) {
//                Log.e("login activity", "Can not read file: " + e.toString());
//            }
//            }
//        } else {
//            Log.d(TAG, "readFromFile: file no exists");
//
//            int codeWrite = context.getPackageManager().checkPermission(
//                    android.Manifest.permission.WRITE_EXTERNAL_STORAGE,
//                    context.getPackageName());
//            if (codeWrite == PackageManager.PERMISSION_GRANTED) {
//            try {
//                FileOutputStream fos = new FileOutputStream(file);
//                fos.write("".getBytes());
//                fos.close();
//                Toast.makeText(context, "File created", Toast.LENGTH_SHORT).show();
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//            }
//        }
//        writeDataToHashMap();
//        return data;
//    }
//
//    private void writeDataToHashMap() {
//        Log.d(TAG, "writeDataToHashMap: write data to map");
//        Scanner scanner = new Scanner(data);
//        String temp = null;
//        englishFlashcards = new HashMap<>();
//        polishFlashcards = new HashMap<>();
//        while (scanner.hasNextLine()) {
//            temp = scanner.nextLine();
//            String[] tab = temp.split("–");
//            englishFlashcards.put(tab[0], tab[1]);
//            polishFlashcards.put(tab[1], tab[0]);
//        }
//    }

    public void mainClick(View view) {
        Log.d(TAG, "mainClick: mainClick");

        Intent intent;

        switch (view.getId()) {
            case R.id.englishGameBtn:
                intent = new Intent(this, ChooseLevel.class);
                intent.putExtra("pathDMB2", pathDMB2);
                intent.putExtra("pathDMB3", pathDMB3);
                intent.putExtra("pathA1", pathA1);
                intent.putExtra("pathA2", pathA2);
                intent.putExtra("pathB1", pathB1);
                intent.putExtra("pathB2", pathB2);
                intent.putExtra("pathC1", pathC1);
                intent.putExtra("pathC2", pathC2);
                intent.putExtra("pathAll", pathAll);
                intent.putExtra("DMB2", "Direct Method book 2");
                intent.putExtra("DMB3", "Direct Method book 3");
                intent.putExtra("A1", "A1  Beginner/elementary");
                intent.putExtra("A2", "A2  Pre-Intermediate");
                intent.putExtra("B1", "B1  Intermediate");
                intent.putExtra("B2", "B2  Upper-Intermediate");
                intent.putExtra("C1", "C1  Advanced");
                intent.putExtra("C2", "C2  Mastery");
                intent.putExtra("All", "All words");
                intent.putExtra("Title", "English Game");
                intent.putExtra("Version", "EN");
                startActivity(intent);
                break;
            case R.id.polishGameBtn:
                intent = new Intent(this, ChooseLevel.class);
                intent.putExtra("pathDMB2", pathDMB2);
                intent.putExtra("pathDMB3", pathDMB3);
                intent.putExtra("pathA1", pathA1);
                intent.putExtra("pathA2", pathA2);
                intent.putExtra("pathB1", pathB1);
                intent.putExtra("pathB2", pathB2);
                intent.putExtra("pathC1", pathC1);
                intent.putExtra("pathC2", pathC2);
                intent.putExtra("pathAll", pathAll);
                intent.putExtra("DMB2", "Direct Method książka 2");
                intent.putExtra("DMB3", "Direct Method książka 3");
                intent.putExtra("A1", "A1  Początkujący");
                intent.putExtra("A2", "A2  Początkujący-pośredni");
                intent.putExtra("B1", "B1  Pośredni");
                intent.putExtra("B2", "B2  Wyższy-pośredni");
                intent.putExtra("C1", "C1  Zaawansowany");
                intent.putExtra("C2", "C2  Mistrzowski");
                intent.putExtra("All", "Wszystkie słowa");
                intent.putExtra("Title", "Polish Game");
                intent.putExtra("Version", "PL");
                startActivity(intent);
                break;
            case R.id.addBtn:
                intent = new Intent(this, AddNewFlashcard.class);
                intent.putExtra("filename", filename);
                intent.putExtra("pathAll", pathAll);
                intent.putExtra("englishMap", englishFlashcards);
                intent.putExtra("polishMap", polishFlashcards);
                startActivity(intent);
                break;
            case R.id.resultBtn:
                intent = new Intent(this, Result.class);
                startActivity(intent);
                break;
            case R.id.aboutBtn:
                intent = new Intent(this, About.class);
                startActivity(intent);
                break;
        }
    }
}
