package com.example.owen.scoutingapp2;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import org.apache.commons.lang3.ArrayUtils;

import java.io.File;
import java.io.FileOutputStream;

public class MainActivity extends AppCompatActivity {
    public CheckBox penalty;
    public CheckBox climbed;
    public CheckBox defense;
    public CheckBox gearsFloor;
    public CheckBox tryClimb;
    public CheckBox defended;
    public EditText stratNotes;
    public EditText teleBallVal;
    public EditText teleGearVal;

    public String penaltyText = "0";
    public String gearsFloorText = "0";
    public String defenseText = "0";
    public String defendedText = "0";
    public String tryClimbText = "0";
    public String climbedText = "0";
    public String stratNotesText = "";
    public String teleGearValText = "";
    public String teleBallValText = "";

    public String path = Environment.getExternalStorageDirectory().getAbsolutePath() + "/applepidata";
    public File file = new File(path + "/data3.txt");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fake);

        Button next = (Button) findViewById(R.id.auto2);
        next.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent();
                setResult(RESULT_OK, intent);
                finish();
            }
        });
        penalty = (CheckBox) ((findViewById(R.id.penalty)));
        gearsFloor = (CheckBox) ((findViewById(R.id.floorGears)));
        defense = (CheckBox) ((findViewById(R.id.defense)));
        defended = (CheckBox) ((findViewById(R.id.defended)));
        tryClimb = (CheckBox) ((findViewById(R.id.tryClimb)));
        climbed = (CheckBox) ((findViewById(R.id.climb)));
        stratNotes = (EditText) ((findViewById(R.id.stratText)));
        teleBallVal = (EditText) ((findViewById(R.id.teleBallVal)));
        teleGearVal = (EditText) ((findViewById(R.id.teleGearVal)));
        File dir = new File(path);
        dir.mkdirs();


    }

    public void penalty(View view) {

        if (((CheckBox) view).isChecked()) {
            penaltyText = "1";
        }
    }

    public void floorGears(View view) {
        if (((CheckBox) view).isChecked()) {
            gearsFloorText = "1";
        }
    }

    public void defense(View view) {

        if (((CheckBox) view).isChecked()) {
            defenseText = "1";
        }
    }

    public void defended(View view) {

        if (((CheckBox) view).isChecked()) {
            defendedText = "1";
        }
    }

    public void tryClimb(View view) {

        if (((CheckBox) view).isChecked()) {
            tryClimbText = "1";
        }
    }

    public void climb(View view) {

        if (((CheckBox) view).isChecked()) {
            climbedText = "1";
        }
    }

    public void gearUp(View view) {
        try {
            teleGearVal.setText(String.valueOf((Integer.parseInt(String.valueOf(teleGearVal.getText()))) + 1));
        } catch (NumberFormatException e) {
            System.out.println("Not a number");
        }
    }

    public void
    gearDown(View view) {
        try {
            teleGearVal.setText(String.valueOf((Integer.parseInt(String.valueOf(teleGearVal.getText()))) - 1));
        } catch (NumberFormatException e) {
            System.out.println("Not a number");
        }
    }

    public void ballDown(View view) {
        try {
            teleBallVal.setText(String.valueOf((Integer.parseInt(String.valueOf(teleBallVal.getText()))) - 10));
        } catch (NumberFormatException e) {
            System.out.println("Not a number");
        }
    }

    public void ballUp(View view) {
        try {
            teleBallVal.setText(String.valueOf((Integer.parseInt(String.valueOf(teleBallVal.getText()))) + 10));
        } catch (NumberFormatException e) {
            System.out.println("Not a number");
        }
    }
    public void onToggleClick(View view)
    {}


    public void buttonSave(View view) {

        File file = new File(path + "/data9.txt");
        String labels[] = new String[1];
        labels[0] = "Tele Balls=";
        String[] savedText = String.valueOf(teleBallVal.getText()).split(System.getProperty("line.separator"));
        //String[] old = Load(file);
        String[] both2 = (String[]) ArrayUtils.addAll(labels, savedText);
        //String[] old = Load(file);
        String[] both = (String[]) ArrayUtils.addAll(labels, savedText);
        String[] finalArray = new String[labels.length];
        for (int i = 0; i < labels.length; i++) {
            if (i < labels.length) {
                finalArray[i] = labels[i];
            }
        }
        Toast.makeText(getApplicationContext(), "saved", Toast.LENGTH_LONG).show();

        String filename = "myfile";
        String string = "Hello world!";
        FileOutputStream outputStream;

        try {
            outputStream = openFileOutput(path + "/" + filename, Context.MODE_PRIVATE);
            outputStream.write(string.getBytes());
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        //Save(file, savedText);
    }
    /*private String readFromFile(Context context) {

        String ret = "";

        try {
            InputStream inputStream = context.openFileInput("what.txt");

            if (inputStream != null) {
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                String receiveString = "";
                StringBuilder stringBuilder = new StringBuilder();

                while ((receiveString = bufferedReader.readLine()) != null) {
                    stringBuilder.append(receiveString);
                }

                inputStream.close();
                ret = stringBuilder.toString();
            }
        } catch (FileNotFoundException e) {
            Log.e("login activity", "File not found: " + e.toString());
        } catch (IOException e) {
            Log.e("login activity", "Can not read file: " + e.toString());
        }

        return ret;
    }

    private void writeToFile(String data, Context context) {
        try {
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(context.openFileOutput("what.txt", Context.MODE_PRIVATE));
            outputStreamWriter.write(data);
            outputStreamWriter.close();
        } catch (IOException e) {
            Log.e("Exception", "File write failed: " + e.toString());
        }
    }
    /*
        String x = readFromFile(getApplicationContext());
        x += String.valueOf(autoBallVal.getText());

        writeToFile(x, getApplicationContext());
        Toast.makeText(getApplicationContext(), "saved", Toast.LENGTH_LONG).show();
*/
        /*String[] loadedText = Load(file);

        String finalString = "";

        for(int i = 0; i< loadedText.length; i++)
        {
            finalString += loadedText[i] + System.getProperty("line.separator");
        }
        /*String[] finalArray = new String[savedText.length + 1];
        for(int i = 0; i <= savedText.length; i++)
        {
            if(i != savedText.length)
            {
                finalArray[i] = savedText[i];
            }
            else{finalArray[savedText.length] = finalString;}
        }*/

   /* public void Save(File file, String[] data) {
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            try {
                for (int i = 0; i < data.length; i++) {
                    fos.write(data[i].getBytes());
                    if (i < data.length) {
                        fos.write("\n".getBytes());
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } finally {
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static String[] Load(File file) {
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        InputStreamReader isr = new InputStreamReader(fis);
        BufferedReader br = new BufferedReader(isr);

        String test;
        int anzahl = 0;
        try {
            while ((test = br.readLine()) != null) {
                anzahl++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            fis.getChannel().position(0);
        } catch (IOException e) {
            e.printStackTrace();
        }

        String[] array = new String[anzahl];

        String line;
        int i = 0;
        try {
            while ((line = br.readLine()) != null) {
                array[i] = line;
                i++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return array;
    }*/
}