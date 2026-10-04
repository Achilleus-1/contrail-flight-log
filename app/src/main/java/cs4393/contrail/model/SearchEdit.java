package cs4393.contrail.model;

import android.util.Log;

public class SearchEdit {

    int location = 0;

    private String date;            // 0
    private String flightNumber;    // 1
    private String origin;          // 2
    private String toLocation;      // 3
    private String aircraftMake;    // 4
    private String aid;             // 5
    private String flightTime;      // 6
    private String remarks;         // 7

    public SearchEdit() {
        Log.d("SearchEdit", "SearchEdit object created.");
    }

    public void loadFromRow(String[] row) {
        if (row.length >= 8) {
            date = row[0];
            flightNumber = row[1];
            origin = row[2];
            toLocation = row[3];
            aircraftMake = row[4];
            aid = row[5];
            flightTime = row[6];
            remarks = row[7];
        }
    }

    public String getDate() { return date; }
    public String getFlightNumber() { return flightNumber; }
    public String getOrigin() { return origin; }
    public String getToLocation() { return toLocation; }
    public String getAircraftMake() { return aircraftMake; }
    public String getAid() { return aid; }
    public String getFlightTime() { return flightTime; }
    public String getRemarks() { return remarks; }
}
