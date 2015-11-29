package com.luxuriem.example;

import com.mongodb.Mongo;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories
class MongoConfig extends AbstractMongoConfiguration {

    @Override
    protected String getDatabaseName() {
        return "go-test";
    }

    @Override
    public Mongo mongo() throws Exception {
        //TODO - set localhost and configure link on docker
        return new Mongo("192.168.99.100", 27017);
    }

    @Override
    protected String getMappingBasePackage() {
        return "com.luxuriem.example.model";
    }
}
