package com.lcwd.hotel.services;

import com.lcwd.hotel.entites.Hotel;
import com.lcwd.hotel.exceptions.HotelAlreadyExistException;

import java.util.List;

public interface HotelService {

    //create

    Hotel create(Hotel hotel) throws HotelAlreadyExistException;

    //get all
    List<Hotel> getAll();

    //get single
    Hotel get(String id);
    
    //deleteHotel
    void deleteById(String id);
    
    //updateHotel
    Hotel updateById(Hotel hotel , String id);

	void myMethod();


}
