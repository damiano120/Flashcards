package damiano.flashcards;

import android.util.Log;
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

public class ReadFromFile {

    private static final String TAG = "ReadFromFile";
    private String path;
    private String data = "";
    private HashMap<String, String> englishFlashcards;
    private HashMap<String, String> polishFlashcards;

    public ReadFromFile(String path) {
        this.path = path;
        readFromFile();
    }

    public HashMap<String, String> getEnglishFlashcards() {
        return englishFlashcards;
    }

    public HashMap<String, String> getPolishFlashcards() {
        return polishFlashcards;
    }

    private String readFromFile() {
        Log.d(TAG, "readFromFile: read from file");

        File file = new File(path);
        FileInputStream fileInputStream = null;
        if (file.exists()) {
            Log.d(TAG, "readFromFile: file exist");
            try {
                fileInputStream = new FileInputStream(file);
                if (fileInputStream != null) {
                    InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
                    BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                    String receiveString = "";
                    StringBuilder stringBuilder = new StringBuilder();

                    while ((receiveString = bufferedReader.readLine()) != null) {
                        stringBuilder.append(receiveString + "\n");
                    }

                    fileInputStream.close();
                    data = stringBuilder.toString();
//                    Toast.makeText(context, "File readed", Toast.LENGTH_SHORT).show();
                }
            } catch (FileNotFoundException e) {
                Log.e("login activity", "File not found: " + e.toString());
            } catch (IOException e) {
                Log.e("login activity", "Can not read file: " + e.toString());
            }
        } else {
            Log.d(TAG, "readFromFile: file no exists");

            try {
                FileOutputStream fos = new FileOutputStream(file);
                fos.write("".getBytes());
                fos.close();
//                Toast.makeText(context, "File created", Toast.LENGTH_SHORT).show();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        writeDataToHashMap();
        return data;
    }

    private void writeDataToHashMap() {
        Log.d(TAG, "writeDataToHashMap: write data to map");
        Scanner scanner = new Scanner(data);
        String temp = null;
        englishFlashcards = new HashMap<>();
        polishFlashcards = new HashMap<>();
        while (scanner.hasNextLine()) {
            temp = scanner.nextLine();
            String[] tab = temp.split("–");
            englishFlashcards.put(tab[0], tab[1]);
            polishFlashcards.put(tab[1], tab[0]);
        }
    }
}
