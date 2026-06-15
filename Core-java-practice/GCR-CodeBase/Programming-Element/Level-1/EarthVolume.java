class EarthVolume {
    public static void main(String[] args) {
        double radius = 6378;
        double pi = 3.14159;

        double volumeKm = (4.0 / 3.0) * pi * radius * radius * radius;
        double volumeMiles = volumeKm * 0.239913;

        System.out.println("The volume of earth in cubic kilometers is " + volumeKm);
        System.out.println("The volume of earth in cubic miles is " + volumeMiles);
    }
}