package PremiumCalculator;
public class PremiumCalculator
{
    public double calculateLifeInsurancePremium(int age, boolean hasHealthConditions) throws DataNotFoundException {
        if (age <= 0) {
            throw new DataNotFoundException("Age data is missing or invalid.");
        }
        try {
            double basePremium = 5000;
            if (age > 50) {
                basePremium += 2000;
            }
            if (hasHealthConditions) {
                basePremium += 3000;
            }
            return basePremium;
        } catch (Exception e) {
            throw new CalculationException("Error calculating life insurance premium.");
        }
    }

    public double calculateHealthInsurancePremium(int age, boolean hasPreExistingConditions) throws DataNotFoundException {
        if (age <= 0) {
            throw new DataNotFoundException("Age data is missing or invalid.");
        }
        try {
            double basePremium = 3000;
            if (age > 60) {
                basePremium += 2500;
            }
            if (hasPreExistingConditions) {
                basePremium += 4000;
            }
            return basePremium;
        } catch (Exception e) {
            throw new CalculationException("Error calculating health insurance premium.");
        }
    }

    public double calculateVehicleInsurancePremium(String vehicleType, int vehicleAge) throws DataNotFoundException {
        if (vehicleType == null || vehicleType.isEmpty() || vehicleAge < 0) {
            throw new DataNotFoundException("Vehicle data is missing or invalid.");
        }
        try {
            double basePremium = 2000;
            if (vehicleType.equalsIgnoreCase("SUV")) {
                basePremium += 1500;
            }
            if (vehicleAge > 5) {
                basePremium += 1000;
            }
            return basePremium;
        } catch (Exception e) {
            throw new CalculationException("Error calculating vehicle insurance premium.");
        }
    }

    public static void main(String[] args) {
        PremiumCalculator calculator = new PremiumCalculator();
        try {
            double lifePremium = calculator.calculateLifeInsurancePremium(55, true);
            System.out.println("Life Insurance Premium: " + lifePremium);
        } catch (DataNotFoundException | CalculationException e) {
            System.out.println("Error: " + e.getMessage());
            logError(e.getMessage());
        }

        try {
            double healthPremium = calculator.calculateHealthInsurancePremium(65, true);
            System.out.println("Health Insurance Premium: " + healthPremium);
        } catch (DataNotFoundException | CalculationException e) {
            System.out.println("Error: " + e.getMessage());
            logError(e.getMessage());
        }

        try {
            double vehiclePremium = calculator.calculateVehicleInsurancePremium("SUV", 6);
            System.out.println("Vehicle Insurance Premium: " + vehiclePremium);
        } catch (DataNotFoundException | CalculationException e) {
            System.out.println("Error: " + e.getMessage());
            logError(e.getMessage());
        }
    }

    private static void logError(String message) {
        System.out.println("Log: " + message);
    }

}