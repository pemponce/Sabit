package org.example.classic;

import org.example.StaticInitializerSingleton;
import org.example.threads.EnumSingleton;
import org.example.threads.InitializedSingleton;
import org.example.threads.SynchronizedBlockSingleton;
import org.example.threads.SynchronizedSingleton;

public class MainNoClone {
    public static void main(String[] args) throws CloneNotSupportedException {

        System.out.println(StaticInitializerSingleton.getUniqueInstance().toString() + " " + (StaticInitializerSingleton.getUniqueInstance() == StaticInitializerSingleton.getUniqueInstance()));
        
        System.out.println(Singleton.getInstance().toString() + " " + (Singleton.getInstance() == Singleton.getInstance()));

        Singleton singleton = Singleton.getInstance();
        System.out.println("no clone");
        System.out.println(Singleton.getInstance().toString() + " " + (Singleton.getInstance() == singleton.clone()));

        System.out.println(InitializedSingleton.getInstance().toString()+ " " + (InitializedSingleton.getInstance() == InitializedSingleton.getInstance()));
        System.out.println(SynchronizedBlockSingleton.getInstance().toString()+ " " + (SynchronizedBlockSingleton.getInstance() == SynchronizedBlockSingleton.getInstance()));
        System.out.println(SynchronizedSingleton.getInstance().toString()+ " " + (SynchronizedSingleton.getInstance() == SynchronizedSingleton.getInstance()));

        EnumSingleton instance = EnumSingleton.INSTANCE;
        instance.someMethod();

    }
}