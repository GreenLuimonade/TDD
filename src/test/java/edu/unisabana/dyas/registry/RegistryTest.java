package edu.unisabana.dyas.registry;

import org.junit.Assert;
import org.junit.Test;

public class RegistryTest {
    private Registry registry = new Registry();
    @Test
    public void validateRegistryResult() {
        Person person = new Person();
        person.setAge(20);
        person.setAlive(true);
        person.setGender(Gender.MALE);
        person.setId(1);
        person.setName("Jairo");
        RegisterResult result = registry.registerVoter(person);
        Assert.assertEquals(RegisterResult.VALID, result);

    }

    @Test
    public void validateRegistryResultUnderage() {
        Person person = new Person();
        person.setAge(5);
        person.setAlive(true);
        person.setGender(Gender.MALE);
        person.setId(1);
        person.setName("Jairo");
        RegisterResult result = registry.registerVoter(person);
        Assert.assertEquals(RegisterResult.UNDERAGE, result);

    }

    @Test
    public void validateRegistryResultDead() {
        Person person = new Person();
        person.setAge(50);
        person.setAlive(false);
        person.setGender(Gender.MALE);
        person.setId(1);
        person.setName("Jairo");
        RegisterResult result = registry.registerVoter(person);
        Assert.assertEquals(RegisterResult.DEAD, result);

    }

    @Test
    public void validateRegistryResultInvalidAge() {
        Person person = new Person();
        person.setAge(-5);
        person.setAlive(true);
        person.setGender(Gender.MALE);
        person.setId(1);
        person.setName("Jairo");
        RegisterResult result = registry.registerVoter(person);
        Assert.assertEquals(RegisterResult.INVALID_AGE, result);

    }

    @Test
    public void validateRegistryResultDuplicated() {
        Person person = new Person();
        person.setAge(20);
        person.setAlive(true);
        person.setGender(Gender.MALE);
        person.setId(1);
        person.setName("Jairo");

        registry.registerVoter(person);
        RegisterResult result = registry.registerVoter(person);

        
        Assert.assertEquals(RegisterResult.DUPLICATED, result);

    }

    // TODO Complete with more test cases
}