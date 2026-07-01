import java.util.Scanner;

class RescueTeam {
    protected String teamId;
    protected String location;
    protected int membersCount;
    protected String status;

    public RescueTeam(String teamId, String location, int membersCount) {
        this.teamId = teamId;
        this.location = location;
        this.membersCount = membersCount;
        this.status = "Deployed";
    }

    public void performDuty() {
        System.out.println("Team " + teamId + " performing rescue operations at " + location);
    }

    public void displayInfo() {
        System.out.println("Team ID: " + teamId);
        System.out.println("Location: " + location);
        System.out.println("Members: " + membersCount);
        System.out.println("Status: " + status);
    }

    public String getTeamId() {
        return teamId;
    }

    public String getLocation() {
        return location;
    }
}

class MedicalTeam extends RescueTeam {
    private int ambulances;
    private int doctors;

    public MedicalTeam(String teamId, String location, int membersCount, int ambulances, int doctors) {
        super(teamId, location, membersCount);
        this.ambulances = ambulances;
        this.doctors = doctors;
    }

    @Override
    public void performDuty() {
        System.out.println("[MEDICAL] Team " + teamId + " providing medical aid at " + location);
        System.out.println("Doctors: " + doctors + " | Ambulances: " + ambulances);
    }

    @Override
    public void displayInfo() {
        System.out.println("=== Medical Team ===");
        super.displayInfo();
        System.out.println("Ambulances: " + ambulances);
        System.out.println("Doctors: " + doctors);
    }
}

class FireRescueTeam extends RescueTeam {
    private int firetrucks;
    private int equipmentTons;

    public FireRescueTeam(String teamId, String location, int membersCount, int firetrucks, int equipmentTons) {
        super(teamId, location, membersCount);
        this.firetrucks = firetrucks;
        this.equipmentTons = equipmentTons;
    }

    @Override
    public void performDuty() {
        System.out.println("[FIRE RESCUE] Team " + teamId + " battling fires at " + location);
        System.out.println("Firetrucks: " + firetrucks + " | Equipment: " + equipmentTons + " tons");
    }

    @Override
    public void displayInfo() {
        System.out.println("=== Fire Rescue Team ===");
        super.displayInfo();
        System.out.println("Firetrucks: " + firetrucks);
        System.out.println("Equipment: " + equipmentTons + " tons");
    }
}

class FoodSupplyTeam extends RescueTeam {
    private int foodPackages;
    private int waterBottles;

    public FoodSupplyTeam(String teamId, String location, int membersCount, int foodPackages, int waterBottles) {
        super(teamId, location, membersCount);
        this.foodPackages = foodPackages;
        this.waterBottles = waterBottles;
    }

    @Override
    public void performDuty() {
        System.out.println("[FOOD SUPPLY] Team " + teamId + " distributing supplies at " + location);
        System.out.println("Food Packages: " + foodPackages + " | Water Bottles: " + waterBottles);
    }

    @Override
    public void displayInfo() {
        System.out.println("=== Food Supply Team ===");
        super.displayInfo();
        System.out.println("Food Packages: " + foodPackages);
        System.out.println("Water Bottles: " + waterBottles);
    }
}

public class DisasterRescueManagementSystem {
    public static RescueTeam findTeamByLocation(RescueTeam[] teams, String location) {
        for (RescueTeam team : teams) {
            if (team.getLocation().equalsIgnoreCase(location)) {
                return team;
            }
        }
        return null;
    }

    public static void displayTeamsByPrefix(RescueTeam[] teams, String prefix) {
        System.out.println("\nTeams with ID prefix '" + prefix + "':");
        boolean found = false;
        for (RescueTeam team : teams) {
            if (team.getTeamId().startsWith(prefix)) {
                System.out.println("  - " + team.getTeamId() + " at " + team.getLocation());
                found = true;
            }
        }
        if (!found) {
            System.out.println("  No teams found with prefix '" + prefix + "'");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Disaster Rescue Management System ===\n");

        RescueTeam[] teams = new RescueTeam[9];
        teams[0] = new MedicalTeam("MED001", "Downtown Hospital", 25, 5, 8);
        teams[1] = new FireRescueTeam("FIRE001", "City Center", 40, 6, 15);
        teams[2] = new FoodSupplyTeam("FOOD001", "Relief Camp A", 30, 500, 1000);
        teams[3] = new MedicalTeam("MED002", "Northern Zone", 20, 3, 6);
        teams[4] = new FireRescueTeam("FIRE002", "Southern District", 35, 5, 12);
        teams[5] = new FoodSupplyTeam("FOOD002", "Relief Camp B", 25, 400, 800);
        teams[6] = new MedicalTeam("MED003", "Eastern Area", 22, 4, 7);
        teams[7] = new FireRescueTeam("FIRE003", "Western Zone", 38, 7, 18);
        teams[8] = new FoodSupplyTeam("FOOD003", "Relief Camp C", 28, 600, 1200);

        System.out.println("--- All Deployed Teams ---\n");
        for (int i = 0; i < teams.length; i++) {
            System.out.println("Team " + (i + 1) + ":");
            teams[i].displayInfo();
            System.out.println();
        }

        System.out.println("--- Performing Duties (Dynamic Method Dispatch) ---\n");
        for (RescueTeam team : teams) {
            team.performDuty();
            System.out.println();
        }

        System.out.println("--- Search Team by Location ---");
        String searchLocation = "City Center";
        RescueTeam foundTeam = findTeamByLocation(teams, searchLocation);
        if (foundTeam != null) {
            System.out.println("Team Found at '" + searchLocation + "':");
            foundTeam.displayInfo();
        } else {
            System.out.println("No team found at '" + searchLocation + "'");
        }

        displayTeamsByPrefix(teams, "MED");
        displayTeamsByPrefix(teams, "FIRE");
        displayTeamsByPrefix(teams, "FOOD");

        System.out.println("\n--- Team Deployment Statistics ---");
        int medicalCount = 0, fireCount = 0, foodCount = 0;
        int totalMedicalMembers = 0, totalFireMembers = 0, totalFoodMembers = 0;

        for (RescueTeam team : teams) {
            if (team instanceof MedicalTeam) {
                medicalCount++;
                totalMedicalMembers += team.membersCount;
            } else if (team instanceof FireRescueTeam) {
                fireCount++;
                totalFireMembers += team.membersCount;
            } else if (team instanceof FoodSupplyTeam) {
                foodCount++;
                totalFoodMembers += team.membersCount;
            }
        }

        System.out.println("Medical Teams: " + medicalCount + " | Total Members: " + totalMedicalMembers);
        System.out.println("Fire Rescue Teams: " + fireCount + " | Total Members: " + totalFireMembers);
        System.out.println("Food Supply Teams: " + foodCount + " | Total Members: " + totalFoodMembers);
        System.out.println("Total Teams Deployed: " + teams.length);

        System.out.println("\n--- Team Category with Maximum Deployments ---");
        if (medicalCount >= fireCount && medicalCount >= foodCount) {
            System.out.println("Medical Teams have maximum deployments: " + medicalCount + " teams");
        } else if (fireCount >= medicalCount && fireCount >= foodCount) {
            System.out.println("Fire Rescue Teams have maximum deployments: " + fireCount + " teams");
        } else {
            System.out.println("Food Supply Teams have maximum deployments: " + foodCount + " teams");
        }

        sc.close();
    }
}
