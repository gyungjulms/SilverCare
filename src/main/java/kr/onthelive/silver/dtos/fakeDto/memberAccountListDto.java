package kr.onthelive.silver.dtos.fakeDto;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;


@Data
public class memberAccountListDto implements Serializable {
    public int id;
    public String userId;
    public String name;
    public String gender;
    public String birthday;
    public String address;
    public String phoneNumber;
    public String role;
}