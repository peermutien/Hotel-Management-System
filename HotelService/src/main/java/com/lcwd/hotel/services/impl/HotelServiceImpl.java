package com.lcwd.hotel.services.impl;

import com.lcwd.hotel.entites.Hotel;
import com.lcwd.hotel.exceptions.HotelAlreadyExistException;
import com.lcwd.hotel.exceptions.ResourceNotFoundException;
import com.lcwd.hotel.respositories.HotelRepository;
import com.lcwd.hotel.services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class HotelServiceImpl implements HotelService {

    @Autowired
    private HotelRepository hotelRepository;

    @Override
    public Hotel create(Hotel hotel) throws HotelAlreadyExistException  {
       
    	if(hotelRepository.existsByName(hotel.getName())) {
    		
			throw new HotelAlreadyExistException();
		}
    	String hotelId = UUID.randomUUID().toString();
        hotel.setId(hotelId);
        return hotelRepository.save(hotel);
    
    }

    @Override
    public List<Hotel> getAll() {
        return hotelRepository.findAll();
    }

    @Override
    public Hotel get(String id) {
        return hotelRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("hotel with given id not found !!"));
    }
    
    @Override
    public void myMethod() {
    	List<Integer> mylist=List.of(20, 30, 40, 50, 60, 70, 80, 90, 100, 110);
    	System.out.println("hi");
    	//System.out.println(mylist);
    }
    
    
    @Override
    public void deleteById(String id) {
    	hotelRepository.deleteById(id);
    }
    
    @Override
    public Hotel updateById(Hotel hotel , String id) {
    	return hotelRepository.save(hotel);
    }
}
