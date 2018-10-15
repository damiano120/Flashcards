package damiano.flashcards;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class About extends AppCompatActivity {

    private TextView aboutTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        aboutTV = (TextView) findViewById(R.id.aboutTV);
        aboutTV.setText(printabout());

    }

    private String printabout() {
        return "Dev. damiano120 \n" + "ver. 0.8";
    }
}
