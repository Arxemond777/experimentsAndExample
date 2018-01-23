package effective_java_Joshua_Bloch;


public class BuilderExample {
    public static void main(String[] args) {
        Builder builder = new Builder.BuilderInit(1).build();
        System.out.println(builder.getCount());
        System.out.println(builder.getSurName());

        Builder builder1 = new Builder.BuilderInit(2).setSurName("d").build();
        System.out.println(builder1.getCount());
        System.out.println(builder1.getSurName());
    }
}

class Builder {

    public int getCount() {
        return count;
    }

    public String getSurName() {
        String s = surName; // TODO for safety
        return s;
    }

    public static class BuilderInit {
        // Required parameters
        private final int count;

        // Optional parameters - initialized to default values
        private String surName;

        public BuilderInit(int count) {
            this.count = count;
        }

        public int getCount() {
            return count;
        }

        public BuilderInit setSurName(String surName) {
            String s = surName;
            this.surName = s;

            return this;
        }

        public Builder build() {
            return new Builder(this);
        }
    }


    private final int count;
    private final String surName;

    private Builder(BuilderInit builderInit) {
        this.count = builderInit.count;
        this.surName = builderInit.surName;
    }


}