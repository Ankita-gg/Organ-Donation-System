package com.blockchain.organdonation;

import static spark.Spark.*;
import com.google.gson.Gson;
import java.util.*;

public class Server {
    // In-memory blockchain list
    static List<block> blockchain = new ArrayList<>();
    static Gson gson = new Gson();

    public static void main(String[] args) {
        port(4568); // Server runs at http://localhost:4568

        // Create genesis block
        Data genesisData = new Data("0", "GENESIS", "None", "None", "none");
        block genesisBlock = new block("0", genesisData);
        blockchain.add(genesisBlock);

        // ✅ Route: Home page to avoid 404
        get("/", (req, res) -> {
            res.type("text/html");
            return "<h2>👋 Welcome to the Organ Donor Blockchain Server</h2>" +
                   "<ul>" +
                   "<li>POST /donor - Add a donor block</li>" +
                   "<li>POST /acceptor - Add an acceptor block</li>" +
                   "<li>GET /chain - View the blockchain</li>" +
                   "<li>GET /validate - Validate the blockchain</li>" +
                   "</ul>";
        });

        // ✅ Route: Prevent /favicon.ico 404 noise
        get("/favicon.ico", (req, res) -> "");

        // Route: Add Donor Block
        post("/donor", (req, res) -> {
            Data donor = gson.fromJson(req.body(), Data.class);
            block newBlock = new block(
                blockchain.get(blockchain.size() - 1).getPresentHash(),
                donor
            );
            blockchain.add(newBlock);
            res.status(201);
            return "✅ Donor block added. Hash: " + newBlock.getPresentHash();
        });

        // Route: Add Acceptor Block
        post("/acceptor", (req, res) -> {
            Acceptor acceptor = gson.fromJson(req.body(), Acceptor.class);
            block newBlock = new block(
                blockchain.get(blockchain.size() - 1).getPresentHash(),
                acceptor
            );
            blockchain.add(newBlock);
            res.status(201);
            return "✅ Acceptor block added. Hash: " + newBlock.getPresentHash();
        });

        // Route: View entire blockchain
        get("/chain", (req, res) -> {
            res.type("application/json");
            return gson.toJson(blockchain);
        });

        // Route: Validate blockchain
        get("/validate", (req, res) -> {
            boolean isValid = BlockchainValidator.isValid(blockchain);
            return isValid ? "✅ Blockchain is valid!" : "❌ Blockchain is invalid!";
        });
        //to accept from anywhere
        // Enable CORS
options("/*", (req, res) -> {
    String accessControlRequestHeaders = req.headers("Access-Control-Request-Headers");
    if (accessControlRequestHeaders != null) {
        res.header("Access-Control-Allow-Headers", accessControlRequestHeaders);
    }

    String accessControlRequestMethod = req.headers("Access-Control-Request-Method");
    if (accessControlRequestMethod != null) {
        res.header("Access-Control-Allow-Methods", accessControlRequestMethod);
    }

    return "OK";
});

before((req, res) -> {
    res.header("Access-Control-Allow-Origin", "*");
    res.header("Access-Control-Request-Method", "*");
    res.header("Access-Control-Allow-Headers", "*");
    res.type("application/json");
});

    }
}
