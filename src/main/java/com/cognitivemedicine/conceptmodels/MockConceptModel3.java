package com.cognitivemedicine.conceptmodels;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by mhekmatnejad on 6/11/15.
 */
public class MockConceptModel3 {

    public static class Observation{
        String code;
        List<Related> related;
        Quantity valueQuantity;

        public void setCode(String code) {
            this.code = code;
        }

        public void setRelated(List<Related> related) {
            this.related = related;
        }

        public void setValueQuantity(Quantity valueQuantity) {
            this.valueQuantity = valueQuantity;
        }

        public String getCode() {
            return code;
        }

        public List<Related> getRelated() {
            return related;
        }

        public Quantity getValueQuantity() {
            return valueQuantity;
        }

        public Observation(String code) {
            this.code = code;
        }

    }

    public static class Related{
        Observation target;
        String type;

        public Related(Observation target) {
            this.target = target;
        }

        public void setTarget(Observation target) {
            this.target = target;
        }

        public Observation getTarget() {
            return target;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getType() {
            return type;
        }
    }

    public static class Quantity{
        Float value;
        String Unit;

        public Quantity(Float value, String unit) {
            this.value = value;
            Unit = unit;
        }

        public void setValue(Float value) {
            this.value = value;
        }

        public void setUnit(String unit) {
            Unit = unit;
        }

        public Float getValue() {
            return value;
        }

        public String getUnit() {
            return Unit;
        }
    }

}
