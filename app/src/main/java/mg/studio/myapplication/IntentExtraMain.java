package mg.studio.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class IntentExtraMain extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intentextra_main);

    }

    public void btnClick(View view) {
        String value = "Hello World! - This message was from the first activity.";
        Intent intent = new Intent(getApplicationContext(), IntentExtraNew.class);
        intent.putExtra("keyword", value);
        startActivity(intent);
    }

}
