package com.comcast.iaka.servicecreation.playground.contrrollers.configs;

import java.util.Arrays;
import java.util.List;
import org.springframework.data.cassandra.config.AbstractReactiveCassandraConfiguration;
import org.springframework.data.cassandra.config.SchemaAction;
import org.springframework.data.cassandra.core.cql.keyspace.CreateKeyspaceSpecification;

//@Configuration
public class CassandraConfiguration extends AbstractReactiveCassandraConfiguration {

    public static final String CARS_KEYSPACE = "dev";

    @Override
    protected List<CreateKeyspaceSpecification> getKeyspaceCreations() {
        CreateKeyspaceSpecification keyspace = CreateKeyspaceSpecification.createKeyspace(CARS_KEYSPACE);
        return Arrays.asList(keyspace);
    }

    @Override
    protected String getKeyspaceName() {
        return CARS_KEYSPACE;
    }

    @Override
    public SchemaAction getSchemaAction() {
        return SchemaAction.CREATE_IF_NOT_EXISTS;
    }

    @Override
    public String[] getEntityBasePackages() {
        return new String[]{"com.comcast.iaka.servicecreation"};
//        return super.getEntityBasePackages();
    }
}
