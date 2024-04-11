package com.example.thesis;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.NodeList;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import javax.xml.parsers.DocumentBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import org.w3c.dom.Document;

public class MainActivity extends AppCompatActivity {
    private static final int PICK_XML_FILE = 1;
    private static final int PERMISSION_REQUEST_STORAGE = 100;
    private TextView testView;

    private List<String[]> data = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView titleTextView = findViewById(R.id.titleTextView);
        Button circularButton = findViewById(R.id.circularButton);
        TextView testView = findViewById(R.id.testView);

        // Request storage permission if not granted
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, PERMISSION_REQUEST_STORAGE);
        }

        // Add static data
        data.add(new String[]{"transact", "bindService", "onServiceConnected", "ServiceConnection", "android.os.Binder", "READ_SMS", "attachInterface", "WRITE_SMS",
                "TelephonyManager.getSubscriberId", "Ljava.lang.Class.getCanonicalName", "Ljava.lang.Class.getMethods", "android.intent.action.BOOT_COMPLETED",
                "Ljava.lang.Class.getField", "READ_PHONE_STATE", "android.content.Context.unregisterReceiver", "GET_ACCOUNTS", "SEND_SMS", "android.content.Context.registerReceiver",
                "getBinder", "Ljava.lang.Class.cast", "chmod", "createSubprocess", "Ljava.net.URLDecoder", "WRITE_APN_SETTINGS", "TelephonyManager.getDeviceId", "RECEIVE_SMS",
                "Ljava.lang.Class.getDeclaredField", "HttpGet.init", "Ljava.lang.Class.getPackage", "abortBroadcast", "ClassLoader", "TelephonyManager.getLine1Number",
                "getCallingUid", "USE_CREDENTIALS", "MANAGE_ACCOUNTS", "android.telephony.gsm.SmsManager", ".system.bin", "Ljava.lang.Class.getMethod", "RESTART_PACKAGES",
                "INSTALL_PACKAGES", "Ljava.lang.Class.forName", "TelephonyManager.getSimSerialNumber", "CAMERA", "CALL_PHONE", "android.intent.action.SEND", "onBind",
                "android.content.pm.Signature", "READ_SYNC_SETTINGS", "AUTHENTICATE_ACCOUNTS", "INTERNET", "PackageInstaller", "ACCESS_LOCATION_EXTRA_COMMANDS", "HttpUriRequest",
                "remount", "android.telephony.SmsManager", "RECEIVE_BOOT_COMPLETED", "android.intent.action.ACTION_POWER_CONNECTED", "findClass", "WRITE_CONTACTS", ".system.app",
                "Ljava.lang.Class.getResource", "WRITE_SYNC_SETTINGS", "android.intent.action.TIME_SET", "android.intent.action.SEND_MULTIPLE", "ACCESS_WIFI_STATE", "URLClassLoader",
                "BLUETOOTH", "WAKE_LOCK", "SYSTEM_ALERT_WINDOW", "TelephonyManager.getSimCountryIso", "chown", "NFC", "READ_HISTORY_BOOKMARKS", "HttpPost.init",
                "TelephonyManager.getNetworkOperator", "Ljava.lang.Class.getClasses", "BIND_REMOTEVIEWS", "READ_PROFILE", "READ_CALENDAR", "CHANGE_WIFI_STATE", "READ_SYNC_STATS",
                "WRITE_HISTORY_BOOKMARKS", "DISABLE_KEYGUARD", "READ_LOGS", "RECORD_AUDIO", "getCallingPid", "MODIFY_AUDIO_SETTINGS", "android.intent.action.PACKAGE_REPLACED",
                "android.intent.action.TIMEZONE_CHANGED", "BROADCAST_STICKY", "Runtime.exec", "android.intent.action.PACKAGE_ADDED", "MOUNT_UNMOUNT_FILESYSTEMS",
                "android.intent.action.ACTION_POWER_DISCONNECTED", "Ljava.lang.Class.getDeclaredClasses", "android.intent.action.PACKAGE_REMOVED", "BLUETOOTH_ADMIN",
                "android.os.IBinder", "IBinder", "WRITE_SECURE_SETTINGS", "WRITE_SETTINGS", "Ljavax.crypto.spec.SecretKeySpec", "android.intent.action.BATTERY_OKAY",
                "READ_CONTACTS", "Binder", "SUBSCRIBED_FEEDS_READ", "READ_CALL_LOG", "SUBSCRIBED_FEEDS_WRITE", "BATTERY_STATS", "RECEIVE_WAP_PUSH", "PathClassLoader",
                "KILL_BACKGROUND_PROCESSES", "ACCESS_COARSE_LOCATION", "android.intent.action.ACTION_SHUTDOWN", "Runtime.load", "android.intent.action.SENDTO", "SET_WALLPAPER"
                , "android.intent.action.NEW_OUTGOING_CALL", "CHANGE_NETWORK_STATE", "REBOOT", "DexClassLoader", "WRITE_CALENDAR", "PROCESS_OUTGOING_CALLS", "BIND_DEVICE_ADMIN",
                "CHANGE_WIFI_MULTICAST_STATE", "MASTER_CLEAR", "android.intent.action.PACKAGE_DATA_CLEARED", "FLASHLIGHT", "android.intent.action.BATTERY_LOW", "SET_ALARM",
                "RECEIVE_MMS", "divideMessage", "WRITE_CALL_LOG", "WRITE_PROFILE", "WRITE_USER_DICTIONARY", "BIND_INPUT_METHOD", "READ_SOCIAL_STREAM", "REORDER_TASKS", "defineClass",
                "PERSISTENT_ACTIVITY", "ProcessBuilder", "android.intent.action.SCREEN_ON", "READ_USER_DICTIONARY", "WRITE_SOCIAL_STREAM", "SET_TIME", "mount", "System.loadLibrary",
                "CHANGE_COMPONENT_ENABLED_STATE", "ACCESS_MOCK_LOCATION", "DUMP", "CALL_PRIVILEGED", "DELETE_PACKAGES", "READ_FRAME_BUFFER", "WRITE_GSERVICES", "ACCOUNT_MANAGER",
                "KeySpec", "sendDataMessage", "android.intent.action.CALL", "BIND_APPWIDGET", "android.intent.action.SCREEN_OFF", "intent.action.RUN", "SecretKey", "CLEAR_APP_CACHE",
                "ACCESS_FINE_LOCATION", "SET_WALLPAPER_HINTS", "Context.bindService", "MessengerService", "ACCESS_NETWORK_STATE", "android.content.pm.PackageInfo",
                "BIND_ACCESSIBILITY_SERVICE", "INTERNAL_SYSTEM_WINDOW", "SET_TIME_ZONE", "Process.start", "MOUNT_FORMAT_FILESYSTEMS", "CLEAR_APP_USER_DATA", "UPDATE_DEVICE_STATS",
                "IRemoteService", "android.intent.action.SET_WALLPAPER", "BROADCAST_WAP_PUSH", "android.intent.action.CALL_BUTTON", "INJECT_EVENTS", "ACCESS_SURFACE_FLINGER",
                "SET_PROCESS_LIMIT", "ADD_VOICEMAIL", "INSTALL_LOCATION_PROVIDER", "SET_ACTIVITY_WATCHER", "TelephonyManager.getCallState", "VIBRATE", "Runtime.getRuntime",
                "CHANGE_CONFIGURATION", "BROADCAST_SMS", "BIND_WALLPAPER", "BROADCAST_PACKAGE_REMOVED", "TelephonyManager.isNetworkRoaming", "TelephonyManager.getSimOperator",
                "WRITE_EXTERNAL_STORAGE", "android.intent.action.CAMERA_BUTTON", "android.intent.action.REBOOT", "sendMultipartTextMessage", "BIND_VPN_SERVICE", "STATUS_BAR",
                "Ljavax.crypto.Cipher", "MODIFY_PHONE_STATE", "android.intent.action.PACKAGE_RESTARTED", "READ_INPUT_STATE", "READ_EXTERNAL_STORAGE", "Ljava.lang.Object.getClass",
                "SET_ORIENTATION", "DEVICE_POWER", "EXPAND_STATUS_BAR", "GET_TASKS", "GLOBAL_SEARCH", "GET_PACKAGE_SIZE", "SET_PREFERRED_APPLICATIONS",
                "android.intent.action.PACKAGE_CHANGED"});
        data.add(new String[]{"0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0",
                "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0",
                "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0",
                "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0",
                "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0",
                "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0",
                "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0",
                "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0",
                "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0",
                "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0",
                "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0"});

        LinearLayout linearLayout = findViewById(R.id.linearLayout);

        testView = findViewById(R.id.testView);

        // Set OnClickListener for Scan
        circularButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start custom file explorer activity
                Intent intent = new Intent(MainActivity.this, FileExplorerActivity.class);
                startActivityForResult(intent, PICK_XML_FILE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_XML_FILE && resultCode == RESULT_OK) {
            if (data == null || data.getData() == null) {
                Toast.makeText(this, "Failed to get file", Toast.LENGTH_SHORT).show();
                return;
            }

            Uri uri = data.getData();
            processSelectedFile(uri);
        }
    }

    private void processSelectedFile(Uri uri) {
        try {
            // Get the Document Builder
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Open the selected XML file
            InputStream inputStream = getContentResolver().openInputStream(uri);

            // Get Document
            Document document = builder.parse(inputStream);
            document.getDocumentElement().normalize();

            // Get all the elements by the tag name
            NodeList permissions = document.getElementsByTagName("uses-permission");

            // Loop through each permission
            for (int i = 0; i < permissions.getLength(); i++) {
                // Process permission data here
            }

            // Write data to CSV
            String csvFilePath = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS) + "/output.csv";
            try (FileWriter writer = new FileWriter(csvFilePath)) {
                // Write data to CSV here
            } catch (IOException e) {
                // Handle IOException
            }

        } catch (Exception e) {
            // Handle exceptions
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode == PERMISSION_REQUEST_STORAGE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // Permission granted, you can proceed with your action
            } else {
                // Permission denied
                Toast.makeText(this, "Permission denied", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
