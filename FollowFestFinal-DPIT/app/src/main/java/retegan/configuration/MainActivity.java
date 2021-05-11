package retegan.configuration;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.showAlertDialogButtonClicked();
    }

    public void gotoNextPage(View view) {
        Intent nextPage = new Intent(MainActivity.this, Second.class);
        startActivity(nextPage);
    }

    public void browser1(View view) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://support.google.com/maps/answer/6291838?co=GENIE.Platform%3DAndroid&hl=ro"));
        startActivity(browserIntent);
    }

    public void showAlertDialogButtonClicked() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("salut");
        builder.setMessage("salut! 1");
        builder.setPositiveButton("OK", null);
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}



