package com.cognitivemedicine.conceptmodels;

import java.util.List;

/**
 * Created by mhekmatnejad on 6/11/15.
 */
public class MockConceptModelReactive1 {

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

        @Override
        public String toString() {
            String res = "<code: " + code + ", valueQuantity: " + valueQuantity;
            res += " <related: ";
            if(getRelated()!=null && getRelated().size()>0)
            for(Related rel : getRelated())
                res += " " + rel;
            res += "> ";
            return res;
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

        @Override
        public String toString() {
            String res = "<type: " + type + ", target: " + target + ">";
            return res;
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

        @Override
        public String toString() {
            String res = "<value: " + value + ", unit: " + Unit + ">";
            return res;
        }
    }

}
