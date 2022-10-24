package kr.onthelive.silver.dtos.fakeDto;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;


@Data
public class deviceListDto implements Serializable {
    public int id;
    public String deviceName;
    public String deviceId;
    public ArrayList<String> deviceCapabilities;
    public String seniorId;
    public String deviceType;
    public String photoSrc;
    public String deliveredDate;
    public int assignedQuantity;
    public int faultsQuantity;
    public int totalQuantity;
}