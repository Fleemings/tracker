package org.moto.dto.api;
import lombok.Data;

@Data
public class Specification {

    private ArticleCompleteInfo articleCompleteInfo;
    private EngineAndTransmission engineAndTransmission;
    private ChassisSuspensionBrakesAndWheels chassisSuspensionBrakesAndWheels;
    private PhysicalMeasuresAndCapacities physicalMeasuresAndCapacities;
    private OtherSpecifications otherSpecifications;

    @Data
    public static class ArticleCompleteInfo {
        private int articleID;
        private String makeName;
        private String modelName;
        private String categoryName;
        private int yearName;
    }

    @Data
    public static class EngineAndTransmission {
        private String displacementName;
        private String engineTypeName;
        private String engineDetailsName;
        private String powerName;
        private String torqueName;
        private String compressionName;
        private String boreXStrokeName;
        private String valvesPerCylinderName;
        private String fuelSystemName;
        private String ignitionName;
        private String coolingSystemName;
        private String gearboxName;
        private String transmissionTypeFinalDriveName;
        private String clutchName;
        private String drivelineName;
        private String fuelConsumptionName;
        private String greenhouseGasesName;
        private String emissionDetailsName;
    }

    @Data
    public static class ChassisSuspensionBrakesAndWheels {
        private String frameTypeName;
        private String frontBrakesName;
        private String frontSuspensionName;
        private String frontTyreName;
        private String frontWheelTravelName;
        private String rakeName;
        private String rearBrakesName;
        private String rearSuspensionName;
        private String rearTyreName;
        private String rearWheelTravelName;
        private String trailName;
        private String wheelsName;
    }

    @Data
    public static class PhysicalMeasuresAndCapacities {
        private String fuelCapacityName;
        private String groundClearanceName;
        private String oilCapacityName;
        private String overallHeightName;
        private String overallLengthName;
        private String overallWidthName;
        private String seatHeightName;
        private String weightInclOilGasEtcName;
    }

    @Data
    public static class OtherSpecifications {
        private String colorOptionsName;
        private String electricalName;
        private String commentsName;
        private String instrumentsName;
        private String lightName;
        private String starterName;
    }
}
