package com.imine.backend.controller;

import com.imine.backend.dto.impl.PersonInfoDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Author: Ethan(Baiyp)
 * Date: 2015/7/1.
 * E-mail: baiyp@xiatekeji.com
 */
@Controller
@RequestMapping("/person-info")
public class PersonInfoController {
    private static final boolean debug = true;
    private static final int ONE_DAY = 24 * 60 * 60 * 1000;

    private static List<PersonInfoDTO> personInfos = new ArrayList<PersonInfoDTO>();



    @Inject
    public PersonInfoController() {

    }

    static {
        if (debug) {
            PersonInfoDTO p = new PersonInfoDTO();
            p.setSitUp(6);
            p.setTimestamp(new Date());
            personInfos.add(p);
            p = new PersonInfoDTO();
            p.setSitUp(8);
            p.setTimestamp(new Date());
            personInfos.add(p);
        }
    }

    @RequestMapping(value = "/getPersonInfoDTOList.ep")
    public String getPersonInfoDTOList(HttpServletRequest request, HttpServletResponse response) {

        return "SUCCESS";
    }

    public String createPersonInfoDTO(PersonInfoDTO personInfo) {
        personInfo.setTimestamp(new Date());
        return "SUCCESS";
    }

}
