package com.blockchain.organdonation;
import java.util.*;
public class block{
    private String previousHash;
    private Data data;
    private Acceptor data1;
    private long timestamp;
    public String getPreviousHash() {
        return previousHash;
    }
    public Acceptor getData1() {
        return data1;
    }
    private String presentHash;
    
    public String getPresentHash() {
        return presentHash;
    }
    public Data getData() {
        return data;
    }

    public block(String previousHash, Acceptor data) {//acceptor side block constructor
        this.previousHash = previousHash;
        this.data1 = data;
        String hashdata=calculateobject(data);
        this.timestamp=new Date().getTime();
        presentHash=calculateHash(previousHash,timestamp,hashdata);
    }
    public block(String previousHash, Data data) {
        this.previousHash = previousHash;
        this.data = data;
        String hashdata=calculateobject(data);
        this.timestamp=new Date().getTime();
        presentHash=calculateHash(previousHash,timestamp,hashdata);
    }

    private String calculateobject(Acceptor data)
    {
     String acceptorID=data.getAcceptorID();
     String organ=data.getOrgan();
     String hospital=data.getHospital();
     String status=data.getStatus();
     String input=acceptorID+organ+hospital+status;
     return Hashnew.Sha256(input);

    }

    private String calculateobject(Data data)
    {
     String donorID=data.getDonorID();
     String organ=data.getOrgan();
     String hospital=data.getHospital();
     String status=data.getStatus();
     String input=donorID+organ+hospital+status;
     return Hashnew.Sha256(input);

    }
    private String calculateHash(String pre,long time,String hashdata)
    {
        String input = pre+ Long.toString(time) + hashdata;
        return Hashnew.Sha256(input);
    }
    
    public String recalculateHash() {
        String hashdata = (data != null) ? calculateobject(data) : calculateobject(data1);
        return calculateHash(previousHash, timestamp, hashdata);
    }

   
     
}

