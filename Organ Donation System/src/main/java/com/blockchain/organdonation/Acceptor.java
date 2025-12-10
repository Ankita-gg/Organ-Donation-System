package com.blockchain.organdonation;

public class Acceptor {
    private String blockID;
    private String AcceptorID;
    private String organ;
    private String hospital;
    private String status;
    public String getBlockID() {
      return blockID;
  }
    public void setBlockID(String blockID) {
      this.blockID = blockID;
    }
    public Acceptor(String blockID, String acceptorID, String organ, String hospital, String status) {
      this.blockID = blockID;
      AcceptorID = acceptorID;
      this.organ = organ;
      this.hospital = hospital;
      this.status = status;
  }
  
    public String getAcceptorID() {
      return AcceptorID;
    }
    public void setAcceptorID(String acceptorID) {
      AcceptorID = acceptorID;
    }
    public String getOrgan() {
      return organ;
    }
    public void setOrgan(String organ) {
      this.organ = organ;
    }
    public String getHospital() {
      return hospital;
    }
    public void setHospital(String hospital) {
      this.hospital = hospital;
    }
    public String getStatus() {
      return status;
    }
    public void setStatus(String status) {
      this.status = status;
    }
  
  }
  