/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package block;
import java.util.LinkedList;
import java.util.ArrayList;

/**
 *
 * @author elijahaugustin
 */
public class Blockchain {

    LinkedList<Block> blockchain;
    //private int size;

    public Blockchain() {

        blockchain = new LinkedList<>();
        ArrayList<String> genesisTransaction = new ArrayList<>(5);
        genesisTransaction.add("Genesis Block");
        Block genesisBlock = new Block(genesisTransaction, 0);


        blockchain.add(genesisBlock);


    }


    public void add(Block block) {
        blockchain.add(block);
    }

    public int getSize() {
        return blockchain.size();
    }

    public Block getLatestBlock() {
        return blockchain.getLast();
    }


    public void iterateHash() {
        for (Block b : blockchain)
         System.out.print(b.getBlockHash() + " -> ");
    }

    public String iterateStringHash() {
        String h = "";
        for (Block b : blockchain)
          h += (b.getBlockHash() + " -> ");

        return h;
    }

    public String combinedHash() {
        String hash = "";
        for (Block b : blockchain)
         hash += String.valueOf(b.getBlockHash());

        return hash;

    }

    public void iterateTransactions() {
        for (Block b : blockchain)
         System.out.print(b.getTransactionString() + " -> ");
    }

    public String iterateStringTransactions() {
        String s = "";
        for (Block b : blockchain)
         s += b.getTransactionString() + " -> ";

        return s;
    }


}
