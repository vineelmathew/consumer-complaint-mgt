package com.dxctraining;

import com.dxctraining.complaints.controllers.ComplaintJerseyController;
import com.dxctraining.complaints.entities.Complaints;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class JerseyConfiguration extends ResourceConfig {
    public JerseyConfiguration() {
        register(ComplaintJerseyController.class);
    }


}
