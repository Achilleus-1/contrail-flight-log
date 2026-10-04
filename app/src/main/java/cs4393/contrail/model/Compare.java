package cs4393.contrail.model;

import android.util.Log;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import cs4393.contrail.LogCompareActivity;

public class Compare {

    int location1 = 0;
    private String date1;
    private String origin1;
    private String to1;
    private String ac1;
    private String aid1;
    private String flight_time1;

    int location2 = 0;
    private String date2;
    private String origin2;
    private String to2;
    private String ac2;
    private String aid2;
    private String flight_time2;

    public Compare() {
        Log.d("Compare", "Compare object created.");
    }

    public boolean findJumps(LogCompareActivity act, int index1, int index2) {
        File path = act.getApplicationContext().getFilesDir();
        File readFrom = new File(path, "logs.csv");
        Scanner scan;
        boolean answer1 = false;
        boolean answer2 = false;
        int lines = 0;

        Log.d("Compare", "Checking if indexes exist...");

        try {
            FileInputStream input = new FileInputStream(readFrom);
            scan = new Scanner(input);
            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                String[] elements = line.split(",");
                if (elements.length >= 8) {
                    int logNumber = Integer.parseInt(elements[1].trim());
                    if (logNumber == index1) {
                        answer1 = true;
                        location1 = lines;
                        date1 = elements[0];
                        origin1 = elements[2];
                        to1 = elements[3];
                        ac1 = elements[4];
                        aid1 = elements[5];
                        flight_time1 = elements[6];
                    }
                    if (logNumber == index2) {
                        answer2 = true;
                        location2 = lines;
                        date2 = elements[0];
                        origin2 = elements[2];
                        to2 = elements[3];
                        ac2 = elements[4];
                        aid2 = elements[5];
                        flight_time2 = elements[6];
                    }
                }
                lines++;
            }
        } catch (FileNotFoundException e) {
            Log.e("File not found", e.getMessage());
        } catch (IOException e) {
            Log.e("IO Exception", e.getMessage());
        }

        return answer1 && answer2;
    }

    public String getDate1() { return date1; }
    public String getDate2() { return date2; }

    public String getOrigin1() { return origin1; }
    public String getOrigin2() { return origin2; }

    public String getTo1() { return to1; }
    public String getTo2() { return to2; }

    public String getAc1() { return ac1; }
    public String getAc2() { return ac2; }

    public String getAid1() { return aid1; }
    public String getAid2() { return aid2; }

    public String getFlightTime1() { return flight_time1 + " hrs"; }
    public String getFlightTime2() { return flight_time2 + " hrs"; }
}
