package com.gym.model;

import java.time.LocalDate;

public class Membership {

    private int membershipId;
    private String membershipType;
    private String membershipDescription;
    private double membershipCost;
    private int memberId;
    private LocalDate purchaseDate;

    public Membership(int membershipId, String membershipType, String membershipDescription, double membershipCost, int memberId, LocalDate purchaseDate) {
        this.membershipId = membershipId;
        this.membershipType = membershipType;
        this.membershipDescription = membershipDescription;
        this.membershipCost = membershipCost;
        this.memberId = memberId;
        this.purchaseDate = purchaseDate;
    }

    // Getters
    public int getMembershipId() { return membershipId; }
    public String getMembershipType() { return membershipType; }
    public String getMembershipDescription() { return membershipDescription; }
    public double getMembershipCost() { return membershipCost; }
    public int getMemberId() { return memberId; }
    public LocalDate getPurchaseDate() { return purchaseDate; }

    @Override
    public String toString() {
        return "Membership{" +
                "membershipId=" + membershipId +
                ", type='" + membershipType + '\'' +
                ", description='" + membershipDescription + '\'' +
                ", cost=$" + membershipCost +
                ", memberId=" + memberId +
                ", purchaseDate=" + purchaseDate +
                '}';
    }
}