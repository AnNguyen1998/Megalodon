package com.web.demo.service;
/**
 * @author NguyenHuuSon
 */
import com.web.demo.entity.Bill;
import com.web.demo.entity.BillDetail;
import com.web.demo.entity.Games;

public interface BillDetailServiceSon {

	<S extends BillDetail> S save(S entity);

	<S extends BillDetail> BillDetail addbilldetail(Bill bill, Games game);

	

}
