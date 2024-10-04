package in.shivam.farmtech_empower.service;

import org.springframework.stereotype.Service;
import in.shivam.farmtech_empower.entity.Crop;

@Service
public class CalculatorService {

    public double calculateTotalCost(double landPreparationCost, double seedCost, double fertilizerCost,
                                     double sowingCost, double irrigationCost, double pesticideCost,
                                     double harvestingCost, double postHarvestCost) {
        return landPreparationCost + seedCost + fertilizerCost + sowingCost + irrigationCost +
               pesticideCost + harvestingCost + postHarvestCost;
    }

    public double getSalePricePerKg(String cropName) {
        Crop crop = getCrop(cropName);
        if (crop != null) {
            return crop.getSalePricePerKg();
        }
        return 30; // Default sale price if crop not found
    }

    public double calculateTotalProductionKg(double fieldArea, String cropName) {
        Crop crop = getCrop(cropName);
        if (crop != null) {
            return fieldArea * crop.getProductivityPerHectare();
        }
        return 0;
    }

    public double calculateTotalSaleValue(double totalProductionKg, double salePricePerKg) {
        return totalProductionKg * salePricePerKg;
    }

    public double calculateProfit(double totalSaleValue, double totalCost) {
        return totalSaleValue - totalCost;
    }

    public Crop getCrop(String name) {
        switch (name) {  
            case "Wheat":
                return new Crop("Wheat", 1000, 600, 2500, 1000, 1000, 2400, 2000, 2000, 1500, 20, 500); // Adding other expenses
            case "Corn":
                return new Crop("Corn", 1200, 700, 2600, 2000, 1500, 2500, 2200, 2200, 1200, 25, 600);
            case "Paddy":
                return new Crop("Paddy", 1500, 800, 2700, 2400, 1000, 2700, 2300, 2400, 1300, 18, 700);
            case "Soybean":
                return new Crop("Soybean", 1300, 650, 2800, 2100, 1300, 2600, 1500, 2300, 2000, 40, 800);
            case "Barley":
                return new Crop("Barley", 1100, 550, 1500, 1800, 700, 2300, 1800, 1900, 1500, 22, 400);
            default:
                return null;
        }
    }


}
