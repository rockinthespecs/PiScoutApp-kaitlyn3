package com.example.owen.scoutingapp2;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Auto extends AppCompatActivity {
    public EditText switchCubes;
    public EditText scaleCubes;
    public EditText exchCubes;
    public EditText teamVal;
    public EditText match;
    public TextView textView;
    public Spinner autoStart;
    public String path = Environment.getExternalStorageDirectory().getAbsolutePath() + "/applepi";

    public Button saveVal;

    public String matchNum = "";
    public String teamNum = "";
    public String baselineText = "0";
    public String sideValue = "";
    //public File file = new File (path + "/data3.txt");

    ArrayAdapter<CharSequence> adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button next = (Button) findViewById(R.id.auto);
        next.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), MainActivity.class);
                startActivityForResult(myIntent, 0);
            }

        });
        switchCubes = (EditText) ((findViewById(R.id.switchCubes)));
        scaleCubes = (EditText) ((findViewById(R.id.scaleCubes)));
        exchCubes = (EditText) ((findViewById(R.id.exchCubes)));

        match = (EditText) ((findViewById(R.id.matches)));
        teamVal = (EditText) ((findViewById(R.id.team)));

        saveVal = (Button) findViewById(R.id.save);

        File dir = new File(path);
        dir.mkdirs();

        autoStart = (Spinner) findViewById(R.id.autoStart);

        adapter = ArrayAdapter.createFromResource(this, R.array.Auto_Location, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        autoStart.setAdapter(adapter);
        autoStart.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                sideValue = String.valueOf(parent.getItemAtPosition(position));
                Toast.makeText(getBaseContext(), parent.getItemAtPosition(position) + " selected", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    public void switchCubesUp(View view) {
        try {
            switchCubes.setText(String.valueOf((Integer.parseInt(String.valueOf(switchCubes.getText()))) + 1));
        } catch (NumberFormatException e) {
            System.out.println("Not a number");
        }
    }


    public void switchCubesDown(View view) {
        try {
            switchCubes.setText(String.valueOf((Integer.parseInt(String.valueOf(switchCubes.getText()))) - 1));
        } catch (NumberFormatException e) {
            System.out.println("Not a number");
        }
    }

    public void scaleCubesUp(View view) {
        try {
            scaleCubes.setText(String.valueOf((Integer.parseInt(String.valueOf(scaleCubes.getText()))) + 1));
        } catch (NumberFormatException e) {
            System.out.println("Not a number");
        }
    }


    public void scaleCubesDown(View view) {
        try {
            scaleCubes.setText(String.valueOf((Integer.parseInt(String.valueOf(scaleCubes.getText()))) - 1));
        } catch (NumberFormatException e) {
            System.out.println("Not a number");
        }
    }

    public void exchCubesUp(View view) {
        try {
            exchCubes.setText(String.valueOf((Integer.parseInt(String.valueOf(exchCubes.getText()))) + 1));
        } catch (NumberFormatException e) {
            System.out.println("Not a number");
        }
    }


    public void exchCubesDown(View view) {
        try {
            exchCubes.setText(String.valueOf((Integer.parseInt(String.valueOf(exchCubes.getText()))) - 1));
        } catch (NumberFormatException e) {
            System.out.println("Not a number");
        }
    }

    public void onToggleClick(View view)
    {}

    public void baseline(View view) {

        if (((CheckBox) view).isChecked()) {
            baselineText = "1";
        }
    }

    public void buttonSave(View view) {

        File file = new File(path + "/data.txt");

        String labels[] = new String[1];
        labels[0] = "Auto Balls=";
        /*String[] savedText = String.valueOf(autoBallVal.getText()).split(System.getProperty("line.separator"));
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
        }*/
        String[] savedText = {"hi"};
        Save(file, savedText);
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

    public static void Save(File file, String[] data) {
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
    public static String[] Load(File file)
    {
        FileInputStream fis = null;
        try
        {
            fis = new FileInputStream(file);
        }
        catch (FileNotFoundException e) {e.printStackTrace();}
        InputStreamReader isr = new InputStreamReader(fis);
        BufferedReader br = new BufferedReader(isr);

        String test;
        int anzahl=0;
        try
        {
            while ((test=br.readLine()) != null)
            {
                anzahl++;
            }
        }
        catch (IOException e) {e.printStackTrace();}

        try
        {
            fis.getChannel().position(0);
        }
        catch (IOException e) {e.printStackTrace();}

        String[] array = new String[anzahl];
        String line;

        int i = 0;
        try
        {
            while((line=br.readLine())!=null)
            {
                array[i] = line;
                i++;
            }
        }
        catch (IOException e) {e.printStackTrace();}
        return array;
    }

}