package com.apicollabdev.odk.collabdev.service;

import com.apicollabdev.odk.collabdev.entity.Coins;

import java.util.List;

public interface CoinsService {
    Coins createCoins(Coins coins);
    List<Coins> getAllCoins();
    Coins getById(Long id);
    void deleteById(Long id);
}
