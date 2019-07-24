package com.sameer.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sameer.models.Bookings;

public interface BookingRepository extends JpaRepository<Bookings,Long>{

}
