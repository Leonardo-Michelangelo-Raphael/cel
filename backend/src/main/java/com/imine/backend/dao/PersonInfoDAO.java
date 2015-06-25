package com.imine.backend.dao;

import com.imine.backend.dto.impl.PersonInfoDTO;
import com.imine.backend.model.PersonInfo;

/**
 * Created by dev on 2015/6/25.
 */
public interface PersonInfoDAO {
    /**
     * Create a personInfo object which will record it in database
     *
     * @param personInfoDTO
     * @return the id after it successfully recording
     */
    long createPersonInfo(PersonInfoDTO personInfoDTO);

    /**
     * Get a specified personinfo object from database through its id
     *
     * @param id
     * @return
     */
    PersonInfo getPersonInfo(long id);

    /**
     * Delete a specified personinfo object from database through its id
     *
     * @param id
     */
    void rectrivePersonInfo(long id);

    /**
     * Update a specified personinf object from database through its id
     *
     * @param id
     */
    void updatePersonInfo(long id);
}
