List<Country> europe = new ArrayList<Country>();
europe.add(new Country(81903000,357121.41,"Germany"));
europe.add(new Country(64667000,668763, "France"));
europe.add(new Country( 4985900,385199, "Norway"));
europe.add(new Country( 9514406,450295, "Sweden"));
europe.add(new Country(47212990,504645, "Spain"));
europe.add(new Country( 8014000, 41285, "Switzerland"));
europe.add(new Country(   36371,     2.02, "Monaco"));
Collections.sort(europe, new Comparator<Country>(){
    @Override
    public int compare(Country o1, Country o2) {
        double o1Density = o1.population / o1.area;
        double o2Density = o2.population / o2.area;

        if (Math.abs(o1Density - o2Density) < 0.00001) {
            return 0;
        } else if (o1Density > o2Density) {
            return 1;
        } else {
            return -1;
        }
    }
});
// Now it's sorted according to the logic in the internal comparator
System.out.println(europe);
