package com.example.task.service.impl;

import com.aerospike.client.AerospikeClient;
import com.aerospike.client.Bin;
import com.aerospike.client.Key;
import com.aerospike.client.Record;
import com.aerospike.client.policy.ScanPolicy;
import com.aerospike.client.policy.WritePolicy;
import com.example.task.Config;
import com.example.task.model.Person;
import com.example.task.service.PersonService;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class PersonServiceImpl implements PersonService {

    @Override
    public Person addPerson(Person person) {

        AerospikeClient client = new AerospikeClient(Config.getSetting("aerospike.host"),
                                                    Integer.parseInt(Config.getSetting("aerospike.port")));
        WritePolicy policy = new WritePolicy();
        Key key = new Key(Config.getSetting("aerospike.namespace"),
                          Config.getSetting("aerospike.sets.persons"), person.getId());
        Bin bin = new Bin("Person", person);
        client.put(policy, key, bin);

        return person;
    }

    @Override
    public Person getPerson(Integer id) {
        AerospikeClient client = new AerospikeClient(Config.getSetting("aerospike.host"),
                Integer.parseInt(Config.getSetting("aerospike.port")));
        ScanPolicy scanPolicy = new ScanPolicy();
        Key key = new Key(Config.getSetting("aerospike.namespace"),
                          Config.getSetting("aerospike.sets.persons"), id);
        Record record = client.get(scanPolicy, key);
        client.close();

        if(record != null){
            return (Person) record.getValue("Person");
        }
        return new Person();
    }

    @Override
    public Integer deletePerson(Integer id) {
        AerospikeClient client = new AerospikeClient(Config.getSetting("aerospike.host"),
                Integer.parseInt(Config.getSetting("aerospike.port")));
        WritePolicy writePolicy = new WritePolicy();
        Key key = new Key(Config.getSetting("aerospike.namespace"),
                          Config.getSetting("aerospike.sets.persons"), id);
        if (client.delete(writePolicy,key)){
            return id;
        }
        return -1;
    }
}
