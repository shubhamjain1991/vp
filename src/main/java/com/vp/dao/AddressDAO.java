package com.vp.dao;

import java.util.List;

import com.vp.enity.AddressDetails;

public interface AddressDAO {

	public AddressDetails findByAddrId(Long addrId);
	public List<AddressDetails> findByAddrCustomerId(Long addrCustomerId);
	
}
