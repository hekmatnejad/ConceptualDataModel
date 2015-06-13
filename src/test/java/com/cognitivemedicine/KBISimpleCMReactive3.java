package com.cognitivemedicine;

import com.cognitivemedicine.conceptmodels.MockConceptModelReactive3.Observation;
import com.cognitivemedicine.conceptmodels.MockConceptModelReactive3.Quantity;
import com.cognitivemedicine.conceptmodels.MockConceptModelReactive3.Related;
import com.cognitivemedicine.util.KBFacilitator;
import drools.traits.util.KBSessionInterface;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by mhekmatnejad on 6/11/15.
 */
public class KBISimpleCMReactive3 {

    KBFacilitator kbFacilitator = null;
    List<String> checkList = new ArrayList<String>();

    @Before
    public void initKB()
    {

        System.out.println("KB initialization testing");
        try {
            kbFacilitator = new KBFacilitator(true,"simpleConceptModelReactive3.drl",null, KBSessionInterface.Engine.PHREAK,true);
            assert (true);
        } catch (Exception e) {
            e.printStackTrace();
            assert(false);
        }

    }

    @Test
    public void runKB1()
    {
        if(kbFacilitator==null)
            initKB();
        Observation observation = getinitiatedObject4KBInsertion();
        kbFacilitator.insertToKB(observation);
        kbFacilitator.setGloabl("checkList", checkList);
        int firedNum = kbFacilitator.fireAllRules();
        System.out.println(firedNum);
        assertEquals(1, checkList.size());
     }

    @Test
    public void runKB2()
    {
    }

    @Test
    public void runKB3()
    {
    }

    public Observation getinitiatedObject4KBInsertion(){

        Observation bpObservation = new Observation("sct-Blood Pressure");
        //bpObservation.setValueQuantity(new Quantity(33.0f,"TEST"));
        Quantity sysQuantity = new Quantity(120.0f,"mmHg");
        Quantity diaQuantity = new Quantity(80.0f,"mmHg");
        Observation systolicObservation = new Observation("systolic");
        Observation diastolicObservation = new Observation("diastolic");

        systolicObservation.setValueQuantity(sysQuantity);
        diastolicObservation.setValueQuantity(diaQuantity);

        List<Related> obsList = new ArrayList<Related>(2);
        Related sysRelated = new Related(systolicObservation);
        sysRelated.setType("has-component");
        Related diaRelated = new Related(diastolicObservation);
        diaRelated.setType("has-component");
        obsList.add(sysRelated);
        obsList.add(diaRelated);

        bpObservation.setRelated(obsList);

        return bpObservation;

    }
}
