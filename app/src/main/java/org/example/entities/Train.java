package org.example.entities;

import java.util.List;
import java.util.Map;

public class Train {
    private String trainid;
    private String trainNo;
    private List <List<Integer>> seat;
    private Map <String,String> stationtime;
    private List<String> station;

    public Train () {}

    public Train (String trainid,String trainNo,List <List<Integer>> seat,Map <String,String> stationtime,List<String> station) {
        this.trainid = trainid;
        this.trainNo = trainNo;
        this.seat = seat;
        this.stationtime = stationtime;
        this.station = station;
    }

    public String getTrainid()
    {
        return trainid;
    }
    public void setTrainid(String trainid)
    {
        this.trainid = trainid;
    }
    public String getTrainNo()
    {
        return trainNo;
    }
    public void setTrainNo(String trainNo)
    {
        this.trainNo=trainNo;
    }
    public List <List<Integer>> getseat()
    {
        return  seat;
    }
    public Map <String,String> getstationtime()
    {
        return stationtime;
    }
    public List<String> getstation()
    {
        return station;
    }
    public void setSeat(List <List<Integer>> seat)
    {
        this.seat=seat;
    }
    public  void setStationtime (Map <String,String> stationtime)
    {
        this.stationtime=stationtime;
    }
    public void setStation(List<String> station)
    {
        this.station=station;
    }
    @Override
    public String toString() {
        return "Train{trainId='" + trainid + "', no='" + trainNo + "'}";
    }
}

