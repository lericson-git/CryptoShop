package com.example.cryptoshop_backend.controllers;

import com.example.cryptoshop_backend.models.BitcoinTx;
import com.example.cryptoshop_backend.repositories.BitcoinTxRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Collections;

public class BitcoinTxController {
    @Controller
    public static class MainController {
        @Autowired
        private BitcoinTxRepository bitcoinTxRepository;

        @PostMapping(path="/addBitcoinTx")
        public @ResponseBody String addNewBitcoinTx (@RequestParam String txHash, @RequestParam Integer userId)
        {
            BitcoinTx b = new BitcoinTx();
            b.setTxHash(txHash);
            b.setUserId(userId);
            bitcoinTxRepository.save(b);
            return ("Saved\n");
        }

        @GetMapping(path="/allBitcoinTxs")
        public @ResponseBody Iterable<BitcoinTx> getAllBitcoinTxs ()
        {
            return bitcoinTxRepository.findAll();
        }

        @PostMapping(path="/txByUserId")
        public @ResponseBody Iterable<BitcoinTx> getTxById (@RequestParam Integer userId) {
            return (bitcoinTxRepository.findByUserId(userId));
        }
    }
}
