package com.kjmaster.anima.utils;

import net.minecraft.util.IStringSerializable;

public class EnumHandler {

    public static enum MoldTypes implements IStringSerializable {
        FUNNEL("funnel", 0),
        SPLITTER("splitter", 1),
        DECANTER("decanter", 2),
        GOURD("gourd", 3),
        SPIRAL("spiral", 4);

        private int ID;
        private String name;

        MoldTypes(String name, int ID) {
            this.ID = ID;
            this.name = name;
        }

        @Override
        public String getName() {
            return this.name;
        }

        public int getID() {
            return ID;
        }
    }
}
