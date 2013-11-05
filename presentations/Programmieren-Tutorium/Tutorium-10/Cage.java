public static class Cage<T extends Animal> { 
    private Set<T> pen = new HashSet<T>();

    public void add(T animal) {
        pen.add(animal);
    }

    /* It's OK to put subclasses into a cage of 
       super class 
     */
    public void transferTo(Cage<? super T> cage) {
        cage.pen.addAll(this.pen);
    }

    public void showAnimals() {
        System.out.println(pen);
    }
}
