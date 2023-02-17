package com.lcwd.hotel.entites;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "hotels")
public class Hotel {

    @Id
    private  String id;
    
    @NotBlank(message="Please add name of hotel")
    @NotNull(message="hotel name shouldn't be null")
    private  String name;
    
   
   @NotBlank(message="Please add location of hotel")
    @NotNull(message="hotel location shouldn't be null")
    private  String location;
    
    @NotBlank(message="Please add description of hotel")
    @NotNull(message="hotel description shouldn't be null")
    private  String about;


}
