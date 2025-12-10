package com.blockchain.organdonation;
public class Data {
    private String blockID;
    private String donorID;
    private String organ;
    private String hospital;
    private String status;
    
   public String getBlockID() {
      return blockID;
    }
    public void setBlockID(String blockID) {
      this.blockID = blockID;
    }
   public Data(String blockID, String donorID, String organ, String hospital, String status) {
      this.blockID = blockID;
      this.donorID = donorID;
      this.organ = organ;
      this.hospital = hospital;
      this.status = status;
    }
    public String getDonorID() {
      return donorID;
    }
    public void setDonorID(String donorID) {
      this.donorID = donorID;
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
  
