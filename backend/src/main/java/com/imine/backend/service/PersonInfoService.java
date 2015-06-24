package com.imine.backend.service;

import com.imine.backend.model.PersonInfo;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by dev on 2015/6/24.
 */
@Path("/person-info")
public class PersonInfoService {
    private static final boolean debug = true;
    private static final int ONE_DAY = 24 * 60 * 60 * 1000;

    private static List<PersonInfo> personInfos = new ArrayList<PersonInfo>();

    static {
        if (debug) {
            PersonInfo p = new PersonInfo();
            p.setSitUp(6);
            p.setTimestamp(new Date());
            personInfos.add(p);
            p = new PersonInfo();
            p.setSitUp(8);
            p.setTimestamp(new Date());
            personInfos.add(p);
        }
    }

    @GET
    @Path("list")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public List<PersonInfo> getPersonInfoList() {
        if (debug) {
            return personInfos;
        }
        return personInfos;
    }

    @POST
    @Path("create")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String createPersonInfo(PersonInfo personInfo) {
        personInfo.setTimestamp(new Date());
        return "SUCCESS";
    }
}
