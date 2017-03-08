package com.estore.dao;

import com.estore.model.Customer;
import org.springframework.data.repository.CrudRepository;

/**
 * @author oscarsoto on 3/5/17.
 *         There is no reasonable excuse for doing anything less than your best.
 *         - Martin, Robert C.
 */
public interface CustomerDao extends CrudRepository<Customer, Long> {
}
