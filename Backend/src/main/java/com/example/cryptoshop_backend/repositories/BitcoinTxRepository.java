package com.example.cryptoshop_backend.repositories;

import com.example.cryptoshop_backend.models.BitcoinTx;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BitcoinTxRepository extends CrudRepository<BitcoinTx, Integer> {
    List<BitcoinTx> findByUserId (Integer userId);

}
