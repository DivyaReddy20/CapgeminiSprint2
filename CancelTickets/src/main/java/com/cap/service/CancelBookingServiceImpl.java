package com.cap.service;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cap.dao.CancelBookingDao;


@Service
@Transactional
public class CancelBookingServiceImpl implements CancelBookingService {
	@Autowired
   CancelBookingDao dao;
	@Override
	public void deleteBookingDetails(Integer bookingId)
    {
	      dao.delete(bookingId);
    }
	
	@Override
	public boolean getBookingData(Integer bookingId) {
		return dao.exists(bookingId);
	}
}
