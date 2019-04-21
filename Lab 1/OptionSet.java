class OptionSet {
    private String name;
    private Option opt[];

    protected OptionSet() {
        name = "";
        opt = null;
    }

    protected OptionSet(String name, int size) {
        this.name = name;
        opt = new Option[size];
        for (int i = 0; i < opt.length; i++) {
            opt[i] = new Option();
        }
    }

    protected String getName() {
        return name;
    }

    protected Option[] getOptions() {
        return opt;
    }

    protected void setName(String name) {
        this.name = name;
    }

    protected void setOptions(Option opt[]) {
        this.opt = opt;
    }

    protected int findOptionIndex(String name) {
        return 0; // <----------------------------------

    }

    protected Option findOption(String name) {
        return null; // <------------------------
    }

    protected Option deleteOption(String name) {
        return null; // <------------------------
    }

    protected void updateOption(String name, Option newOpt) { // <------------------------

    }

    protected void updateOptionName(String name, String newName) { // <------------------------

    }

    protected void updateOptionPrice(String name, double price) { // <------------------------

    }

    protected boolean isNull() {
        return opt.equals(null);
    }

    protected void print() { // <------------------------
        System.out.println("x");
    }

    protected class Option {
        private String optName;
        private double price;

        protected Option() {
            optName = "";
            price = 0.00;
        }

        protected Option(String optName, double price) {
            this.optName = optName;
            this.price = price;
        }

        protected String getName() {
            return optName;
        }

        protected double getPrice() {
            return price;
        }

        protected void setName(String optName) {
            this.optName = optName;
        }

        protected void setPrice(double price) {
            this.price = price;
        }

        protected void print() {
            System.out.println("Name of the feature is " + optName + " and it's price is " + price);
        }
    }
}