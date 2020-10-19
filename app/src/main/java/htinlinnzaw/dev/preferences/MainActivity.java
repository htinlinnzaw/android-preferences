package htinlinnzaw.dev.preferences;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;

public class MainActivity extends Activity {
    private static final String KEY = "key";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText edittext = findViewById(R.id.editText);
        edittext.setOnEditorActionListener((textView, actionId, event) -> {
            String value = textView.getText().toString();
            save(KEY,value);
            return false;
        });
        SharedPreferences sharedpreferences = getPreferences(MODE_PRIVATE);
        String value = sharedpreferences.getString(KEY,"");
        Log.e("Storing value",value);
        edittext.setText(value);
    }
    public void save(String key,String value) {
        SharedPreferences sharedpreferences = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString(key,value);
        editor.apply();
    }
}
