package com.estore.security;

import org.springframework.data.repository.CrudRepository;

/**
 * @author oscarsoto on 2/22/17.
 *         There is no reasonable excuse for doing anything less than your best.
 *         - Martin, Robert C.
 */

public interface Users extends CrudRepository<User, Long> {
    public User findByUsername(String username);
}
