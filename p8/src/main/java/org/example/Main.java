package org.example;

import org.example.classic.Singleton;
import org.example.threads.InitializedSingleton;
import org.example.threads.SynchronizedBlockSingleton;
import org.example.threads.SynchronizedSingleton;

public class Main {
    public static void main(String[] args) {

        System.out.println(StaticInitializerSingleton.getUniqueInstance().toString() + " " + (StaticInitializerSingleton.getUniqueInstance() == StaticInitializerSingleton.getUniqueInstance()));

        System.out.println(Singleton.getInstance().toString() + " " + (Singleton.getInstance() == Singleton.getInstance()));
        System.out.println(InitializedSingleton.getInstance().toString()+ " " + (InitializedSingleton.getInstance() == InitializedSingleton.getInstance()));
        System.out.println(SynchronizedBlockSingleton.getInstance().toString()+ " " + (SynchronizedBlockSingleton.getInstance() == SynchronizedBlockSingleton.getInstance()));
        System.out.println(SynchronizedSingleton.getInstance().toString()+ " " + (SynchronizedSingleton.getInstance() == SynchronizedSingleton.getInstance()));
    }
}