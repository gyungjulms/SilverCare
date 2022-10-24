package kr.onthelive.silver.dtos.fakeDto;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;


@Data
public class seniorListDto implements Serializable {
    public int id;
    public String name;
    public String userId;
    public String gender;
    public String birthday;
    public String bloodType;
    public String photoSrc;
    public String device;
    public String deviceType;
    public String address;
    public String phoneNumber;
    public ArrayList<String> capabilities;
}