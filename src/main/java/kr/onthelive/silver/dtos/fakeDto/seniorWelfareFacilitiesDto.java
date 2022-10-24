package kr.onthelive.silver.dtos.fakeDto;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;


@Data
public class seniorWelfareFacilitiesDto implements Serializable {
    public int id;
    public String operate;
    public String type;
    public String category;
    public String categoryDetail;
    public String name;
    public String manager;
    public String capacity;
    public String workers;
    public ArrayList<String> service;
    public ArrayList<String> program;
    public String phone;
    public String address;
    public String categoryPhoto;
}

