package com.cognitivemedicine;

import com.cognitivemedicine.conceptmodels.MockConceptModel1.Observation;
import com.cognitivemedicine.conceptmodels.MockConceptModel1.Quantity;
import com.cognitivemedicine.conceptmodels.MockConceptModel1.Related;
import com.cognitivemedicine.util.KBFacilitator;
import drools.traits.util.KBSessionInterface;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;


/**
 * Created by mhekmatnejad on 6/11/15.
 */
public class KBISimpleCM1 {

    KBFacilitator kbFacilitator = null;
    List<String> checkList = new ArrayList<String>();

    @Before
    public void initKB()
    {

        System.out.println("KB initialization testing");
        try {
            kbFacilitator = new KBFacilitator(true,"simpleConceptModel1.drl",null, KBSessionInterface.Engine.PHREAK,true);
            assert (true);
        } catch (Exception e) {
            e.printStackTrace();
            assert(false);
        }

    }

    @Test
    public void runKB()
    {
        if(kbFacilitator==null)
            initKB();
        kbFacilitator.insertToKB(getinitiatedObject4KBInsertion());
        kbFacilitator.setGloabl("checkList", checkList);
        kbFacilitator.fireAllRules();
        assertEquals(1,checkList.size());
    }

    public Observation getinitiatedObject4KBInsertion(){

        Observation bpObservation = new Observation("sct-Blood Pressure");
        Quantity sysQuantity = new Quantity(120.0f,"mmHg");
        Quantity diaQuantity = new Quantity(80.0f,"mmHg");
        Observation systolicObservation = new Observation("systolic");
        Observation diastolicObservation = new Observation("diastolic");

        systolicObservation.setValueQuantity(sysQuantity);
        diastolicObservation.setValueQuantity(diaQuantity);

        List<Related> obsList = new ArrayList<Related>(2);
        Related sysRelated = new Related(systolicObservation);
        sysRelated.setType("has systolic component");
        Related diaRelated = new Related(diastolicObservation);
        diaRelated.setType("has diastolic component");
        obsList.add(sysRelated);
        obsList.add(diaRelated);

        bpObservation.setRelated(obsList);

        return bpObservation;

    }
}
