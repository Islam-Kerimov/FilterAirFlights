package com.gridnine.testing;

import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

class FlightWithMoreTwoHoursGroundTime implements Filter {
    @Override
    public List<Flight> flightHandling(List<Flight> flightList) {
        System.out.println("=========================================" +
                "=============================================");
        System.out.println("Flights with less than two hours total time on the ground:\n");

        List<Flight> newFlightList = new ArrayList<>();
        for(Flight flight : flightList) {
            List<Segment> segments = flight.getSegments();
            if(segments.size() > 1) {
                long l = 0;
                for (int i = 1; i != segments.size(); i++) {
                    l += segments.get(i-1).getArrivalDate()
                            .until(segments.get(i).getDepartureDate(), ChronoUnit.SECONDS);
                }
                if (l <= 7200) {
                    newFlightList.add(flight);
                }
            } else {
                newFlightList.add(flight);
            }
        }
        return newFlightList;
    }
}