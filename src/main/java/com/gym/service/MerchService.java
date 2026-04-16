package com.gym.service;

import com.gym.dao.MerchDAO;
import com.gym.model.GymMerch;

import java.util.List;

public class MerchService {

    private final MerchDAO merchDAO;

    public MerchService() {
        this.merchDAO = new MerchDAO();
    }

    public boolean addMerch(GymMerch merch) {
        return merchDAO.addMerch(merch);
    }

    public boolean updatePrice(int id, double newPrice) {
        return merchDAO.updatePrice(id, newPrice);
    }

    public boolean updateStock(int id, int newStock) {
        return merchDAO.updateStock(id, newStock);
    }

    public List<GymMerch> getAllMerch() {
        return merchDAO.getAllMerch();
    }

    public double getTotalStockValue() {
        return merchDAO.getTotalStockValue();
    }
}