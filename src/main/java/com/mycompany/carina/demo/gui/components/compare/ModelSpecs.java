package com.mycompany.carina.demo.gui.components.compare;

import java.util.HashMap;
import java.util.Map;

public class ModelSpecs {
    private Map<SpecType, String> modelSpecsMap;

    public ModelSpecs() {
        this.modelSpecsMap = new HashMap<>();
    }

    public void setToModelSpecsMap(SpecType specType, String spec) {
        this.modelSpecsMap.put(specType, spec);
    }

    public String readSpec(SpecType specType) {
        return modelSpecsMap.get(specType);
    }

    public enum SpecType {
        TECHNOLOGY("Technology"),
        ANNOUNCED("Announced");

        private String type;

        SpecType(String type) {
            this.type = type;
        }

        public String getType() {
            return type;
        }
    }
}
