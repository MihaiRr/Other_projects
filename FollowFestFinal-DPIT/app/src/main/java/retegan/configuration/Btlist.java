package retegan.configuration;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.util.Set;


public class Btlist extends AppCompatActivity  {
    TextView textview1;
    private static final int REQUEST_ENABLE_BT = 1;
    BluetoothAdapter btAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.btlist1);
        textview1 = (TextView) findViewById(R.id.textView1);
        btAdapter = BluetoothAdapter.getDefaultAdapter();
        CheckBluetoothState();
    }


    protected void onActivityRestult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_ENABLE_BT) {
            CheckBluetoothState();
        }
    }

    private void CheckBluetoothState() {
        if (btAdapter == null) {
            textview1.append("\nBluetooth NOT supported");
            return;
        } else {
            if (btAdapter.isEnabled()) {
                textview1.append("\nBluetooth is enabled...");
                textview1.append("\nPaired devices are");
                Set<BluetoothDevice> devices = btAdapter.getBondedDevices();
                for (BluetoothDevice device : devices) {
                    textview1.append("\nDevice: " + device.getName() + ", " + device);

                }
            } else {
                 Intent enableBtintent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
                startActivityForResult(enableBtintent, REQUEST_ENABLE_BT);

            }
    }

}}