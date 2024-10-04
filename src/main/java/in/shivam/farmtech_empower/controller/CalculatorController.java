package in.shivam.farmtech_empower.controller;

import in.shivam.farmtech_empower.entity.Crop;
import in.shivam.farmtech_empower.service.CalculatorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {

    private final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @PostMapping("/calculate")
    public String calculateProfit(
            @RequestParam("name") String cropName,
            @RequestParam("fieldArea") double fieldArea,
            Model model) {

        // Get crop-specific costs
        Crop crop = calculatorService.getCrop(cropName);

        if (crop == null) {
            // Handle case where the crop is not found
            model.addAttribute("error", "Crop not found");
            return "error"; // Redirect to an error page
        }

        // Calculate total costs based on the selected field area
     // Calculate total costs based on the selected field area
        double totalLandPreparationCost = crop.getLandPreparationCost() * fieldArea;
        double totalSeedCost = crop.getSeedCost() * fieldArea;
        double totalFertilizerCost = crop.getFertilizerCost() * fieldArea;
        double totalSowingCost = crop.getSowingCost() * fieldArea;
        double totalIrrigationCost = crop.getIrrigationCost() * fieldArea;
        double totalPesticideCost = crop.getPesticideCost() * fieldArea;
        double totalHarvestingCost = crop.getHarvestingCost() * fieldArea;
        double totalPostHarvestCost = crop.getPostHarvestCost() * fieldArea;
        double totalotherExpenses = crop.getOtherExpenses() * fieldArea; // Updated line


        double totalCost = calculatorService.calculateTotalCost(
                totalLandPreparationCost, totalSeedCost, totalFertilizerCost, totalSowingCost,
                totalIrrigationCost, totalPesticideCost, totalHarvestingCost, totalPostHarvestCost);

        // Get sale price per kilogram based on crop type
        double salePricePerKg = calculatorService.getSalePricePerKg(cropName);

        // Calculate total production and sale value
        double totalProductionKg = calculatorService.calculateTotalProductionKg(fieldArea, cropName);
        double totalSaleValue = calculatorService.calculateTotalSaleValue(totalProductionKg, salePricePerKg);

        // Calculate profit
        double profit = calculatorService.calculateProfit(totalSaleValue, totalCost);

        // Add attributes to the model for Thymeleaf to use
        model.addAttribute("cropName", cropName);
        model.addAttribute("fieldArea", fieldArea);
        model.addAttribute("totalLandPreparationCost", totalLandPreparationCost);
        model.addAttribute("totalSeedCost", totalSeedCost);
        model.addAttribute("totalFertilizerCost", totalFertilizerCost);
        model.addAttribute("totalSowingCost", totalSowingCost);
        model.addAttribute("totalIrrigationCost", totalIrrigationCost);
        model.addAttribute("totalPesticideCost", totalPesticideCost);
        model.addAttribute("totalHarvestingCost", totalHarvestingCost);
        model.addAttribute("totalPostHarvestCost", totalPostHarvestCost);
        model.addAttribute("otherExpenses", totalotherExpenses);
        model.addAttribute("totalCost", totalCost);
        model.addAttribute("salePricePerKg", salePricePerKg);
        model.addAttribute("totalProductionKg", totalProductionKg);
        model.addAttribute("totalSaleValue", totalSaleValue);
        model.addAttribute("profit", profit);

        return "result"; // Redirect to the result page
    }
}
