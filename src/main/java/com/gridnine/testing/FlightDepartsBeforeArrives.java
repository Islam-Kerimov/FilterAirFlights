package com.gridnine.testing;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

class FlightDepartsBeforeArrives implements Filter {
    @Override
    public List<Flight> flightHandling(List<Flight> flightList) {
        System.out.println("=========================================" +
                "=============================================");
        System.out.println("Flights with a departure date earlier than the arrival date:\n");

        List<Flight> newFlightList = new ArrayList<>();

        for (Flight flight : flightList) {
            int k = 0;
            List<Segment> segments = flight.getSegments();
            for (Segment segment : segments) {
                LocalDateTime timeDepart = segment.getDepartureDate();
                if (timeDepart.isBefore(segment.getArrivalDate()))
                    k++;
            }
            if (k == segments.size())
                newFlightList.add(flight);
        }
        return newFlightList;
    }
}
