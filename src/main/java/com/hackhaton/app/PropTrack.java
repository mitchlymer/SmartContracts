package com.hackhaton.app;

import avm.Address;
import avm.Blockchain;
import avm.Result;
import org.aion.avm.tooling.abi.Callable;

import java.math.BigInteger;

public class PropTrack
{

    private static String id;
    private static float temp;
    private static float humidity;
    private static float waterPresure;
    private static float pipeTemp;
    private static float scoreCheck;


    // Create an empty address for the owner.
    private static Address owner;

    static {
        // Set the owner as the address that deployed the contract.
        owner = Blockchain.getCaller();
    }

    // Transfer AION from the contract address to the address listed in the "to" variable.
//    @Callable
//    public static boolean getpayment(Address from, long value) {
//        onlyOwner();
////        //white list the address of the sender
////        Address owneraddress =   Blockchain.getAddress();
////        owneraddress.
////
////        BigInteger value1 = Blockchain.getValue();
////        return result.isSuccess();
//    }




    // Only Owner modifier.
    private static void onlyOwner() {
        Blockchain.require(Blockchain.getCaller().equals(owner));
    }


    @Callable
    public static String getId() {
        return id;
    }

    @Callable
    public static void setId(String id) {
        PropTrack.id = id;
    }

    @Callable
    public static float getTemp() {
        return temp;
    }
    @Callable
    public static void setTemp(float temp) {
        PropTrack.temp = temp;
    }
    @Callable
    public static float getHumidity() {
        return humidity;
    }
    @Callable
    public static void setHumidity(float humidity) {
        PropTrack.humidity = humidity;
    }

    @Callable
    public static float getWaterPresure() {
        return waterPresure;
    }
    @Callable
    public static void setWaterPresure(float waterPresure) {
        PropTrack.waterPresure = waterPresure;
    }
    @Callable
    public static float getPipeTemp() {
        return pipeTemp;
    }
    @Callable
    public static void setPipeTemp(float pipeTemp) {
        PropTrack.pipeTemp = pipeTemp;
    }


    @Callable
    public static float getScore(){
        scoreCheck = makeScore();
        return scoreCheck;
    }


   private static float makeScore() {

        float score = 100;

        if(!(temp >= 268.15) & !(temp <= 297.15)){

            score -= 20;

        } else if (!(humidity >= 30) &  !(humidity <= 50 )){

            score -=30;

        }else if (!(waterPresure >=25) & !(waterPresure <= 75)){

                score-= 10;
        } else if (!(pipeTemp >= 2) & !(pipeTemp <= 30)){

            score -=40;

        }
        return score;

    }











}
