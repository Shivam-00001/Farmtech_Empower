package in.shivam.farmtech_empower.entity;

public class Crop {
    private String name;
    private double landPreparationCost;
    private double seedCost;
    private double fertilizerCost;
    private double sowingCost;
    private double irrigationCost;
    private double pesticideCost;
    private double harvestingCost;
    private double postHarvestCost;
    private double productivityPerHectare; // in tons or kilograms
    private double salePricePerKg;
    private double otherExpenses; // Changed to double

    public Crop(String name, double landPreparationCost, double seedCost, double fertilizerCost, double sowingCost,
                double irrigationCost, double pesticideCost, double harvestingCost, double postHarvestCost,
                double productivityPerHectare, double salePricePerKg, double otherExpensesCost) { // Updated parameter name
        this.name = name;
        this.landPreparationCost = landPreparationCost;
        this.seedCost = seedCost;
        this.fertilizerCost = fertilizerCost;
        this.sowingCost = sowingCost;
        this.irrigationCost = irrigationCost;
        this.pesticideCost = pesticideCost;
        this.harvestingCost = harvestingCost;
        this.postHarvestCost = postHarvestCost;
        this.productivityPerHectare = productivityPerHectare;
        this.salePricePerKg = salePricePerKg;
        this.otherExpenses = otherExpensesCost; // Correctly assigning the parameter
    }

    // Getters and Setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public double getLandPreparationCost() { return landPreparationCost; }
    public void setLandPreparationCost(double landPreparationCost) { this.landPreparationCost = landPreparationCost; }

    public double getSeedCost() { return seedCost; }
    public void setSeedCost(double seedCost) { this.seedCost = seedCost; }

    public double getFertilizerCost() { return fertilizerCost; }
    public void setFertilizerCost(double fertilizerCost) { this.fertilizerCost = fertilizerCost; }

    public double getSowingCost() { return sowingCost; }
    public void setSowingCost(double sowingCost) { this.sowingCost = sowingCost; }

    public double getIrrigationCost() { return irrigationCost; }
    public void setIrrigationCost(double irrigationCost) { this.irrigationCost = irrigationCost; }

    public double getPesticideCost() { return pesticideCost; }
    public void setPesticideCost(double pesticideCost) { this.pesticideCost = pesticideCost; }

    public double getHarvestingCost() { return harvestingCost; }
    public void setHarvestingCost(double harvestingCost) { this.harvestingCost = harvestingCost; }

    public double getPostHarvestCost() { return postHarvestCost; }
    public void setPostHarvestCost(double postHarvestCost) { this.postHarvestCost = postHarvestCost; }

    public double getProductivityPerHectare() { return productivityPerHectare; }
    public void setProductivityPerHectare(double productivityPerHectare) { this.productivityPerHectare = productivityPerHectare; }

    public double getSalePricePerKg() { return salePricePerKg; }
    public void setSalePricePerKg(double salePricePerKg) { this.salePricePerKg = salePricePerKg; }

    public double getOtherExpenses() { return otherExpenses; } // Corrected return type
    public void setOtherExpensesCost(double otherExpensesCost) { this.otherExpenses = otherExpensesCost; } // Updated setter
}
