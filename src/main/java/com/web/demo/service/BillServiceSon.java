package com.web.demo.service;
/**
 * @author NguyenHuuSon
 */
import com.web.demo.entity.Bill;
import com.web.demo.entity.Users;

public interface BillServiceSon {

	<S extends Bill> Bill save(S entity, Users us, double price);



}
