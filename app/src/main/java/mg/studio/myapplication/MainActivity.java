package mg.studio.myapplication;

import android.content.Intent;
import android.util.Log;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class MainActivity extends AppCompatActivity {
    private TextView tvName;

    private SessionManager session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvName = findViewById(R.id.user_name);

        final String[] arrayDemo = {"00_LifeCycle","01_UserName","01_UserName_Final","02_Layout","02_Layout_Final",
            "03_Button_Design","03_Button_Toast","04_Button_Intent","05_Button_StartActivity","05_Button_StartActivity_extra",
            "06_ImageButton","07_EditText","08_RadioButtons_listener","08_RadioButtons_onclick","09_listView",
            "10_GetColor","11_GradientBackground","12_ImplicitIntent_AppCaller","12_ImplicitIntent_AppRecievier","13_Weather_App_Design","15_ListView",
            "16_ListViewCustomAdapter","17_AudioRecorder","19_DataBase","20_FragmentOne","21_Webview","22_serviceDemo",
            "23_Service","24_Fingerprint","25_AppPrivateDirectory","26_AssetsFolder","27_IntentExtras"};

        ArrayAdapter arrayAdapter = new ArrayAdapter(this, R.layout.item_lists, R.id.text1, arrayDemo);

        ListView listView = findViewById(R.id.listview);
        listView.setAdapter(arrayAdapter);

        /**
         * Only logged in users should access this activity
         */
        session = new SessionManager(getApplicationContext());
        if (!session.isLoggedIn()) {
            logout();
        }

        /**
         * If the user just registered an account from Register.class,
         * the parcelable should be retrieved
         */
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            // Retrieve the parcelable
            Feedback feedback = bundle.getParcelable("feedback");
            // Get the from the object
            String userName = feedback.getName();
            tvName.setText(userName);
        }

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = null;
                Log.d(getLocalClassName().toString(), arrayDemo[i]);
                switch (i){
                    case 0:intent = new Intent(view.getContext(),LifecycleMain.class);break;
                    case 1:intent = new Intent(view.getContext(),UsernameMain.class);break;
                    case 2:intent = new Intent(view.getContext(),UserfinalMain.class);break;
                    case 3:intent = new Intent(view.getContext(),LayoutMain.class);break;
                    case 4:intent = new Intent(view.getContext(),LayoutfinalMain.class);break;
                    case 5:intent = new Intent(view.getContext(),ButtondesignMain.class);break;
                    case 6:intent = new Intent(view.getContext(),ButtontoastMain.class);break;
                    case 7:intent = new Intent(view.getContext(),ButtonintentMain.class);break;
                    case 8:intent = new Intent(view.getContext(),StartActivityMain.class);break;
                    case 9:intent = new Intent(view.getContext(),StartActExtraMain.class);break;
                    case 10:intent = new Intent(view.getContext(),ImageButtonMain.class);break;
                    case 11:intent = new Intent(view.getContext(),EditTextMain.class);break;
                    case 12:intent = new Intent(view.getContext(),RadiobtnListenerMain.class);break;
                    case 13:intent = new Intent(view.getContext(),RadiobtnOnclickMain.class);break;
                    case 14:intent = new Intent(view.getContext(),ListviewMain.class);break;
                    case 15:intent = new Intent(view.getContext(),GetColorMain.class);break;
                    case 16:intent = new Intent(view.getContext(),GradientBackgroundMain.class);break;
                    case 17:intent = new Intent(view.getContext(),AppIntentCallerMain.class);break;
                    case 18:intent = new Intent(view.getContext(),AppIntentRecieverMain.class);break;
                    case 19:intent = new Intent(view.getContext(),WeatherMain.class);break;
                    case 20:intent = new Intent(view.getContext(),ListView2Main.class);break;
                    case 21:intent = new Intent(view.getContext(),ListViewCAMain.class);break;
                    case 22:intent = new Intent(view.getContext(),AudiorRecorder.class);break;
                    case 23:intent = new Intent(view.getContext(),DataBaseMain.class);break;
                    case 24:intent = new Intent(view.getContext(),FragmentMain.class);break;
                    case 25:intent = new Intent(view.getContext(),WebViewMain.class);break;
                    case 26:intent = new Intent(view.getContext(),ServiceDemoMain.class);break;
                    case 27:intent = new Intent(view.getContext(),ServiceMain.class);break;
                    case 28:intent = new Intent(view.getContext(),FingerprintMain.class);break;
                    case 29:intent = new Intent(view.getContext(),PrivateDirectory.class);break;
                    case 30:intent = new Intent(view.getContext(),AssetsMain.class);break;
                }

                startActivity(intent);
            }
        });

    }

    /**
     * Logging out the user:
     * - Will set isLoggedIn flag to false in SharedPreferences
     * - Clears the user data from SqLite users table
     */

    public void btnLogout(View view) {
        logout();
    }

    public void logout() {
        // Updating the session
        session.setLogin(false);
        // Redirect the user to the login activity
        startActivity(new Intent(this, Login.class));
        finish();
    }
}