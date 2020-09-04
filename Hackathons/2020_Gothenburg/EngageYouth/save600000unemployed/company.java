// A prototype for the Company class in Java.

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.time.Instant;
import java.util.*;

public class Company { // Company that employ persons in programmes, for example JOB
    protected String companyName;
    protected double supportSocialresursnamnd;
    protected double supportArbetsformedlingen;
    protected double supportNamndenForInkopOchUpphandling;
    protected double supportArbetsmarknadsenheten;
    protected double totFinancialSupport;
    protected double employed = 0; // Subsidized, type double to have every parameter of the same type
    protected double financialSupportPerPerson; // Per year
    protected double evaluations = 5; // By employed, from 1 to 10
    protected double unsubsidizedEmploymentAfter; // Percentage that get unsubsidized employment after working for the company
    protected double healthIncrease; // TODO: calculate average health increasement of employed
    protected double growthSpeed = 0; // Growth in percent from year to year
    protected double score = 0;
    protected Score[] allScores;
    protected Date date;
    protected double scoreGrowthSpeed = 1;

    public Company(String companyName, double supportSocialresursnamnd, double supportArbetsformedlingen, double supportNamndenForInkopOchUpphandling,
                       double supportArbetsmarknadsenheten, double employed, double evaluations, double unsubsidizedEmploymentAfter) {
        this.companyName = companyName;
        this.supportSocialresursnamnd = supportSocialresursnamnd;
        this.supportArbetsformedlingen = supportArbetsformedlingen;
        this.supportNamndenForInkopOchUpphandling = supportNamndenForInkopOchUpphandling;
        this.supportArbetsmarknadsenheten = supportArbetsmarknadsenheten;
        this.employed = employed;
        this.evaluations = evaluations;
        this.unsubsidizedEmploymentAfter = unsubsidizedEmploymentAfter;
        this.totFinancialSupport = 0; // Initial value
        this.financialSupportPerPerson = 0; // Initial value
        TotFinancialSupport();
        calculateScore();
    }
    public void setEmployed(double employed) {  // Update every year/month
        if (this.employed != 0) {
            growthSpeed = 100*employed/this.employed;
        }
        this.employed = employed;
        calculateScore();
        TotFinancialSupport(); // To get financial support per person
    }
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public void setSupportSocialresursnamnd(double supportSocialresursnamnd) {
        this.supportSocialresursnamnd = supportSocialresursnamnd;
        calculateScore();
        TotFinancialSupport();
    }
    public void setSupportArbetsformedlingen (double supportArbetsformedlingen) {
        this.supportArbetsformedlingen = supportArbetsformedlingen;
        calculateScore();
        TotFinancialSupport();
    }
    public void setSupportNamndenForInkopOchUpphandling(double supportNamndenForInkopOchUpphandling) {
        this.supportNamndenForInkopOchUpphandling = supportNamndenForInkopOchUpphandling;
        calculateScore();
        TotFinancialSupport();
    }
    public void setSupportArbetsmarknadsenhetenu(double supportArbetsmarknadsenheten) {
        this.supportArbetsmarknadsenheten = supportArbetsmarknadsenheten;
        calculateScore();
        TotFinancialSupport();
    }
    public void setEvaluations(double evaluations) {
        this.evaluations = evaluations;
        calculateScore();
    }
    public void setUnsubsidizedEmploymentAfter(double unsubsidizedEmploymentAfter) {
        this.unsubsidizedEmploymentAfter = unsubsidizedEmploymentAfter;
        calculateScore();
    }
    public double getTotFinancialSupport() {
        return totFinancialSupport;
    }
    public double getScore() {
        return this.score;
    } // TODO: getScore from certain date
    public double getScoreGrowthSpeed() {
        return this.scoreGrowthSpeed;
    }
    public void TotFinancialSupport() {
        this.totFinancialSupport = supportSocialresursnamnd + supportArbetsformedlingen + supportNamndenForInkopOchUpphandling
                + supportArbetsmarknadsenheten;
        this.financialSupportPerPerson = this.totFinancialSupport/this.employed;
    }
    public void calculateScore() {
        this.score = employed + (evaluations-5)*10 +  growthSpeed + unsubsidizedEmploymentAfter - this.financialSupportPerPerson/100; // Just an example
        Score score = new Score(this.score, new Date());
        int n = allScores.length;
        allScores[n] = score;
    }
    public void calculateScoreGrowthSpeed(Date firstDate, Date secondDate) {  // TODO: make dates into SimpleDateFormat

        // Please disregard this part. I wrote it in a hurry and it's not finished.
        Calendar c = new Calendar.getInstance();
        c.setTime(firstDate);
        Calendar c2 = new Calendar.getInstance();
        c2.setTime(secondDate);
        double firstScore;
        double secondScore;
        int i;
        boolean match;
        boolean match2;
        for (i = 0, i < allScores.length, i++) {
            if (allScores[i].calendar.equals(c)) {
                firstScore = allScores[i].score;
                match = true;
            }
        }
        if (match == false) {
            c.add(Calendar.DATE, -1);
            calculateScoreGrowthSpeed(c.getTime(), secondDate);
        }
        int j;
        for (j = 0, j < allScores.length, j++) {
            if (allScores[j].calendar.equals(c)) {
                secondScore = allScores[j].score;
                match2 = true;
            }
        }
        if (match2 == false) {
            c2.add(Calendar.DATE, -1);
            calculateScoreGrowthSpeed(c2.getTime(), secondDate);
        }
        if (match && match2) {
            scoreGrowthSpeed = 100*firstScore/secondScore;
        }
        return;
    }
    public String getResults() {
        return "Results for " + companyName + ": \r\n Financial support per person: " + financialSupportPerPerson + "\r\n Employed: " + employed
                + "\r\n Evaluations: " +  evaluations + "\r\n Persent employed who get unsubsidized employment after " +
                "programme: " + unsubsidizedEmploymentAfter + "% \r\n Growth speed: " + growthSpeed + "%" + "\r\n Overall score: "
                + score + "\r\n Score improvement speed: " + scoreGrowthSpeed + "%";
    }
}

class Score {
    Calendar calendar = new Calendar.getInstance();
    protected double score;
    public Score(double score, Date date) {
        this.score = score;
        calendar.setTime(date);
    }
    public double getScore() {
        return this.score;
    }
    public Calendar getDate() {
        return this.calendar;
    }
}

