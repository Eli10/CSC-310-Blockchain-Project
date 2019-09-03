/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package block;
import java.util.LinkedList;
/**
 *
 * @author elijahaugustin
 */

import java.util.ArrayList;

public class User<T> {

    private String name;
    private Blockchain copyBlockchain;
    //private String transaction;
    private static ArrayList<User> userList = new ArrayList<>();


    // Static Constructor Method
    public static User createUser(String name) {
        User u = new User(name);
        userList.add(u);
        return u;
    }

    //Private Constructor
    private User(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }


    //Update user's blockchain
    public void setCopyOfBlockchain(Blockchain blockchain) {

        this.copyBlockchain = blockchain;
    }

    //Retrive user's copy of the blockchain
    public Blockchain getCopyOfBlockchain() {

        return this.copyBlockchain;
    }


    public static ArrayList<User> getUserList() {
        return userList;
    }

    //Allows user to add a transaction to a specific block
    public void addToBlock(T transaction, Block blockName) {

        if (this.checkUsers()) {
            blockName.addToTransactions(transaction);
        }

    }

    public boolean checkUsers() {

        ArrayList<User> list = userList;
        ArrayList<String> userHashList = new ArrayList<>();

        String check = list.get(0).getCopyOfBlockchain().combinedHash();

        for (User u: list) {
            userHashList.add(u.getCopyOfBlockchain().combinedHash());
        }

        for (String hash: userHashList) {
            if (!hash.equals(check))
                return false;
        }

        return true;
    }



}
