package com.web.demo.service;

import com.web.demo.entity.Bill;
import com.web.demo.entity.Users;

public interface BillServiceSon {

	<S extends Bill> Bill save(S entity, Users us, double price);



}
