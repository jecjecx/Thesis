package com.example.thesis;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find your Views
        TextView titleTextView = findViewById(R.id.titleTextView);
        Button circularButton = findViewById(R.id.circularButton);
        Button deleteMalware = findViewById(R.id.DeleteMalware);
        TextView percentageResultText = findViewById(R.id.percentageResultText);
        TextView percentageResultText2 = findViewById(R.id.percentageResultText2);
        TextView percentageResultText3 = findViewById(R.id.percentageResultText3);
        TextView percentageResultText4 = findViewById(R.id.percentageResultText4);
        TextView percentageResultText5 = findViewById(R.id.percentageResultText5);

        LinearLayout linearLayout = findViewById(R.id.linearLayout);
        LinearLayout linearLayout2 = findViewById(R.id.linearLayout2);

        // Find the bars
        View bar1 = findViewById(R.id.bar1);
        View bar2 = findViewById(R.id.bar2);
        View bar3 = findViewById(R.id.bar3);
        View bar4 = findViewById(R.id.bar4);
        View bar5 = findViewById(R.id.bar5);
        View bar6 = findViewById(R.id.bar6);


        // Set OnClickListener for Scan
        circularButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Update Scan Result
                updateScanResult(bar1, bar2, 90f, 10f);
                updateMalwares(bar3, bar4, bar5, bar6, 30f, 20f, 50f, 0f);

                // Change text
                percentageResultText.setText("90% Safe Files");
                percentageResultText2.setText("10% Malware");
                percentageResultText3.setText("30% Trojan");
                percentageResultText4.setText("20% Ransomware");
                percentageResultText5.setText("50% Spyware");
            }
        });

        // Set OnClickListener for DeleteMalware
        deleteMalware.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Restore original state
                updateScanResult(bar1, bar2, 100f, 0f);
                updateMalwares(bar3, bar4, bar5, bar6,0f, 0f, 0f, 100f);

                // Reset text
                percentageResultText.setText("100% Safe Files");
                percentageResultText2.setText("0% Malware");
                percentageResultText3.setText("0% Trojan");
                percentageResultText4.setText("0% Ransomware");
                percentageResultText5.setText("0% Spyware");
            }
        });

    }

    // Function to update the weights of bars
    private void updateScanResult(View bar1, View bar2, float weight1, float weight2) {
        LinearLayout.LayoutParams params1 = (LinearLayout.LayoutParams) bar1.getLayoutParams();
        params1.weight = weight1;
        bar1.setLayoutParams(params1);

        LinearLayout.LayoutParams params2 = (LinearLayout.LayoutParams) bar2.getLayoutParams();
        params2.weight = weight2;
        bar2.setLayoutParams(params2);
    }
    private void updateMalwares(View bar3, View bar4, View bar5, View bar6, float weight1, float weight2, float weight3, float weight4) {
        LinearLayout.LayoutParams params1 = (LinearLayout.LayoutParams) bar3.getLayoutParams();
        params1.weight = weight1;
        bar3.setLayoutParams(params1);

        LinearLayout.LayoutParams params2 = (LinearLayout.LayoutParams) bar4.getLayoutParams();
        params2.weight = weight2;
        bar4.setLayoutParams(params2);

        LinearLayout.LayoutParams params3 = (LinearLayout.LayoutParams) bar5.getLayoutParams();
        params3.weight = weight3;
        bar5.setLayoutParams(params3);

        LinearLayout.LayoutParams params4 = (LinearLayout.LayoutParams) bar6.getLayoutParams();
        params4.weight = weight4;
        bar6.setLayoutParams(params4);
    }
}
