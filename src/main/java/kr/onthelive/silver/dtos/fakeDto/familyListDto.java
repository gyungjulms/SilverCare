package kr.onthelive.silver.dtos.fakeDto;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;


@Data
public class familyListDto implements Serializable {
    public int id;
    public String name;
    public String userId;
    public String gender;
}