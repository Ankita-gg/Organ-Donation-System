package com.blockchain.organdonation;
import java.util.List;

public class BlockchainValidator {

    public static boolean isValid(List<block> chain) {
        for (int i = 1; i < chain.size(); i++) {
            block current = chain.get(i);
            block previous = chain.get(i - 1);

            // Recalculate hash of current block
            String recalculatedHash = current.recalculateHash();

            // Check if current hash matches recalculated hash
            if (!current.getPresentHash().equals(recalculatedHash)) {
                System.out.println("❌ Invalid hash at block " + i);
                return false;
            }

            // Check if previous hash field is correct
            if (!current.getPreviousHash().equals(previous.getPresentHash())) {
                System.out.println("❌ Previous hash mismatch at block " + i);
                return false;
            }
        }
        return true;
    }
}

