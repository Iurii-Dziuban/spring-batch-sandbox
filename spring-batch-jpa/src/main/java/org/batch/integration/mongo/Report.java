package org.batch.integration.mongo;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by iurii.dziuban on 08.08.2016.
 */
public class Report {

    private int id;
    private Date date;
    private long impression;
    private int clicks;
    private BigDecimal earning;

    //getter and setter methods

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public long getImpression() {
        return impression;
    }

    public void setImpression(long impression) {
        this.impression = impression;
    }

    public int getClicks() {
        return clicks;
    }

    public void setClicks(int clicks) {
        this.clicks = clicks;
    }

    public BigDecimal getEarning() {
        return earning;
    }

    public void setEarning(BigDecimal earning) {
        this.earning = earning;
    }
}
