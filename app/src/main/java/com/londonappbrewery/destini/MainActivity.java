package com.londonappbrewery.destini;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    // TODO: Steps 4 & 8 - Declare member variables here:
        Button topButton;
        Button lowerButton;
        TextView questionView;
        int qIndex = 1;
        int questionViewBackup = 0;
        int topBackup = 1;
        int lowBackup = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*if(savedInstanceState != null)
        {

            qIndex = savedInstanceState.getInt("qIndex2");

        }
        else
        {
           qIndex = 1;
        }*/




        // TODO: Step 5 - Wire up the 3 views from the layout to the member variables:
        topButton = (Button) (findViewById(R.id.buttonTop));
        lowerButton = (Button)(findViewById(R.id.buttonBottom));
        questionView = (TextView)(findViewById(R.id.storyTextView));

        final int question_arr[] = new int[]{R.string.T1_Story,R.string.T2_Story,
        R.string.T3_Story};

        final int top_arr[] = new int[]{R.string.T1_Ans1,R.string.T2_Ans1,R.string.T3_Ans1};

        final int low_arr[] = new int[]{R.string.T1_Ans2,
        R.string.T2_Ans2, R.string.T3_Ans2};

        final AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("Game Over!");
        alert.setCancelable(false);
        alert.setMessage("The End");
        alert.setPositiveButton("Close App", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        //questionView.setText();

        topButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (qIndex == 1) {
                    questionView.setText(question_arr[2]);
                    topButton.setText(top_arr[2]);
                    lowerButton.setText(low_arr[2]);
                    qIndex = 3;

                } else if (qIndex == 3) {
                    questionView.setText(R.string.T6_End);
                    topButton.setText("Exit");
                    lowerButton.setVisibility(View.GONE);

                    qIndex = 4;

                } else if (qIndex == 2) {
                    questionView.setText(question_arr[2]);
                    topButton.setText(top_arr[2]);
                    lowerButton.setText(low_arr[2]);
                    qIndex = 3;

                }
                else if(qIndex == 4)
                {

                            alert.show();
                }
            }
        });
        lowerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(qIndex == 3)
                {
                    questionView.setText(R.string.T5_End);
                    topButton.setText("Exit");
                    lowerButton.setVisibility(View.GONE);
                    qIndex = 4;

                }
                else if(qIndex == 1)
                {
                    questionView.setText(question_arr[1]);
                    topButton.setText(top_arr[1]);
                    lowerButton.setText(low_arr[1]);
                    qIndex = 2;
                }
                else if(qIndex == 2)
                {
                    questionView.setText(R.string.T4_End);
                    topButton.setText("Exit");
                    lowerButton.setVisibility(View.GONE);
                    qIndex = 4;
                }
                else if(qIndex == 4)
                {

                            alert.show();

                }
            }
        });

    }
    @Override
    public void onSaveInstanceState(Bundle outState)
    {
        super.onSaveInstanceState(outState);

        outState.putInt("qIndex2", qIndex);

    }
}
