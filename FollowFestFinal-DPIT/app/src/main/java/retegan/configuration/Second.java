package retegan.configuration;

import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ToggleButton;
import android.os.Environment;
import java.io.File;

public class Second extends AppCompatActivity {
    ToggleButton blueOnOff;
    BluetoothAdapter blueAdp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        this.showAlertDialogButtonClicked();

        blueOnOff = (ToggleButton) findViewById(R.id.button4);
        blueAdp = BluetoothAdapter.getDefaultAdapter();
        blueOnOff.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    startActivityForResult(new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE), 0);
                } else {
                    blueAdp.disable();
                }
            }
        });
    }

    public void bluemenu(View v) {
        Intent intentOpenBluetoothSettings = new Intent();
        intentOpenBluetoothSettings.setAction(android.provider.Settings.ACTION_BLUETOOTH_SETTINGS);
        startActivity(intentOpenBluetoothSettings);
    }
    public void app(View view) {
        Intent nextPage = new Intent(Second.this, MainActivity2.class);
        startActivity(nextPage);
    }

    public void showAlertDialogButtonClicked() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Salut!(page 2)");
        builder.setMessage("Mesaj 2");
        builder.setPositiveButton("OK", null);
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}
