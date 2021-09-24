package com.example.cryptoshop_backend.repositories;

import com.example.cryptoshop_backend.models.BitcoinTx;
import org.springframework.data.repository.CrudRepository;

public interface BitcoinTxRepository extends CrudRepository<BitcoinTx, Integer> {
}
