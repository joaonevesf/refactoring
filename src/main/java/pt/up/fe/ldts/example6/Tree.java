package pt.up.fe.ldts.example6;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Tree {
    private final Date plantedAt;
    private Location location;
    private final List<Date> appraisalDates;

    public Tree(Date plantedAt, String locationLatitude, String locationLongitude, String locationName){
        this.plantedAt = plantedAt;
        this.setLocation(locationLatitude, locationLongitude, locationName);
        this.appraisalDates = new ArrayList<>();
    }

    public Location getLocation() {
        return location;
    }
    public void setLocation(String locationLatitude, String locationLongitude, String locationName){
        this.location = new Location(locationLatitude,locationLongitude,locationName);
    }

    public String toString() {
        return "Tree planted at " + this.plantedAt.toString() + " in location " + location.toString();
    }

    void addAppraisal(Date appraisalDate) {
        this.appraisalDates.add(appraisalDate);
    }

    public List<Date> getAppraisals(){
        return this.appraisalDates;
    }

    public boolean isNextAppraisalOverdue(){
        Date latestAppraisalDate = getLatestAppraisalDate();
        // Calculate next appraisal date
        Date nextAppraisalDate = getCalendar(latestAppraisalDate).getTime();
        // Appraisal is only overdue if its date is in the past
        return nextAppraisalDate.before(new Date());
    }

    private Date getLatestAppraisalDate() {
        Date latestAppraisalDate = new Date();

        if (this.appraisalDates.size() > 0) {
            latestAppraisalDate = this.appraisalDates.get(0);
        }
        for(Date appraisalDate : this.appraisalDates) {
            if (latestAppraisalDate.before(appraisalDate)) {
                latestAppraisalDate = appraisalDate;
            }
        }
        return latestAppraisalDate;
    }

    private static Calendar getCalendar(Date latestAppraisalDate) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(latestAppraisalDate);
        calendar.add(Calendar.MONTH, 3);

        if (calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY)
            calendar.add(Calendar.DAY_OF_MONTH, 1);
        else if (calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY)
            calendar.add(Calendar.DAY_OF_MONTH, 2);
        return calendar;
    }

    public Date getPlantedAt() {
        return plantedAt;
    }

}
