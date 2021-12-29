package com.gridnine.testing;

import java.util.List;

class FlightFilter {
    private Filter filter;
    private List<Flight> flightList;

    public void setFilter(Filter filter) {
        this.filter = filter;
    }

    public void setFlightList(List<Flight> flightList) {
        this.flightList = flightList;
    }

    public List<Flight> executeFilter() {
        return filter.flightHandling(flightList);
    }

}