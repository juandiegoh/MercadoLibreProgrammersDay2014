package com.jherenu.meli_min_path

import spock.lang.Specification

class LadiesCasanovaSpec extends Specification {

    LadiesCasanova ladiesCasanova

    void setup() {
        this.ladiesCasanova = new LadiesCasanova()
    }

    void "example test _ deliver candy to the ladies"() {
        when:
        def result = ladiesCasanova.caminoAChicas(8,8,2,1,7,2,2,7,6,6,7,7,3,3,5,4)

        then:
        result == "[(2,1),(2,2),(3,2),(4,2),(5,2),(6,2),(7,2),(6,2),(5,2),(4,2),(3,2),(2,2),(2,3),(2,4),(2,5),(2,6),(2,7),(2,6),(2,5),(2,4),(3,4)],21"
    }
}
