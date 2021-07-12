package com.web.demo.service;
/**
 * @author NguyenHuuSon
 */
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.demo.entity.Bill;
import com.web.demo.entity.Users;
import com.web.demo.repository.AdminBillRepoAn;

@Service
public class BillServiceImpSon  implements BillServiceSon{

@Override
public <S extends Bill> Bill save(S entity,Users us,double price) {
	entity.setDate(new Date());
	entity.setUsers(us);
	entity.setTotalPrice((long)price);
	Bill bill=billrepo.save(entity);
		return bill;
	}

@Autowired
AdminBillRepoAn billrepo;

}
