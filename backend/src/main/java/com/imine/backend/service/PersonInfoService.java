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
    private boolean debug = true;

    @GET
    @Path("list")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public List<PersonInfo> getPersonInfoList() {
        List<PersonInfo> personInfos = new ArrayList<PersonInfo>();
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
        return personInfos;
    }
}
