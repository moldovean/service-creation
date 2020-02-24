package com.comcast.iaka.servicecreation.entities;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table
public class ServiceDescriptor {

    @PrimaryKey
    private Long id;
    private String vmdName;
    private String fqdn;
    private String vpn;
    private String siteName;
    private String vcsName;
    private List<String> vcsNames;



}
