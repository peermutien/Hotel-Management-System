package com.lcwd.hotel.controllers;

import com.lcwd.hotel.entites.Hotel;
import com.lcwd.hotel.exceptions.HotelAlreadyExistException;
import com.lcwd.hotel.services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import javax.validation.Valid;

@RestController
@RequestMapping("/hotels")
public class HotelController {

    @Autowired
    private HotelService hotelService;

    //create

    @PostMapping
    public ResponseEntity<Hotel> createHotel(@RequestBody @Valid Hotel hotel) throws HotelAlreadyExistException {
        return ResponseEntity.status(HttpStatus.CREATED).body(hotelService.create(hotel));
    }


    //get single

    @GetMapping("/{hotelId}")
    public ResponseEntity<Hotel> getHotel(@PathVariable String hotelId) {
        return ResponseEntity.status(HttpStatus.OK).body(hotelService.get(hotelId));
    }
    
    @GetMapping("/get")
    public void get() {
    	 hotelService.myMethod();
    }
   

    //get all
    @GetMapping
    public ResponseEntity<List<Hotel>> getAll(){
        return ResponseEntity.ok(hotelService.getAll());
    }
    
    //Delete Hotel by Id
    @DeleteMapping("/{hotelId}")
    public void deleteHotel(@PathVariable String hotelId){
    	 hotelService.deleteById(hotelId);
    }
    
    //update Hotel by id
    @PutMapping("/{hotelId}")
    public Hotel updateHotel(@RequestBody Hotel hotel,@PathVariable String hotelId) {
    	return hotelService.updateById(hotel, hotelId);
	}

}
