package bloomberg;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P1396 {

    class UndergroundSystem {

        Map<Integer, List<String>> checkIn = new HashMap<>();
        Map<String, List<Integer>> checkOut = new HashMap<>();

        public UndergroundSystem() {

        }

        public void checkIn(int id, String stationName, int t) {
            Map<Integer, List<Integer>> dataStation;
            List<String> data = new ArrayList<>();
            data.add(stationName);
            data.add("" + t);
            checkIn.put(id, data);
        }

        public void checkOut(int id, String stationName, int t) {
            List<String> dataUser = checkIn.getOrDefault(id, null);
            if (dataUser != null) {
                String route = dataUser.get(0) + "-" + stationName;
                List<Integer> ans = checkOut.getOrDefault(route, new ArrayList<>());

                ans.add(t - Integer.parseInt(dataUser.get(1)));
                checkOut.put(route, ans);
            }
        }

        public double getAverageTime(String startStation, String endStation) {
            String route = startStation + "-" + endStation;
            List<Integer> ans = checkOut.getOrDefault(route, new ArrayList<>());

            return ans.stream().mapToInt(a -> a).average().orElse(0);
        }

    }


/*

    class UndergroundSystem {
        private Map<String, Pair<Double, Double>> journeyData = new HashMap<>();
        private Map<Integer, Pair<String, Integer>> checkInData = new HashMap<>();

        public UndergroundSystem() {
        }

        public void checkIn(int id, String stationName, int t) {
            checkInData.put(id, new Pair<>(stationName, t));
        }

        public void checkOut(int id, String stationName, int t) {
            Pair<String, Integer> checkInDataForId = checkInData.get(id);
            String startStation = checkInDataForId.getKey();
            Integer checkInTime = checkInDataForId.getValue();

            String routeKey = stationsKey(startStation, stationName);
            Pair<Double, Double> routeStats  = journeyData.getOrDefault(routeKey, new Pair<>(0.0, 0.0));
            Double totalTripTime = routeStats.getKey();
            Double totalTrips = routeStats.getValue();

            double tripTime = t - checkInTime;
            journeyData.put(routeKey, new Pair<>(totalTripTime + tripTime, totalTrips + 1));

            checkInData.remove(id);
        }

        public double getAverageTime(String startStation, String endStation) {
            String routeKey = stationsKey(startStation, endStation);
            Double totalTime = journeyData.get(routeKey).getKey();
            Double totalTrips = journeyData.get(routeKey).getValue();

            return totalTime / totalTrips;
        }

        private String stationsKey(String startStation, String endStation) {
            return startStation + "->" + endStation;
        }
    }



    
    class Trip {
        int time;
        String station;

        public Trip(int time, String station) {
            this.time=time;
            this.station=station;
        }
    }

    class UndergroundSystem {
        Map<String, Map<String, double[]>> out=new HashMap<>();
        Map<Integer, Trip> in=new HashMap<>();

        public UndergroundSystem() {

        }

        public void checkIn(int id, String stationName, int t) {
            in.put(id, new Trip(t, stationName));
        }

        public void checkOut(int id, String stationName, int t) {
            Trip trip=in.remove(id);
            if(trip!=null) {
                Map<String, double[]> fromMap=out.computeIfAbsent(trip.station, s->new HashMap<>());
                double[] times=fromMap.computeIfAbsent(stationName, s->new double[]{0.0, 0.0});
                times[0]+=t-trip.time;
                times[1]++;
            }
        }

        public double getAverageTime(String startStation, String endStation) {
            Map<String, double[]> outc=out.get(startStation);
            double[] times=outc.get(endStation);
            return times[0]/times[1];
        }
    }







*/
}
