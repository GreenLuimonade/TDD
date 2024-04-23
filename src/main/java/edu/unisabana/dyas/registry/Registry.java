package edu.unisabana.dyas.registry;

import java.util.ArrayList;
import java.util.List;

public class Registry {
        
    List<Person> votó= new ArrayList<Person>();
    public RegisterResult registerVoter(Person p) {
        if (votó.contains(p)){
            return RegisterResult.DUPLICATED;
        }
        else if(p.isAlive()==false)
        {
            return RegisterResult.DEAD;
        }
        else if(p.getAge()<18 && p.getAge()>0){
            return RegisterResult.UNDERAGE;
        }
        else if(p.getAge()<0||p.getAge()>90){
            return RegisterResult.INVALID_AGE;
        }
        else{
            return RegisterResult.VALID;
        }
    }
}
