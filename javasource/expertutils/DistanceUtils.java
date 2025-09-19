package expertutils;

public class DistanceUtils {
    public static double haversineDistance(String positionALongitude, String positionALatitude, String positionBLongitude, String positionBLatitude) {
        double R = 6371e3; // Radius of Earth in meters
        double lat1 = Math.toRadians(Double.parseDouble(positionALongitude));
        double lat2 = Math.toRadians(Double.parseDouble(positionALatitude));
        double dLat = Math.toRadians(Double.parseDouble(positionBLatitude) - Double.parseDouble(positionALatitude));
        double dLon = Math.toRadians(Double.parseDouble(positionBLongitude) - Double.parseDouble(positionALatitude));

        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2) +
                   Math.cos(lat1) * Math.cos(lat2) *
                   Math.sin(dLon / 2) * Math.sin(dLon / 2);

        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double distance = R * c;

        return distance; // Distance in meters
    }
}
