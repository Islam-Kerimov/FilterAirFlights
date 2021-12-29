package com.gridnine.testing;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Flight> flightWithoutFilters = FlightBuilder.createFlights();
        FlightFilter flightFilter = new FlightFilter();
        flightFilter.setFlightList(flightWithoutFilters);
        printFlight(flightWithoutFilters);

        flightFilter.setFilter(new FlightDepartsUpToCurrentTime());
        List<Flight> flightCurrentTime = flightFilter.executeFilter();
        printFlight(flightCurrentTime);

        flightFilter.setFilter(new FlightDepartsBeforeArrives());
        List<Flight> flightBeforeArrives = flightFilter.executeFilter();
        printFlight(flightBeforeArrives);

        flightFilter.setFilter(new FlightWithMoreTwoHoursGroundTime());
        List<Flight> flightMoreTwoHoursGround = flightFilter.executeFilter();
        printFlight(flightMoreTwoHoursGround);
    }

    static void printFlight(List<Flight> flightList) {
        for(Flight flight: flightList)
            System.out.println("- " + flight + ";");
    }
}
