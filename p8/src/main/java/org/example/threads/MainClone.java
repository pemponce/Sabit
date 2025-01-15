package org.example.threads;

import org.example.StaticInitializerSingleton;
import org.example.classic.Singleton;

public class MainClone {
    public static void main(String[] args) {

        System.out.println(StaticInitializerSingleton.getUniqueInstance().toString() + " " + (StaticInitializerSingleton.getUniqueInstance() == StaticInitializerSingleton.getUniqueInstance()));
        
        System.out.println(Singleton.getInstance().toString() + " " + (Singleton.getInstance() == Singleton.getInstance()));

        System.out.println("clone");
        System.out.println(SynchronizedSingleton.getInstance().toString()+ " " + (SynchronizedSingleton.getInstance() == SynchronizedSingleton.getInstance()));


        System.out.println(InitializedSingleton.getInstance().toString()+ " " + (InitializedSingleton.getInstance() == InitializedSingleton.getInstance()));
        System.out.println(SynchronizedBlockSingleton.getInstance().toString()+ " " + (SynchronizedBlockSingleton.getInstance() == SynchronizedBlockSingleton.getInstance()));
        System.out.println(SynchronizedSingleton.getInstance().toString()+ " " + (SynchronizedSingleton.getInstance() == SynchronizedSingleton.getInstance()));

        EnumSingleton instance = EnumSingleton.INSTANCE;
        instance.someMethod();

    }
}