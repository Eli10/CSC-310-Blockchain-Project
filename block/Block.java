/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package block;

import java.util.Arrays;
import java.util.ArrayList;
/**
 *
 * @author elijahaugustin
 */
public class Block<T> {

    private ArrayList<T> transactions;
    private int previousHash;
    private int blockHash;

    //Constructor
    public Block(ArrayList<T> transactions, int previousHash) {

        this.transactions = transactions;
        this.previousHash = previousHash;

        Object[] contents = {transactions.hashCode(), previousHash};
        this.blockHash = Arrays.hashCode(contents);

    }

    //Get the hash value of previous block
    public int getPreviousHash() {
      return previousHash;
    }

    //Get the hash value of current block
    public int getBlockHash() {
      return blockHash;
    }

    //Update hash value of current block
    public void resetBlockHash() {
        Object[] contents = {transactions.hashCode(), previousHash};
        this.blockHash = Arrays.hashCode(contents);
    }

    //Add user transaction to the transacation list
    public void addToTransactions(T transaction) {

        transactions.add(transaction);
        this.resetBlockHash();

    }

    //Retrive a string value for the transaction list
   public String getTransactionString() {
      String transactionString = "";

      for(int i = 0; i < transactions.size(); i++)
          transactionString += transactions.get(i) + ",";

      return transactionString;
   }



   /*
   public String transactionToString() {

      String transactionString = "";
      for (String s: transactions) {

         transactionString += transactions;
      }

      return transactionString;

   }
*/


}
