package com.gridnine.testing;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

class FlightDepartsUpToCurrentTime implements Filter {
    @Override
    public List<Flight> flightHandling(List<Flight> flightList) {
        System.out.println("=========================================" +
                "=============================================");
        System.out.println("Flights with departure of the current time:\n");

        LocalDateTime currentTime = LocalDateTime.now();
        List<Flight> newFlightList = new ArrayList<>();

        for (Flight flight : flightList) {
            int k = 0;
            List<Segment> segments = flight.getSegments();
            for (Segment segment : segments) {
                if (segment.getDepartureDate().isAfter(currentTime))
                    k++;
            }
            if (k == segments.size())
                newFlightList.add(flight);
        }
        return newFlightList;
    }
}