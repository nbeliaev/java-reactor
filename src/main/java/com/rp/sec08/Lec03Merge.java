package com.rp.sec08;

import com.rp.sec08.helper.AmericanAirlines;
import com.rp.sec08.helper.EmiratesFlights;
import com.rp.sec08.helper.QatarFlights;
import com.rp.util.Utils;
import reactor.core.publisher.Flux;

public class Lec03Merge {

    public static void main(String[] args) {
        Flux<String> merge = Flux.merge(QatarFlights.getFlights(), EmiratesFlights.getFlights(), AmericanAirlines.getFlights());

        merge.subscribe(Utils.subscriber());

        Utils.sleepSeconds(10);
    }
}
